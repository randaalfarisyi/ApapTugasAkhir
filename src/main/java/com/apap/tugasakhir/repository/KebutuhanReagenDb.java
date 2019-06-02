package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.KebutuhanReagenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KebutuhanReagenDb extends JpaRepository<KebutuhanReagenModel, Long> {

}
