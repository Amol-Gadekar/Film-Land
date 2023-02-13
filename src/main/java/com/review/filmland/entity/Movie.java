package com.review.filmland.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity	
@Data
public class Movie {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private LocalDate releaseDate;
	private String cast;
	private String genre;
	private double rating;
	
	@OneToMany(mappedBy = "movie")
	@JsonManagedReference
	private List<MovieReview> movieReview;
	
}
