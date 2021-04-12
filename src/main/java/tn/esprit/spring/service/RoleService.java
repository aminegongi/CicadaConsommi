package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Role;

public interface RoleService {
	List<Role> retrieveAllRoles();
	 Role addRole(Role u);
	void deleteRole(String id);
	Role updateRole(Role u);
	Role retrieveRole(String id);

}
