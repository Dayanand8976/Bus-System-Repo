package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Bus;
import com.lti.entity.User;
import com.lti.exception.AdminException;
import com.lti.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<User> getUserList() throws AdminException {
		// TODO Auto-generated method stub
		return adminRepository.getUserList();
	}

	@Override
	public Admin getAdminById(String email) throws AdminException {
		return adminRepository.getAdminById(email);
		
	}

	@Override
	public List<Admin> getAdminLoginDetail(String email, String psw) throws AdminException {
		return adminRepository.getAdminLoginDetail(email, psw);
	}

	@Override
	public List<Bus> getBusList() throws AdminException {
		return adminRepository.getBusList();
	}

	@Override
	public Bus getBusById(String bid) throws AdminException {
		return adminRepository.getBusById(bid);
	}

	@Override
	public boolean addBus(Bus bus) throws AdminException {
		return adminRepository.addBus(bus);
	}

	@Override
	public boolean deleteBus(String busId) throws AdminException {
		return adminRepository.deleteBus(busId);
	}
	
}
