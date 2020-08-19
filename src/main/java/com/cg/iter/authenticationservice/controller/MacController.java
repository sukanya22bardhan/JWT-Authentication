package com.cg.iter.authenticationservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/mac")
public class MacController {
	
	
	@PostMapping("/validate")
	@PreAuthorize("hasRole('MAC')")
	public String isMac() {
		return "authenticated mac user";
	}
}
