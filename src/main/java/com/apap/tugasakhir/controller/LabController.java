package com.apap.tugasakhir.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.model.PemeriksaanModel;
import com.apap.tugasakhir.service.LabService;

@Controller
public class LabController {
	@Autowired
	private LabService labService;
	
	@RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
	private String add(Model model) {
		List <PemeriksaanModel> listPemeriksaan = labService.findAll();
		model.addAttribute("listPermintaan", new PemeriksaanModel());
		return "permintaanPemeriksaanLab";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.POST)
	private String addPermintaanSubmit (@ModelAttribute PemeriksaanModel permintaan) {
		labService.addPermintaan(permintaan);
		return "permintaanPemeriksaanLab";
	}	
}