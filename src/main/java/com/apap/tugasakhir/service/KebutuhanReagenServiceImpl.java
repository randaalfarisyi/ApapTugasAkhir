package com.apap.tugasakhir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.KebutuhanReagenModel;
import com.apap.tugasakhir.repository.KebutuhanReagenDb;

@Service
@Transactional
public class KebutuhanReagenServiceImpl implements KebutuhanReagenService {
	@Autowired
	private KebutuhanReagenDb kebutuhanReagenDb;
	
	@Override
	public void addReagen(KebutuhanReagenModel kebutuhanReagen) {
		kebutuhanReagenDb.save(kebutuhanReagen);
	}
	
	

}
