package com.cg.iter.authenticationservice.service;

import java.util.List;

import com.cg.iter.authenticationservice.entity.User;

public interface AdminService {

	
	

	/****************************************************************************************************************************************
	 * - Function Name : deleteMacr <br>
	 * - Description : Only admin remove a mac. Method returns a boolean. <br>
	 * 
	 * @param int userId
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean deleteMac(int userId);

	
	
	/****************************************************************************************************************************************
	 * - Function Name : addProductMaster <br>
	 * - Description : Only admin can delete a product master. Method return a boolean. <br>
	 * 
	 * @param User user
	 * @return boolean
	 ****************************************************************************************************************************************/
	boolean addMac(User user);

	
	

	/****************************************************************************************************************************************
	 * - Function Name : viewAllMac <br>
	 * - Description : Only admin can view the list of product masters. Method returns a list. <br>
	 * 
	 * @return List<User>
	 ****************************************************************************************************************************************/
	List<User> viewAllMacs();

}
