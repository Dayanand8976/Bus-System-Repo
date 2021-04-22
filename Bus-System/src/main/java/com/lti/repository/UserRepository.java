package com.lti.repository;

public interface UserRepository {

	public boolean isUserPresent(String email);
	public int fetchIdByEmailAndPassword(String email, String password);
}
