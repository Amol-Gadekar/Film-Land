package com.review.filmland.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.review.filmland.entity.MovieReview;

@Repository
public interface MovieReviewRepository extends CrudRepository<MovieReview, Long> {

}
