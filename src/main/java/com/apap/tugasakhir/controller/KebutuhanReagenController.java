package com.apap.tugasakhir.controller;

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
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
	private String addKebutuhanReagen(Model model) {
		model.addAttribute("kebutuhanReagen", new KebutuhanReagenModel());
		return "addKebutuhanReagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
	private String addKebutuhanReagenSubmit(@ModelAttribute KebutuhanReagenModel kebutuhanReagen) {
		kebutuhanReagenService.addReagen(kebutuhanReagen);
		return "addSuccess";
	}

}
