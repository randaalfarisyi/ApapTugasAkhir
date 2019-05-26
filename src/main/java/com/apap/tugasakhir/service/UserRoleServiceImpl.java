package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.UserRoleModel;
import com.apap.tugasakhir.repository.UserRoleDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDB userDb;

    @Override
    public UserRoleModel addUser(UserRoleModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }
    
    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
    
    @Override
	public UserRoleModel findUserByUsername(String username) {
		return userDb.findByUsername(username);
	}
    
    @Override
	public boolean validateOldPassword(UserRoleModel user, String oldPassword) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(oldPassword, user.getPassword());
	}

    
}