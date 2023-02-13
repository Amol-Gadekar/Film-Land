package com.review.filmland.dao;

import org.springframework.data.repository.CrudRepository;

import com.review.filmland.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
