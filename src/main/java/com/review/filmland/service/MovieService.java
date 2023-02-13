package com.review.filmland.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.filmland.dao.MovieRepository;
import com.review.filmland.entity.Movie;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;

	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie getMovie(Long id) {
		return movieRepository.findById(id).orElse(null);
	}

	public Movie findMovieByName(String name) {
		return (movieRepository).findMovieByName(name);
	}

	public List<Movie> findMovieByGenre(String genre) {
		return (List<Movie>) movieRepository.findMovieByGenre(genre);
	}

	public List<Movie> findMovieByDate() {
		return null;
	}

	public List<Movie> findMovieByDate(LocalDate releaseDate) {
		return (List<Movie>) movieRepository.findMovieByReleaseDate(releaseDate);
	}

//	public List<Movie> findMovieBetweenDates(LocalDate releaseDate1, LocalDate releaseDate2) {
//		return (List<Movie>) movieRepository.findMovieBetweenReleaseDates(releaseDate1, releaseDate2);
//	}

	public List<Movie> findMovieBetweenDate(LocalDate releasedate1, LocalDate releasedate2) {
		return (List<Movie>) movieRepository.findByreleaseDateBetween(releasedate1, releasedate2);
	}

	public List<Movie> findMovieBetweenRatings(double rating1, double rating2) {
		return (List<Movie>) movieRepository.findByRatingBetween(rating1, rating2);
	}

	public Movie findMovieMaxRating() {
		return movieRepository.findByMaxRating();
	}

	public List<Movie> findMovieTopRating() {
		// TODO Auto-generated method stub
		return movieRepository.findByTopRating();
	}

//	public Movie getMovie(String name) {
//		return (Movie) movieRepository.findAll();
//	}
}
