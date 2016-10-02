package com.zoudys.socialmedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zoudys.socialmedia.database.DatabaseClass;
import com.zoudys.socialmedia.model.Comment;
import com.zoudys.socialmedia.model.Message;

public class CommentService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	/*public CommentService(){
		comments.put(1L, new Comment(1, "Hello comment for Urbain", "Urbain"));
		comments.put(2L, new Comment(2, "Hello comment for Sara", "Sara"));
		comments.put(3L, new Comment(3, "Hello comment for Priscillia", "Priscillia"));
	}*/
	
	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
	
}
