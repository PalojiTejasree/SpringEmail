package com.jsp.boot_email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailList;
import com.jsp.boot_email.dto.FileAttachment;
import com.jsp.boot_email.service.EmailService;

@RestController
public class EmailController {
	
	  @Autowired
      EmailService service;
	  
	  
	
     @GetMapping("/msg")
	 public String msg(){
	     return "hi";
	 }
     
     
     // mail for single recipient
     @PostMapping("/send")
     public String sendMsg(@RequestBody Email email) {
    	 System.out.println(email);
    	try {
			service.sendmsg(email);
			return "msg sent sucessful";
		    } 
    	catch (Exception e) {
//			e.printStackTrace();
			return "internal issue try again";
		}
     }
     
     
     // mail for multiple recipients
     @PostMapping("/sendAll")
     public String sendMsgs(@RequestBody EmailList list) {
//    	 System.out.println(list);
    	try {
			service.sendmsgs(list);
			return "msg sent sucessful";
		     } 
    	catch (Exception e) {
         	return "internal issue try again";
		}
     }
     
     @PostMapping("/sendattachment")
     public String sendMsgs(@RequestBody FileAttachment file) {
//    	 System.out.println(mail);
    	try {
    		service.sendEmailWithAttachment(file);
			return "msg sent sucessful";
		     } 
    	catch (Exception e) {
			return "internal issue try again";
		}
     }
//     "C:\\Users\\Teja Sree\\OneDrive\\Pictures\\calculator image.jpg"---attachment file path
     
     
     @PostMapping("/sendhtml")
     public String sendHtml(@RequestBody Email email) {
    	 System.out.println(email);
    	try {
			service.sendHtmlEmail(email);
			return "msg sent sucessful";
		    } 
    	catch (Exception e) {
//			e.printStackTrace();
			return "internal issue try again";
		}
     }

}
