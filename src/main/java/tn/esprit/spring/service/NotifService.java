package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Notification;



public interface NotifService {
	List<Notification> retrieveAllNotifications();
	Notification addNotification(Notification u);
	void deleteNotification(String id);
	Notification updateNotification(Notification u);
	Notification retrieveNotification(String id);
}
