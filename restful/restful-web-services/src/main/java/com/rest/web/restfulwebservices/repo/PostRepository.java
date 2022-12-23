package com.rest.web.restfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.web.restfulwebservices.entity.Post;


public interface PostRepository extends JpaRepository<Post,Integer> {

}
