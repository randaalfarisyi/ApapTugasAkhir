package com.apap.tugasakhir.repository;

import com.apap.tugasakhir.model.PemeriksaanModel;
import com.apap.tugasakhir.rest.Pasien;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabDB extends JpaRepository<PemeriksaanModel, Long> {
    PemeriksaanModel findByPasien(Pasien pasien);
    List<PemeriksaanModel> findAll();
}