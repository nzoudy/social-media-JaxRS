package com.zoudys.socialmedia.database;

import java.util.HashMap;
import java.util.Map;

import com.zoudys.socialmedia.model.Message;
import com.zoudys.socialmedia.model.Profile;
import com.zoudys.socialmedia.model.Comment;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comment> comments = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static Map<Long, Comment> getComments() {
		return comments;
	}
	
	
	
}
