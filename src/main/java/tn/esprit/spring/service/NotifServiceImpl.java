package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.NotificationRepository;

@Service
public class NotifServiceImpl implements NotifService  {
	@Autowired
	NotificationRepository NotificationRepository ;

	@Override
	public List<Notification> retrieveAllNotifications() {
		List<Notification> Notifications = new ArrayList<Notification>();  
		NotificationRepository.findAll().forEach(NotificationAjout  -> Notifications .add(NotificationAjout));  
		return Notifications ;
	}

	@Override
	public Notification addNotification(Notification u) {
		NotificationRepository.save(u) ;
		return u;
	
	}

	@Override
	public void deleteNotification(String id) {
		NotificationRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Notification updateNotification(Notification u) {
		// TODO Auto-generated method stub
		NotificationRepository.save(u) ;
		return u;
	}

	@Override
	public Notification retrieveNotification(String id) {
		return NotificationRepository.findById(Long.parseLong(id)).get() ;
	}
	

}
