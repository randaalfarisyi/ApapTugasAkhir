package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.LabSuppliesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabSuppliesDb extends JpaRepository<LabSuppliesModel, Long> {
	LabSuppliesModel findById(int id);

}
