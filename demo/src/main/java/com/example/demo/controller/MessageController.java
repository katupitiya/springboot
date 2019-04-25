package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Message;
import com.example.demo.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
	
	MessageService messageservice;
	
	@RequestMapping(method=RequestMethod.POST)
	public Message createMassage(@RequestBody Message message) {
		return messageservice.createMassage(message);
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Message updateMassage(@PathVariable("id")String id,Message message)
	{
		return message;
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Message deleteMassage(String id)
	{
		return null;
		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public HttpEntity<Message> getMessage(@PathVariable("id") String id) { 
		
		Optional<Message> messageOpt = messageservice.getMessage(id); 
		
		if (messageOpt.isPresent()) 
		{ 
			return new ResponseEntity<Message>(messageOpt.get(), HttpStatus.OK);
		} 
		else { return new ResponseEntity<Message>(HttpStatus.NOT_FOUND); } }
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Message>listmessage()
	{
		return null;
		
		
	}

}
