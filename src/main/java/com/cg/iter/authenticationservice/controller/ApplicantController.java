package com.cg.iter.authenticationservice.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/applicant")
public class ApplicantController {
	
	@PostMapping("/validate")
	@PreAuthorize("hasRole('APPLICANT')")
	public String isApplicant() {
		
		return "authenticated applicant";
	}
}
