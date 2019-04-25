package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Message;
import com.example.demo.repositor.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messagerepository;
	
	public Message createMassage(Message message) {
		message.setId(UUID.randomUUID().toString());
		message.setDeleted(false);
		return messagerepository.save(message);
		
		
	}
	
	public Message updateMassage(String id,Message message)
	{
		return messagerepository.save(message);
		
	}
	
	public Message deleteMassage(Message deleted)
	{
		return messagerepository.save(deleted);
		
		
	}
	
	public Optional <Message> getMessage(String id)
	{
		return messagerepository.findById(id);
		
	}
	
	public List<Message>listmessage()
	{
		return messagerepository.findAll();
		
		
	}

}
