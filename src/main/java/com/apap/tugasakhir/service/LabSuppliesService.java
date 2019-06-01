package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.LabSuppliesModel;

public interface LabSuppliesService {
	LabSuppliesModel getLabSuppliesById(int id);
	void addLabSupplies(LabSuppliesModel labSupplies);

}
