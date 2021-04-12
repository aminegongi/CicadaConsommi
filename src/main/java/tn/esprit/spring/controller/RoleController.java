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
import tn.esprit.spring.service.RoleService;;
@RestController
public class RoleController {
	@Autowired 
	RoleService roleService;

	@GetMapping("/retrieve-all-roles")
	@ResponseBody
	public List<Role> getroles(){
		List<Role> role = roleService.retrieveAllRoles();
		return role;
	}

	@GetMapping("/retrieve-role/{id}")
	@ResponseBody
	public Role getroleById(@PathVariable("id") String id_role){
		return roleService.retrieveRole(id_role);
	}
	@PostMapping("/add-role")
	@ResponseBody
	public Role addrole(@RequestBody Role u){
		Role role= roleService.addRole(u);
		return role;
	}

	@DeleteMapping("/delete-role")
	@ResponseBody
	public void deleterole(@PathVariable("id") String id_role){
		roleService.deleteRole(id_role);
	}

	@PutMapping("/update-role")
	@ResponseBody
	public Role Updaterole(@RequestBody Role role){
		return roleService.updateRole(role);
	}

}
