package io.swagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	  
	/*
	 * @Query("select userName from User where userName=?1") public List<String>
	 * findByuserName(String userName);
	 */
	  
	
	 // @Query("select userName ,address,balance,email,contactNumber,password type from User where userName=?1" ) 
	  public User findByUserName(String userName);
	 
	 	 
}
