package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.service.*;
import tn.esprit.spring.entity.User;
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>
{
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);

}
