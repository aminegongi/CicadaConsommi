package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.RState;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.NotificationRepository;

@Service
public class NotifServiceImpl implements NotifService {
	@Autowired
	NotificationRepository NotificationRepository;

	@Override
	public List<Notification> retrieveAllNotifications() {
		List<Notification> Notifications = new ArrayList<Notification>();
		NotificationRepository.findAll().forEach(NotificationAjout -> Notifications.add(NotificationAjout));
		return Notifications ;
	}
	
	
	//get notification by user id // 
	
	@Override
	public List<Notification> retrieveAllNotificationByIdUser(String id) {
		// TODO Auto-generated method stub
		return NotificationRepository.findNotificationByUserId(Long.parseLong(id));
	}	

	@Override
	public Notification addNotification(Notification u) {
		u.setState(NState.Not_Seen);
		NotificationRepository.save(u);
		return u;

	}
	
	@Override
	public Notification retrieveNotif(String id) {
		// TODO Auto-generated method stub
		
		return NotificationRepository.findById(Long.parseLong(id)).get(); 
	}

	@Override
	public void deleteNotification(String id) {
		NotificationRepository.deleteById(Long.parseLong(id));

	}

	@Override
	public Notification updateNotification(Notification u) {
		// TODO Auto-generated method stub
		NotificationRepository.save(u);
		return u;
	}

	@Override
	public Notification retrieveNotification(String id) {
		return NotificationRepository.findById(Long.parseLong(id)).get();
	}
// update State Notification // 
	@Override
	public String updateadminEtat(NState u, String id) {

		NotificationRepository.updateStateById(u, Long.parseLong(id));
		return "update ok";

	}
// Rappel Notification (not_seen more then 5 says ) // 
	@Override
	public String RappelNotification() {
		List<Notification> listNotif = NotificationRepository.selectNotifdate5() ; 
		if (listNotif.isEmpty())
			return "All Notification Seen ";
		else {
			for (Notification notif : listNotif) {
				deleteNotification(Long.toString(notif.getId_Notification()));
				addNotification(notif);
			}
		}
		return "Notification returned " ;
	}	


	@Override
	public int CountNotificationNot_Seen(int id) {
		return NotificationRepository.CountNotif_Not_seen_User(id);
	}
	

	@Override
	public String allNotifSeen() {
		NotificationRepository.allSeen();
		return " All notification seen ";
	}
	// if user inactive (more then 3 days) send notification " WE MISS U " 	
	
	@Override
	public Long addOrUpdateNotification(Notification Notification) {
		Notification.setState(NState.Not_Seen);
		NotificationRepository.save(Notification);
		
		return Notification.getId_Notification();
		}


	@Override
	public Notification addNotificationlien(Notification u) {
	    u.setState(NState.Not_Seen);
		NotificationRepository.save(u);
		return u;
		
	}
}
