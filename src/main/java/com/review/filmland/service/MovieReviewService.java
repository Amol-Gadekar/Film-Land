package com.review.filmland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.filmland.dao.MovieRepository;
import com.review.filmland.dao.MovieReviewRepository;
import com.review.filmland.entity.Movie;
import com.review.filmland.entity.MovieReview;

@Service
public class MovieReviewService {
	
	@Autowired
	MovieReviewRepository movieReviewRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	public MovieReview addReview(Long movieId, MovieReview movieReview) {
		
		Movie movie = movieRepository.findById(movieId).orElse(null);
		movieReview.setMovie(movie);
		
		return movieReviewRepository.save(movieReview);
	}

	
	
	
	
}
