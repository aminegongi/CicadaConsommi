package tn.esprit.spring.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Reclamation;

@Repository("NotificationRepository")
public interface NotificationRepository extends CrudRepository<Notification , Long>  {
	@Modifying
	@Transactional
	@Query("update Notification n set n.State = :Etat where n.id_Notification = :id")
	void updateStateById(@Param("Etat") NState Etat, @Param("id") Long id) ;	

	@Query("select n from Notification n where datediff(CURRENT_TIMESTAMP , n.Date) > 5 and n.State='Not_Seen' ") 
	List<Notification> selectNotifdate5();

	@Query(value="select count(*) from notification where notification.State = 'Not_Seen' AND notification.notif_user_id = ?1",nativeQuery=true )
	int CountNotif_Not_seen_User(int id);
	
	@Modifying
	@Transactional
	@Query("update Notification n set n.State = 'Seen' ")
	void allSeen() ;

	@Query(value="select * from notification  where  notif_user_id = ?1"  ,nativeQuery = true )         
     public List<Notification> findNotificationByUserId(@Param("id") Long id);
}
