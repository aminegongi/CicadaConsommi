package tn.esprit.spring.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);
	

	Boolean existsByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
    public User findByVerificationCode(String code);
	
	@Query(value="SELECT marque_produit, ROUND(AVG(rating)) as avgp FROM produit GROUP BY marque_produit",nativeQuery=true)
	public List<Map<String,BigInteger>> getAvgRating();
	
	@Query(value = " select t1.name as name ,t2.user_id,COUNT(t2.user_id) as nb from roles t1 INNER JOIN user_roles t2 ON t1.id = t2.role_id group by t1.id ", nativeQuery = true)
	public List<Map<String, BigInteger>> getRoleUser();
	
	@Query(value = " SELECT state, COUNT(state) as nbstate from reclamation GROUP BY state ", nativeQuery = true)
	public List<Map<String, BigInteger>> getRec();
	
	@Query(value = "SELECT activated from users where username = ?1 ", nativeQuery = true)
	public boolean Checkactivation(String user);
	
	/*@Query("Select x from Users x where s.id = ?1 ")
	public List<User> UserParId(Long id);
	*/
	
}
