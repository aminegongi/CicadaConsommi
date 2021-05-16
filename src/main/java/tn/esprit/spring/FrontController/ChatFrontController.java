package tn.esprit.spring.FrontController;


import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.UserConnected;
import tn.esprit.spring.service.ChatService;
import tn.esprit.spring.service.UserServiceImpl;

@Scope(value = "session")
@Controller(value = "fchatController")
@ELBeanName(value = "fchatController")
@Join(path = "/client/chat", to = "/pages/client/userChat.jsf")
public class ChatFrontController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	ChatService chatService;
	
	private User Con = new User();
	
	private String message;
	
	private User autre = new User();
	
	
	private boolean userLoggedIn ;
	
	
	
	public boolean isUserLoggedIn() {
		if( Con == null ){
			return false;
		}
		return true ;
	}

	public void setUserLoggedIn(boolean userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	public User getAutre() {
		return autre;
	}

	public void setAutre(User autre) {
		this.autre = autre;
	}

	public User getCon() {
		return Con;
	}

	public void setCon(User con) {
		Con = con;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ChatFrontController() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.err.println("--------------controller Chat-------  --" );
		Con = UserConnected.userconnected;
		autre = Con;
	}
	
	public List<Chat> getlistconv(){
		return  chatService.getAllConversationUserconnected(Con.getId().intValue());
	}
	
	public void setConvWith(Chat c){
		this.setAutre(c.getSenderUser());
		Long id_autre = this.getAutre().getId();
		Long id_uCon = Con.getId();
	}
	
	public List<Chat> getConvsWith(){
		Long id_autre = this.getAutre().getId();
		Long id_uCon = Con.getId();		
		return chatService.getConversationUserConnectedSender(id_uCon.intValue(), id_autre.intValue());
	}
		
	public void send(){
		chatService.add( new Chat(this.getAutre(), this.getCon(), this.getMessage()));
		this.setMessage(null);
	}
	
	
	//-----------------------------------
	
	public String chatwith(User with){
		
		return null;
	}
	
}