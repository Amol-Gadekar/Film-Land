package com.review.filmland.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.filmland.entity.Movie;
import com.review.filmland.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/addMovie")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}

	@GetMapping("/movieById/{id}")
	public Movie getMovie(@PathVariable Long id) {
		return movieService.getMovie(id);
	}

	@GetMapping("/movieByName/{name}")
	public Movie findMovieByName(@PathVariable ("name") String name) {
		return movieService.findMovieByName(name);
	}
	
	@GetMapping("/movieByGenre/{genre}")
	public List<Movie> findMovieByGenre(@PathVariable ("genre") String genre) {
		return movieService.findMovieByGenre(genre);
	}
	
//	@GetMapping("/movieByDate/date")
//	public List<Movie> findMovieByDate(@RequestParam(name="id") LocalDate startdate, @RequestParam LocalDate enddate) {
//		return movieService.findMovieByDate(startdate,enddate);
//	}
//
//	@GetMapping("/movie")
//	public List<Movie> findMovieByDate() {
//		return movieService.findMovieByDate();
//	}
	
	@GetMapping("/movieByDate")
	public List<Movie> findMovieByDate(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate releaseDate) {
		return movieService.findMovieByDate(releaseDate);
	}
	
//	@GetMapping("/movieBetweenDates")
//	public List<Movie> findMovieBetweenDates(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate releaseDate1,
//			@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate releaseDate2) {
//		return movieService.findMovieBetweenDates(releaseDate1,releaseDate2);
//	}
	
	@GetMapping("/movieBetweenDate")
	public List<Movie> findMovieBetweenDate(@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate releaseDate1,
											@RequestParam @DateTimeFormat(pattern= "yyyy-MM-dd") LocalDate releaseDate2) {
		
		return movieService.findMovieBetweenDate(releaseDate1,releaseDate2);
	}
	
	@GetMapping("/movieBetweenRatings")
	public List<Movie> findMovieBetweenRatings(@RequestParam double rating1, @RequestParam double rating2) {
		return movieService.findMovieBetweenRatings(rating1, rating2);
	}
	
	@GetMapping("/movieMaxRating")
	public Movie findMovieMaxRating() {
		return movieService.findMovieMaxRating();
	}


	@GetMapping("/movieByTopRating")
	public List<Movie> findMovieTopRating() {
		return movieService.findMovieTopRating();
	}


}
