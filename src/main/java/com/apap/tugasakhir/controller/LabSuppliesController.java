package com.apap.tugasakhir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.service.LabSuppliesService;

@Controller
public class LabSuppliesController {
	@Autowired
	private LabSuppliesService labSuppliesService;
	
	@RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.GET)
	private String addLabSupplies(Model model) {
		model.addAttribute("lab_supplies", new LabSuppliesModel());
		return "addLabSupplies";
	}
	
	@RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.POST)
	private String addLabSuppliesSubmit(@ModelAttribute LabSuppliesModel labSupplies) {
		labSuppliesService.addLabSupplies(labSupplies);
		return "addSuppliesSuccess";
	}
	
	@RequestMapping(value = "/lab/stok", method = RequestMethod.GET)
    private String viewLabSupplies(@RequestParam(value = "id") int id, Model model) {
        Optional<LabSuppliesModel> archiveLabSupplies = labSuppliesService.getLabSuppliesById(id);
        model.addAttribute("lab_supplies", archiveLabSupplies.get());
        return "viewLabSupplies";
    }
}
