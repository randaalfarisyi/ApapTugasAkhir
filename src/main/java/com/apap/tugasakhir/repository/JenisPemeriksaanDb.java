package com.apap.tugasakhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tugasakhir.model.JenisModel;

import java.util.Optional;

public interface JenisPemeriksaanDb extends JpaRepository<JenisModel, Long>{
	Optional<JenisModel> findById(Long id);
}
