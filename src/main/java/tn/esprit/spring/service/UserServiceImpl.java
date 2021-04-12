package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository ;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() {
		List<User> users=(List<User>) userRepository.findAll();
		for(User user: users){
			l.info("user list : "+ user);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(String id_user) {
		userRepository.deleteById(Long.parseLong(id_user));
		
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(String id_user) {
		return null;

	}

	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
