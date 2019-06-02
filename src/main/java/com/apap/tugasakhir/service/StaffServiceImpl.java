package com.apap.tugasakhir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.StaffModel;
import com.apap.tugasakhir.repository.StaffDb;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDb staffDb;
	
	@Override
	public StaffModel addStaff(StaffModel staf) {
		return staffDb.save(staf);
	}
	
	
	@Override
	public List<StaffModel> getAllStaff() {
<<<<<<< HEAD
=======
		System.out.println("hahahahaha");
>>>>>>> 82680e8599346c86baf9f305093aa3ea1dd59c03
		return staffDb.findAll();
	}

	

}
