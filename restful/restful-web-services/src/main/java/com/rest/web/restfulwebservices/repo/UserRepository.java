package com.rest.web.restfulwebservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.web.restfulwebservices.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
