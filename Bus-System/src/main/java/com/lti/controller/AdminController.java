package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.User;
import com.lti.exception.AdminException;

import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	//----------------------------------user
	@GetMapping("/user")
	public @ResponseBody List<User> userList() throws AdminException
	{
		return adminService.getUserList();
	}
	//------------------------------------admin
	@GetMapping(value = "/adminLogin/{email}/{psw}")
	public List<Admin> getAdminLoginDetail(@PathVariable(value = "email") String email,@PathVariable(value = "psw") String psw) {
	List<Admin> admin = null;
		try {
			admin = adminService.getAdminLoginDetail(email, psw);
			} catch (AdminException e) {
			System.out.println("Error in User");
		e.printStackTrace();
		}
	return admin;
	}
	//-----------------------------------bus
	@GetMapping(value = "/busesList",produces = "application/json")
	public List<Bus> getBusList(){
		List<Bus> busesList=null;
		try {
			busesList=adminService.getBusList();
		} catch (AdminException e) {
			System.out.println("Error occured at Controller");
			e.printStackTrace();
		}
		return busesList;
	}
	
	//Add Bus
	// http://localhost:8777/admin/v1/addBus/{btId}
//	@PostMapping(value="/addBus/{btId}", consumes="application/json")
//	public boolean addBus(@RequestBody Bus bus ,@PathVariable(value = "btId") long btId) {	
//	boolean newRecord = false;
//	BusTypeRate busType=new BusTypeRate();
//	try {
//		busType = adminService.getBusTypeById(btId);
//		bus.setBusTypeRate(busType);
//		newRecord=adminService.addBus(bus);
//	} catch (AdminException e) {
//		System.out.println("Error in adding Bus");
//		e.printStackTrace();
//	}	
//	return newRecord;
//	}
	
	//Delete Bus
	// http://localhost:8777/admin/v1/deleteBus/{bId}
	@DeleteMapping("/deleteBus/{bId}")
	public boolean deleteBus(@PathVariable String bId) {
		boolean Record = false;
		try {
			Record=adminService.deleteBus(bId);
		} 
		catch (AdminException e) {
			System.out.println("Error in deleting routes");
			e.printStackTrace();
		}
		return Record;
	}

}
