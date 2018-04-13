package com.ashwin.myapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.ashwin.myapplication.model.User;
import com.ashwin.myapplication.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private final UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> showAllUsers(){
		List<User> users=new ArrayList<User>();
		for(User user:userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> editMyUser(int id) {
	    return userRepository.findById(id);
	}
	
	public User findByUsernameandPassword(String userName,String passWord)
	{
		return userRepository.findByUsernameAndPassword(userName, passWord);
	}
}
