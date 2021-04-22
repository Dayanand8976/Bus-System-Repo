package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Timetable;
import com.lti.entity.User;
import com.lti.exception.AdminException;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	//----------------------------------user
	//http://localhost:8777/user
	@GetMapping("/user")
	public @ResponseBody List<User> userList() throws AdminException
	{
		return adminService.getUserList();
	}
	//------------------------------------admin
	//http://localhost:8777/adminLogin/{email}/{psw}
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
	//http://localhost:8777/busesList
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
	// http://localhost:8777/addBus/{id}
	@PostMapping(value="/addBus/{id}", consumes="application/json")
	public boolean addBus(@RequestBody Bus bus, @PathVariable int id) {
		
	boolean val = false;
	try {
	val = adminService.addBus(bus, id);
	} catch (AdminException e) {
		System.out.println("Error in adding Bus");
		e.printStackTrace();
	}	
	return val;
	}
	
	//Delete Bus
	// http://localhost:8777/deleteBus/{bId}
	@DeleteMapping("/deleteBus/{bId}")
	public boolean deleteBus(@PathVariable int bId) {
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
	//-------------------------------------timetable
	
//	@GetMapping(value = "/addTimetable/{tid}/{dateTime}/{busid}/{routeid}/{driverid}")
//	public boolean addTimetable(@PathVariable(value = "tid") String tid,
//			@PathVariable(value = "dateTime") String dateTime,
//			@PathVariable(value = "busid") String busid,
//			@PathVariable(value = "routeid") long routeid) {
//			boolean record=false;
//			try {
//				Bus bus=adminService.getBusById(busid);
//				Route route=adminService.getRouteById(routeid);
//				record=adminService.addTimetable(tid, dateTime, bus, route);
//			} catch (AdminException e) {
//				System.out.println("Error at controller");
//				e.printStackTrace();
//			}
//			
//			return record;
//	}
//	
//	@GetMapping(value = "/updateTimetable/{tid}/{dateTime}/{busid}/{routeid}")
//	public boolean updateTimetable(@PathVariable(value = "tid") String tid,
//			@PathVariable(value = "dateTime") String dateTime,
//			@PathVariable(value = "busid") String busid,
//			@PathVariable(value = "routeid") long routeid ) {
//			boolean record=false;
//			try {
//				Bus bus=adminService.getBusById(busid);
//				Route route=adminService.getRouteById(routeid);
//				record=adminService.updateTimetable(tid, dateTime, bus, route);
//			} catch (AdminException e) {
//				System.out.println("Error at controller");
//				e.printStackTrace();
//			}
//			
//			return record;
//	}
//	
	//http://localhost:8777/findTimeTable/1
	@GetMapping(value = "/timetable",produces = "application/json")
	public List<Timetable> getTimetable(){
		List<Timetable> Timetable=null;
		try {
			Timetable=adminService.getTimetable();
		} catch (AdminException e) {
			System.out.println("Error occured at Controller");
			e.printStackTrace();
		}
		return Timetable;
	}

//	//----------------------------------route
//	//Get Routes List
//	// http://localhost:8777/routesList
	@GetMapping(value = "/routesList",produces = "application/json")
	public List<Route> getRouteList(){
				List<Route> routeList=null;
				try {
					routeList=adminService.getRouteList();
				} catch (AdminException e) {
					System.out.println("Error occured at Controller");
					e.printStackTrace();
				}
				return routeList;
			}
//			
			//Add Route
			// http://localhost:8777/addRoute
			@PostMapping(value="/addRoute", consumes="application/json")
			public boolean addRoute(@RequestBody Route route) {	
				boolean val = false;
				try {
				val = adminService.addRoute(route);
				} catch (AdminException e) {
					System.out.println("Error in adding Route");
					e.printStackTrace();
				}	
				return val;
			}
//			
//			//Update route
//			//http://localhost:8777/updateRoute/227
//			@PutMapping(value="/updateRoute/{id}",consumes="application/json")
//				public void updateRoute(@PathVariable long id, @RequestBody Route route)
//				{
//					route.setRouteId(id);
//					try {
//						adminService.updateRoutes(route);
//					} catch (AdminException e) {
//						System.out.println("error while updating");
//						e.printStackTrace();
//					}
//
//				}
//			
			//Delete Route BY ID
			// http://localhost:8777/deleteRoute/{routeId}
			@DeleteMapping("/deleteRoute/{routeId}")
			public boolean deleteRoutes(@PathVariable int routeId) {
				boolean Record = false;
				try {
					Record=adminService.deleteRoute(routeId);
				} 
				catch (AdminException e) {
					System.out.println("Error in deleting routes");
					e.printStackTrace();
				}
				return Record;
			}
//			
//			//http://localhost:8777/findRoute/111
//			@GetMapping(value="/findRoute/{rid}")
//			public Route findRouteById(@PathVariable long rid)
//				{
//					Route route = null;
//					try {
//						route = adminService.getRouteById(rid);
//					} catch (AdminException e) {
//						System.out.println("error while finding route id");
//						e.printStackTrace();
//					}
//					return route;
//				}
}
