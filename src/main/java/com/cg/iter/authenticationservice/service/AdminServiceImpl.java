package com.cg.iter.authenticationservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.iter.authenticationservice.entity.EmployeeRole;
import com.cg.iter.authenticationservice.entity.User;
import com.cg.iter.authenticationservice.repository.UserRepository;
import com.cg.iter.authenticationservice.util.Validator;



@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	Validator validator;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthService authService;
	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : deleteMacr
	 * - Description : Only admin remove a mac. Method returns a boolean.
	 * 
	 * @param int userId
	 * @return boolean
	 ****************************************************************************************************************************************/
	@Override
	public boolean deleteMac(int userId) {
		userRepository.deleteById(userId);;
		return true;
	}

	
	
	/****************************************************************************************************************************************
	 * - Function Name : addMac 
	 * - Description : Only admin can add MAC. Method return a boolean.
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	@Override
	public boolean addMac(User user) {
		validator.checkPassword(user.getPassword());
		validator.checkPhoneNumber(user.getPhoneno());
		Set<String> roles = new HashSet<>();
		roles.add(EmployeeRole.ROLE_MAC.toString());
		user.setRoles(roles);
		authService.addUser(user);
		return true;
	}

	
	
	
	/****************************************************************************************************************************************
	 * - Function Name : viewAllMac 
	 * - Description : Only admin can view the list of product masters. Method returns a list.
	 * 
	 * @return List<User>
	 ****************************************************************************************************************************************/
	@Override
	public List<User> viewAllMacs() {
		List<User> resultList = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		
		Iterator<User> itr = allUsers.iterator();
		
		int index = 0;
		
		while (itr.hasNext()) {
			
			if(allUsers.get(index).getRoles().contains(EmployeeRole.ROLE_MAC.toString())) {
				resultList.add(allUsers.get(index));
			}
			index++;
			itr.next();
		}
		return resultList;
	}

}
