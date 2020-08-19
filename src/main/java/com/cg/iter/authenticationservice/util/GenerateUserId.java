package com.cg.iter.authenticationservice.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.authenticationservice.service.AuthService;


/**
 * Name : GenerateUserId
 * Description : Its the component that will generate the userId with random and phone number of user.
 */
@Component
public class GenerateUserId {

	@Autowired
	AuthService service;
	private static Random rand = new Random();
	
	
	public int generateUserId(String phoneno) {
		int userId = 3;
		int selected = rand.nextInt(1000);
		userId*=selected;
		userId+=Integer.parseInt(phoneno.substring(5, 7));
		return userId;
	}
	
	
}
