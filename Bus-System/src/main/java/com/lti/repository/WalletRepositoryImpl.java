package com.lti.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Passenger;
import com.lti.entity.Ticket;
import com.lti.entity.Wallet;


@Repository
public class WalletRepositoryImpl extends GenericRepository implements WalletRepository{
	
   @Autowired
   GenericRepository genericRepository;
	
	public int fetchIdByEmail(String email) {
		
		String jpql ="select w.id from Wallet w INNER JOIN w.user u where u.email=:email ";
		Query q =entityManager.createQuery(jpql);
		q.setParameter("email",email);
		int id = (Integer)q.getSingleResult();
		return id;
	}
	
	public List<Object[]> TotalFare (int UserId){
		
		String jpql="Select t.id,b.name,r.source,r.destination,tt.startDate,u.firstName,u.lastName,r.fare From Ticket t join t.timetable tt"
				+ " join tt.bus b join b.route r join t.user u  where u.id=:id";
		Query q =entityManager.createQuery(jpql);
		q.setParameter("id",UserId);
		return q.getResultList();
	}
	
   
  /* public void deleteWallet(int wid) {
	    String jpql="delete Wallet w where w.id=:wid";
	    Query q = entityManager.createQuery(jpql);
		q.setParameter("wid", wid);
	    q.executeUpdate();
	}*/

   @Override
   public int fetchById(int uid) {
	   String jpql ="select w.balance from Wallet w INNER JOIN w.user u where u.id=:uid ";
	   Query q =entityManager.createQuery(jpql);
	   q.setParameter("uid",uid);
	   return (Integer) q.getSingleResult();
   }

   
   
   
 
   
}
  
 
   
   
	

