package com.apap.tugasakhir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.apap.tugasakhir.model.LabSuppliesModel;
import com.apap.tugasakhir.repository.LabSuppliesDb;

@Service
@Transactional
public class LabSuppliesServiceImpl implements LabSuppliesService {
	@Autowired
	private LabSuppliesDb labSuppliesDb;
	
	@Override
	public Optional<LabSuppliesModel> getLabSuppliesById(Integer id) {
		return labSuppliesDb.findById(id);
	}
	
	@Override
	public void addLabSupplies(LabSuppliesModel labSupplies) {
		labSuppliesDb.save(labSupplies);
	}

}
