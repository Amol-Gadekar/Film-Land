package com.review.filmland.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.review.filmland.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Movie findMovieByName(String name);

	List<Movie> findMovieByGenre(String genre);
	
	//List<Movie> findMovieByReleaseDate(LocalDate releasedate);

	@Query("select movie from Movie movie where movie.releaseDate=:release_date ")
	List<Movie> findMovieByReleaseDate(@Param("release_date") LocalDate releaseDate);
	
//	@Query("select movie from Movie movie Between movie.releaseDate=:release_date 1")
//	List<Movie> findMovieBetweenReleaseDates(LocalDate releaseDate1, LocalDate releaseDate2);

	List<Movie> findByreleaseDateBetween(LocalDate releasedate1, LocalDate releasedate2);

	List<Movie> findByRatingBetween(double rating1, double rating2);

	//@Query("select movie from Movie movie where movie.rating=(select max(movie.rating) from movie)")
	//@Query("select movie from Movie movie where max(movie.rating) from movie where (movie.rating <(select max(movie.rating) from movie))")
	//@Query("select movie from Movie movie where movie.rating=(select max(movie.rating) from movie m1 where 1=(select count(rating) from movie m2 where m2.rating>m1.rating)) ")
//	@Query("select movie from Movie movie order by rating desc limit 1")
	@Query(value = "SELECT *,max(rating) from movie m1 where 0=(select count(distinct rating) from movie m2 where m2.rating>m1.rating)", nativeQuery = true)
	//@Query(value = "SELECT * FROM movie  order by rating desc limit 1", nativeQuery = true)
	Movie findByMaxRating();
	
	
	@Query(value = "SELECT * FROM movie  order by rating asce limit 6", nativeQuery = true)
	List<Movie> findByTopRating();


    

}
