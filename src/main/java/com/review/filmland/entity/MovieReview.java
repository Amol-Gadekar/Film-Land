package com.review.filmland.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class MovieReview {

	@Id
	@GeneratedValue
	private long id;
	private double rating;
	private String review;
	
	@ManyToOne
	@JoinColumn(name= "movie_id")
	@JsonBackReference
	private Movie movie;
	
	
	
	
	
}
