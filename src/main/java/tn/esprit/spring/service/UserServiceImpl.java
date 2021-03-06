package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bytebuddy.utility.RandomString;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	public boolean verify(String verificationCode) {
	    User user = userRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isActivated()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setActivated(true);
	        userRepository.save(user);
	         
	        return true;
	    }
	     
	}
	@Autowired
	SujetService sujetservice;
	public List<Sujet> allSubject() {
		return sujetservice.getAll();
		
		} 
	
	public List<User> getAll() {                       
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user1 -> users.add(user1));
		return users;
	}
	
	
	public User getuserconnected(){
		System.err.println(UserConnected.iduser);
		return userRepository.findById(UserConnected.iduser).get();
	}
	
	public User findById(Long id){
		return userRepository.findById(id).get();
	}
	
	public boolean chackact(String user){
		if(userRepository.Checkactivation(user)==true)
			return true;
		return false;
	}
	public User UpdateProfile(User u){
		return userRepository.save(u);
		
	}
	public String Logout(){
		UserConnected.iduser=(long) -1;
		UserConnected.userconnected=null;
		System.err.println("west logout serice");
		return "logout succefully";
		
	}
	public void delete(User u) {
		userRepository.delete(u);
	}
	public User findbyemail(String mail){
		return userRepository.findByEmail(mail);
				
	}
	public int resetpwd(String pwd, String vc){
		
		return userRepository.updatepwd(pwd, vc);
		
	}
	

}
