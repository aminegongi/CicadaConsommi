package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Chat;

//repository that extends CrudRepository  
public interface ChatRepository extends CrudRepository<Chat, Integer>  
{  
	@Query(value="SELECT * FROM chat WHERE chat.receiver_user_id = ?1 GROUP BY chat.receiver_user_id , chat.sender_user_id order by chat.id_chat desc",nativeQuery=true)
	public List<Chat> getAllConversationUserconnected(int id_receiver_userConnected);
	
	//SELECT * FROM chat WHERE chat.receiver_user_id = 1 and chat.sender_user_id = 2
	
	@Query(value="SELECT * FROM chat WHERE ( chat.receiver_user_id = ?1 and chat.sender_user_id = ?2 ) or ( chat.receiver_user_id = ?2 and chat.sender_user_id = ?1 )",nativeQuery=true)
	public List<Chat> getConversationUserConnectedSender(int id_receiver_userConnected , int idSender);
}  