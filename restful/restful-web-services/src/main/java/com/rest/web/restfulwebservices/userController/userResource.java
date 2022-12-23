package com.rest.web.restfulwebservices.userController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.web.restfulwebservices.entity.User;
import com.rest.web.restfulwebservices.userDao.UserDaoService;

@RestController
public class userResource {

	@Autowired
	UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getById(@PathVariable("id") Integer id) {
		User user = userDaoService.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		//HATEOS
		
		EntityModel<User> model = EntityModel.of(user);  

		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAllUsers());

		model.add(linkToUsers.withRel("all-users"));

		// HATEOAS

		return model;
	}

	@ResponseStatus(code = HttpStatus.GONE)
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable("id") int id) {
		User user = userDaoService.deleteById(id);

		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	}

	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		savedUser.getId();
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
			
			return ResponseEntity.created(location).build();
	}
}
