package com.apap.tugasakhir.service;

import java.util.Optional;

import com.apap.tugasakhir.model.LabSuppliesModel;

public interface LabSuppliesService {
	Optional<LabSuppliesModel> getLabSuppliesById(Integer id);
	void addLabSupplies(LabSuppliesModel labSupplies);

}
