package com.ashwin.myapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.ashwin.myapplication.model.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	public User findByUsernameAndPassword(String userName,String passWord);

}
