package com.jsp.boot_email.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileAttachment {
	
	String to;
	String subject;
	String body;
	String attachment;
	

}
