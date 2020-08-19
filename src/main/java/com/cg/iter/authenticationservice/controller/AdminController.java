package com.cg.iter.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.exception.NullParameterException;
import com.cg.iter.authenticationservice.exception.UserNotFoundException;
import com.cg.iter.authenticationservice.service.AdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@DeleteMapping("/deleteMac")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteMac(@RequestParam int userId) {
		if (adminService.deleteMac(userId)) {
			return "Mac deleted successfully";
		}
		throw new UserNotFoundException("Invalid Mac ID!!");
	}

	@PostMapping("/addMac")
	@PreAuthorize("hasRole('ADMIN')")
	public String addMac(@RequestBody User mac) {

		if (mac == null || mac.getUsername() == null)
			throw new NullParameterException("Please provide details of mac!");

		if (adminService.addMac(mac)) {
			return "Mac added successfully";
		}
		return "fail to add Mac!!";
	}

	@GetMapping("/viewAllMac")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> viewAllMac() {
		return adminService.viewAllMacs();

	}

	@GetMapping("/validate")
	@PreAuthorize("hasRole('ADMIN')")
	public String isAdmin() {
		return "I am admin";
	}

}
