package tn.esprit.spring.service;


import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Chat;
import tn.esprit.spring.repository.ChatRepository;


@Service  
public class ChatService   
{  
	@Autowired  
	ChatRepository chatRepository;  

	public List<Chat> getAll()   
	{  
		List<Chat> chats = new ArrayList<Chat>();  
		chatRepository.findAll().forEach(c -> chats.add(c));  
		return chats;  
	}  
	
	public void add(Chat c)   
	{  
		chatRepository.save(c);
	}  
	
	public List<Chat> getAllConversationUserconnected(int id_receiver_userConnected){
		return chatRepository.getAllConversationUserconnected(id_receiver_userConnected);
		
	}

	public List<Chat> getConversationUserConnectedSender(int id_receiver_userConnected , int idSender){
		return chatRepository.getConversationUserConnectedSender(id_receiver_userConnected, idSender);
		
	}

}  