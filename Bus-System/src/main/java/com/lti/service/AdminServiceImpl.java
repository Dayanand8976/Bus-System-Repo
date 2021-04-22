package com.lti.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Timetable;
import com.lti.entity.User;
import com.lti.exception.AdminException;

import com.lti.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	//---------------------------------------------user
	@Override
	public List<User> getUserList() throws AdminException {
		// TODO Auto-generated method stub
		return adminRepository.getUserList();
	}
	//---------------------------------------------admin
	@Override
	public Admin getAdminById(String email) throws AdminException {
		return adminRepository.getAdminById(email);
		
	}
	
	@Override
	public List<Admin> getAdminLoginDetail(String email, String psw) throws AdminException {
		return adminRepository.getAdminLoginDetail(email, psw);
	}
	//------------------------------------------bus
	@Override
	public List<Bus> getBusList() throws AdminException {
		return adminRepository.getBusList();
	}

	@Override
	public Bus getBusById(String bid) throws AdminException {
		return adminRepository.getBusById(bid);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean addBus(Bus bus, int id) throws AdminException {
		return adminRepository.addBus(bus , id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBus(int busId) throws AdminException {
		return adminRepository.deleteBus(busId);
	}
	//------------------------------------------timetable
	@Override
	public List<Timetable> getTimetable() throws AdminException {
		return adminRepository.getTimetable();
	}
//	@Override
//	public boolean addTimetable(String timetableId, String dateTime, Bus bus, Route route) throws AdminException {
//		return adminRepository.addTimetable(timetableId, dateTime, bus, route);
//	}
//	@Override
//	public boolean updateTimetable(String timetableId, String dateTime, Bus bus, Route route) throws AdminException {
//		return adminRepository.updateTimetable(timetableId, dateTime, bus, route);
//	}
//	@Override
//	public Timetable findTimeTable(String id) throws AdminException {
//		return adminRepository.findTimeTable(id);
//	}
//	
//	//-------------------------------------route
	@Override
	public List<Route> getRouteList() throws AdminException {
		return adminRepository.getRouteList();
	}
//	@Override
//	public Route getRouteById(long rid) throws AdminException {
//		return adminRepository.getRouteById(rid);
//	}
	@Override
	public boolean addRoute(Route route) throws AdminException {
		return adminRepository.addRoute(route);
	}
//	@Override
//	public void updateRoutes(Route route) throws AdminException {
//		adminRepository.updateRoutes(route);
//		
//	}
//	@Override
//	public boolean deleteRoute(Long routeId) throws AdminException {
//		return adminRepository.deleteRoute(routeId);
//	}
	
}
