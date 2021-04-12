package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.RoleService;
import tn.esprit.spring.service.UserService;

@RestController
public class UserController {
@Autowired 
UserService userService;
@Autowired
RoleService roleService;

@GetMapping("/retrieve-all-users")
@ResponseBody
public List<User> getUsers(){
	List<User> user = userService.retrieveAllUsers();
	return user;
}

@GetMapping("/retrieve-user/{id}")
@ResponseBody
public User getUserById(@PathVariable("id") String id_user){
	return userService.retrieveUser(id_user);
}
@PostMapping("/add-user")
@ResponseBody
public String addUser(@RequestBody User u){
	Role r= roleService.addRole(u.getRole());
	User user= userService.addUser(u);
	return "this is user:"+user+"and this is his role:"+r ;
}

@DeleteMapping("/delete-user")
@ResponseBody
public void deleteUser(@PathVariable("id") String id_user){
	userService.deleteUser(id_user);
}

@PutMapping("/update-user")
@ResponseBody
public User UpdateUser(@RequestBody User user){
	return userService.updateUser(user);
}




}
