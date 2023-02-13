package com.review.filmland.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String fName;
	private String lName;
	private String eMail;
	private String password;
	
	
	
}
