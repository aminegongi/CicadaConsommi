package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Role;

@Repository("roleRepository")
public interface RoleRepository  extends CrudRepository<Role, Long> {
	
}
