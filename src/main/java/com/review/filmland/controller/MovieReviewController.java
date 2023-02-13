package com.review.filmland.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.review.filmland.entity.MovieReview;
import com.review.filmland.service.MovieReviewService;

@RestController
public class MovieReviewController {
	
	@Autowired
	MovieReviewService movieReviewService;
	
	@PostMapping("/review/{movieId}")
	public MovieReview addReview(@PathVariable("movieId") Long movieId, 
								 @RequestBody MovieReview movieReview) {
		return movieReviewService.addReview(movieId, movieReview);
	}
	
	
	
}
