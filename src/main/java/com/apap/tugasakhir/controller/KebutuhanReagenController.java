package com.apap.tugasakhir.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.apap.tugasakhir.model.KebutuhanReagenModel;
import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.service.KebutuhanReagenService;
import com.apap.tugasakhir.service.LabSuppliesService;

@Controller
public class KebutuhanReagenController {
	@Autowired
	private KebutuhanReagenService kebutuhanReagenService;
	
	@Autowired
	private LabSuppliesService labSuppliesService;
	
	/**@RequestMapping(value = "/lab/kebutuhan/{id_reagen}", method = RequestMethod.GET)
	private String addKebutuhanReagen(@PathVariable(value="id_reagen") int id_reagen, Model model) {
		KebutuhanReagenModel kebutuhanReagen = new KebutuhanReagenModel();
		LabSuppliesModel labSupplies = labSuppliesService.getLabSuppliesById(id_reagen);
		kebutuhanReagen.setIdReagen(labSupplies);
		model.addAttribute("kebutuhan_reagen", kebutuhanReagen);
		return "addKebutuhanReagen";
	}*/
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
	private String addKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen) {
		kebutuhanReagenService.addReagen(kebutuhanReagen);
		return "addReagenSuccess";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/{id_reagen}", method = RequestMethod.GET)
    private String addKebutuhanReagen(@PathVariable(value = "id") Integer id, Model model) {
        LabSuppliesModel labSupplies= labSuppliesService.getLabSuppliesById(id).get();
        labSupplies.setSuppliesReagen(new ArrayList<KebutuhanReagenModel>() {
            private ArrayList<KebutuhanReagenModel> init(){
                this.add(new KebutuhanReagenModel());
                return this;
            }
        }.init());

        model.addAttribute("lab_supplies", labSupplies);
        return "addKebutuhanReagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/{id_reagen}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@ModelAttribute LabSuppliesModel labSupplies, Model model) {
        labSupplies.getSuppliesReagen().add(new KebutuhanReagenModel());
        model.addAttribute("lab_supplies", labSupplies);
        return "addKebutuhanReagen";
    }

    @RequestMapping(value="/lab/kebutuhan/{id_reagen}", method = RequestMethod.POST, params={"removeRow"})
    public String removeRow(@ModelAttribute LabSuppliesModel labSupplies, Model model, HttpServletRequest req) {
        Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        labSupplies.getSuppliesReagen().remove(rowId.intValue());
        
        model.addAttribute("lab_supplies", labSupplies);
        return "addKebutuhanReagen";
    }

    @RequestMapping(value = "/lab/kebutuhan/{id_reagen}", method = RequestMethod.POST, params={"save"})
    private String addKebutuhanReagenSubmit(@ModelAttribute LabSuppliesModel labSupplies) {
        Optional<LabSuppliesModel> archive = labSuppliesService.getLabSuppliesById(labSupplies.getId());
        for (KebutuhanReagenModel kebutuhanReagen : labSupplies.getSuppliesReagen()) {
            if (kebutuhanReagen != null) {
                kebutuhanReagen.setIdReagen(archive);
                kebutuhanReagenService.addReagen(kebutuhanReagen);
            }
        }
        return "add";
    }

}
