package com.lti.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends GenericRepository implements UserRepository {

	@Override
	public boolean isUserPresent(String email) {
		String jpql="select count(u.id) from User u where u.email=:em";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("em", email);
		return (Long) q.getSingleResult()==1?true:false;
	}

	@Override
	public int fetchIdByEmailAndPassword(String email, String password) {
		String jpql="select u.id from User u where u.email=:em and password=:pw";
		Query q = entityManager.createQuery(jpql);
		q.setParameter("em", email);
		q.setParameter("pw", password);
		return (Integer) q.getSingleResult();
	}

}
