package tn.esprit.spring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.service.NotifService;



@RestController  
@RequestMapping("/notification")
public class NotificationController {
	
	

	@Autowired  
	NotifService NotificationService ;
	
	@GetMapping("/getAll")  
	@ResponseBody
	private List<Notification> getAllNotifications()   
	{  
		return NotificationService.retrieveAllNotifications();  
	}  
	 
	@PostMapping("/add")  
	@ResponseBody
	private Notification saveNotification(@RequestBody Notification Notifications)   
	{  
		NotificationService.addNotification(Notifications);  
		return Notifications ;  
			}  
	
	@GetMapping("/get/{Notificationid}")
	@ResponseBody
	private Notification getNotification(@PathVariable("Notificationid") String Notificationid) {
		return NotificationService.retrieveNotification(Notificationid);
	}

	@DeleteMapping("/{Notificationid}")
	@ResponseBody
	private void deleteNotification(@PathVariable("Notificationid") String Notificationid) {
		NotificationService.deleteNotification(Notificationid);
	}

	@PutMapping("/")
	@ResponseBody
	private Notification updateNotification(@RequestBody Notification Notifications) {
		NotificationService.updateNotification(Notifications);
		return Notifications;
	}
	
}  