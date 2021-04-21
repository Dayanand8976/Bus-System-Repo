package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.User;
import com.lti.exception.AdminException;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<User> getUserList() throws AdminException {
		// TODO Auto-generated method stub
		String strQry ="from User";
		Query qry = manager.createQuery(strQry);
		List<User> list=qry.getResultList();
		return (List<User>) list ;
		
	}
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
	public boolean addBus(Bus bus) throws AdminException {
		manager.persist(bus);
		return true;
	}
	@Override
	public boolean deleteBus(String busId) throws AdminException {
		Bus bus = manager.find(Bus.class, busId);
		manager.remove(bus);
		return true;
	}
	

}
