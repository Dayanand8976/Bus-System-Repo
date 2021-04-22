package com.lti.service;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Timetable;
import com.lti.entity.User;
import com.lti.exception.AdminException;

public interface AdminService {
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
//			//TimeTable
			public  List<Timetable> getTimetable() throws AdminException;
//			public  boolean addTimetable(String timetableId,String dateTime,Bus bus,Route route) throws AdminException;
//			public  boolean updateTimetable(String timetableId,String dateTime,Bus bus,Route route) throws AdminException;
//			public Timetable findTimeTable(String id) throws AdminException;
//			
//			//Routes
			public abstract List<Route> getRouteList() throws AdminException;
//			public abstract Route getRouteById(long rid) throws AdminException;
			public abstract boolean addRoute(Route route) throws AdminException;
//			public abstract void updateRoutes(Route route) throws AdminException;
			public abstract boolean deleteRoute(int routeId) throws AdminException;

}
