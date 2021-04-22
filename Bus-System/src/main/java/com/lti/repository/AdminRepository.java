package com.lti.repository;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Timetable;
import com.lti.entity.User;
import com.lti.exception.AdminException;



public interface AdminRepository {
	
	    //User
		public List<User> getUserList() throws AdminException;
		
		//Login
		public  Admin getAdminById(String email) throws AdminException;
		public  List<Admin> getAdminLoginDetail(String email, String psw) throws AdminException;
		
		//Bus
		public  List<Bus> getBusList() throws AdminException;
		public  Bus getBusById(String bid) throws AdminException;
		public  boolean addBus(Bus bus, int id) throws AdminException;
		public  boolean deleteBus(int busId) throws AdminException;
//		
		//TimeTable
		public  List<Timetable> getTimetable() throws AdminException;
//		public  boolean addTimetable(int timetableId,String dateTime,Bus bus,Route route) throws AdminException;
//		public  boolean updateTimetable(int timetableId,String dateTime,Bus bus,Route route) throws AdminException;
//		public Timetable findTimeTable(String id) throws AdminException;
//		
//		//Routes
		public  List<Route> getRouteList() throws AdminException;
//		public  Route getRouteById(long rid) throws AdminException;
		public  boolean addRoute(Route route) throws AdminException;
//		public  void updateRoutes(Route route) throws AdminException;
		public  boolean deleteRoute(int routeId) throws AdminException;
		
}



