package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.Wallet;


@Repository
public class WalletRepositoryImpl extends GenericRepository implements WalletRepository{

	public int fetchIdByEmail(String email) {
		//select wallet.balance from wallet inner join users on users.id=wallet.user_id where users.email='akshata@gmail.com';
		 
		String jpql ="select w.id from Wallet w INNER JOIN w.user u where u.email=:email ";
		Query q =entityManager.createQuery(jpql);
		q.setParameter("email",email);
		int id = (Integer)q.getSingleResult();
		return id;
	}
	
	public List<Object[]> TotalFare (int UserId){
		String jpql="Select count(t.id),u.id,r.fare From Ticket t join t.timetable tt"
				+ " join tt.bus b join b.route r join t.user u where u.id=:id";
		Query q =entityManager.createQuery(jpql);
		q.setParameter("id",UserId);
		return q.getResultList();
		
	}

	
}
