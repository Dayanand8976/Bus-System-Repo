package com.lti.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.Route;
import com.lti.entity.Timetable;
import com.lti.entity.User;
import com.lti.exception.AdminException;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	@PersistenceContext
	private EntityManager manager;
	//----------------------------------user
	@Override
	public List<User> getUserList() throws AdminException {
		// TODO Auto-generated method stub
		String strQry ="from User";
		Query qry = manager.createQuery(strQry);
		List<User> list=qry.getResultList();
		return (List<User>) list ;
		
	}
	//------------------------------------admin
	@Override
	public Admin getAdminById(String email) throws AdminException {
	
		return manager.find(Admin.class, email);
	}
	@Override
	public List<Admin> getAdminLoginDetail(String email, String psw) throws AdminException {
		Query query = manager.createQuery("SELECT a FROM Admin a WHERE a.email =:email and a.password=:psw" , Admin.class);
		query.setParameter("email", email);
		query.setParameter("psw", psw);
		List<Admin> admin =  query.getResultList();
		return admin;
	}
	//---------------------------------------bus
	@Override
	public List<Bus> getBusList() throws AdminException {
		String strQry ="from Bus";
		Query qry = manager.createQuery(strQry);
		List<Bus> list=qry.getResultList();
		return list;
	}
	@Override
	public Bus getBusById(String bid) throws AdminException {
		return manager.find(Bus.class, bid);
	}
	@Override
	public boolean addBus(Bus bus, int id) throws AdminException {
		Route r = manager.find(Route.class, id);
		bus.setRoute(r);
		manager.persist(bus);
		return true;
	}
	@Override
	public boolean deleteBus(int busId) throws AdminException {
		Bus bus = manager.find(Bus.class, busId);
		manager.remove(bus);
		return true;
	}
	//--------------------------------------------timetable
	@Override
	public List<Timetable> getTimetable() throws AdminException {
		String strQry ="from Timetable";
		Query qry = manager.createQuery(strQry);
		List<Timetable> list=qry.getResultList();
		return list;
	}
//	@Override
//	public boolean addTimetable(int timetableId, String dateTime, Bus bus, Route route) throws AdminException {
//		Timetable t= new Timetable();
//		t.setId(timetableId);
//		try {
//			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
//			t.setDepartureDateTime(date);
//		} catch (ParseException e) {
//			System.out.println("Error in date");
//			e.printStackTrace();
//		}
//		t.setBus(bus);
//		
//		t.setRoute(route);
//		manager.persist(t);
//		return true;
//	}
//	@Override
//	public boolean updateTimetable(int timetableId, String dateTime, Bus bus, Route route) throws AdminException {
//		Timetable t= new Timetable();
//		t.setId(timetableId);
//		try {
//			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
//			t.setDepartureDateTime(date);
//		} catch (ParseException e) {
//			System.out.println("Error in date");
//			e.printStackTrace();
//		}
//		t.setBus(bus);
//		t.setRoute(route);
//		manager.merge(t);
//		return true;
//	}
//	@Override
//	public Timetable findTimeTable(String id) throws AdminException {
//		Timetable timeTable=manager.find(Timetable.class, id);
//		return timeTable ;
//	}
//	//------------------------------------------route
	@Override
	public List<Route> getRouteList() throws AdminException {
		String strQry ="from Route";
		Query qry = manager.createQuery(strQry);
		List<Route> list=qry.getResultList();
		return list;
	}
//	@Override
//	public Route getRouteById(long rid) throws AdminException {
//		return manager.find(Route.class, rid);
//	}
	@Override
	public boolean addRoute(Route route) throws AdminException {
		manager.persist(route);
		return true;
	}
//	@Override
//	public void updateRoutes(Route route) throws AdminException {
//		manager.merge(route);
//		
//	}
	@Override
	public boolean deleteRoute(int routeId) throws AdminException {
		Route route = manager.find(Route.class, routeId);
		manager.remove(route);
		return true;
	}
	
	
	

}
