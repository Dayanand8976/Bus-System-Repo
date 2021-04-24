package com.lti.service;

import java.time.LocalDate;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.User;
import com.lti.exception.CustomerServiceException;
import com.lti.exception.UserServiceException;
import com.lti.repository.UserRepositoryImpl;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepositoryImpl userRepo;
	
	@Override
	public int register(User user) {
		if(userRepo.isUserPresent(user.getEmail()))
			throw new UserServiceException("User already registered!");
		else {
			user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			user.setRegistrationDate(LocalDate.now());
			user.setRegisteredUser("yes");
			User userUpdate = (User) userRepo.save(user);
			return userUpdate.getId();
		}
	}

	@Override
	public User login(String email, String password) {
		try {
			password = Base64.getEncoder().encodeToString(password.getBytes());
			int id = userRepo.fetchIdByEmailAndPassword(email, password);
			User user = userRepo.fetch(User.class, id);
			return user;
		}
		catch(EmptyResultDataAccessException e) {
		//catch(NoResultException e) {
			throw new CustomerServiceException("Invalid email/password");
		}
	}

}
