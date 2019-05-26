package com.apap.tugasakhir.controller;

import com.apap.tugasakhir.model.UserRoleModel;
import com.apap.tugasakhir.repository.UserRoleDB;
import com.apap.tugasakhir.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserRoleController {
    @Autowired
    private UserRoleService userService;
    
    String regex = "(?=.*[0-9])(?=.*[a-zA-Z]).{8,}";

    @Autowired
    private UserRoleDB userRoleDb;

    //untuk method add user
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserRoleModel user){
    	userService.addUser(user);
        return "home";
    }
    
//    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
//	private String updatePassword() {
//		return "update-password";
//	}
    
    @RequestMapping(value="/updatePassword", method=RequestMethod.POST)
    private String updatePasswordSubmit(String newPassword, 
    		String confirmPassword,
    		Model model, String oldPassword, String username) {
    	UserRoleModel user = userService.findUserByUsername(username);
    	
    	if (userService.validateOldPassword(user, oldPassword)) {
    		if (newPassword.equals(confirmPassword)) {
    				user.setPassword(newPassword);
    				userService.addUser(user);
    				model.addAttribute	("message", "password has been updated!");
    		} else {
    				model.addAttribute("message", "you have "
    						+ "inputted the wrong new password");
    		}
    	} else {
    		model.addAttribute("message", "password lama salah");
    	}
    	return "home";
    }

}