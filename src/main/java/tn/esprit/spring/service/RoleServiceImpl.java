package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.RoleRepository; ;
@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	RoleRepository RoleRepository ;
	private static final Logger l = LogManager.getLogger(RoleServiceImpl.class);
	
	@Override
	public List<Role> retrieveAllRoles() {
		List<Role> Roles=(List<Role>) RoleRepository.findAll();
		for(Role Role: Roles){
			l.info("Role list : "+ Role);
		}
		return Roles;
	}

	@Override
	public Role addRole(Role u) {
		// TODO Auto-generated method stub
		return RoleRepository.save(u);
	}

	@Override
	public void deleteRole(String id_role) {
		RoleRepository.deleteById(Long.parseLong(id_role));
		
	}

	@Override
	public Role updateRole(Role u) {
		return RoleRepository.save(u);
	}

	@Override
	public Role retrieveRole(String id_Role) {
		return null;

	}

	public RoleServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
}
