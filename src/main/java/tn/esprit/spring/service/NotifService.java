package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.NState;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Reclamation;





public interface NotifService {
	List<Notification> retrieveAllNotifications();
	List<Notification> retrieveAllNotificationByIdUser(String id ) ;
	Notification addNotification(Notification u);
	void deleteNotification(String id);
	Notification updateNotification(Notification u);
	Notification retrieveNotification(String id);
	String updateadminEtat  ( NState nState ,String id );
	String RappelNotification ( ) ;
	int CountNotificationNot_Seen (int id ) ;
	String allNotifSeen();
	Long addOrUpdateNotification(Notification Notification);
	Notification retrieveNotif(String id);
	Notification addNotificationlien(Notification u);
}
