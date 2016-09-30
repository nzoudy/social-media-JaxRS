package com.zoudys.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoudys.socialmedia.database.DatabaseClass;
import com.zoudys.socialmedia.model.Message;
import com.zoudys.socialmedia.model.Profile;

public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	private static Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hello Urbain", "Urbain"));
		messages.put(2L, new Message(2, "Hello Sara", "Sara"));
		messages.put(3L, new Message(3, "Hello Priscillia", "Priscillia"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	
}
