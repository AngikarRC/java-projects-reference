package com.rest.web.restfulwebservices.userController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.rest.web.restfulwebservices.entity.Post;
import com.rest.web.restfulwebservices.entity.User;
import com.rest.web.restfulwebservices.repo.PostRepository;
import com.rest.web.restfulwebservices.repo.UserRepository;
import com.rest.web.restfulwebservices.userDao.UserDaoService;

@RestController
public class userJPAResource {

//	@Autowired
//	UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> getById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		//HATEOS
		
		EntityModel<Optional<User>> model = EntityModel.of(user);  

		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAllUsers());

		model.add(linkToUsers.withRel("all-users"));

		// HATEOAS

		return model;
	}

	@ResponseStatus(code = HttpStatus.GONE)
	@DeleteMapping("/jpa/users/{id}")
	public void deleteById(@PathVariable("id") int id) {
		userRepository.deleteById(id);

//		if (user == null) {
//			throw new UserNotFoundException("id-" + id);
//		}
	}

	@PostMapping("/jpa/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		savedUser.getId();
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
			
			return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	@ResponseStatus(code=HttpStatus.FOUND)
	public List<Post> retreiveAllPosts(@PathVariable("id") int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return user.get().getPosts();
	}
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUserPosts(@PathVariable("id") int id , @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		User user = userOptional.get(); //retreiving user if found from db
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts/{pid}")
	@ResponseStatus(code=HttpStatus.FOUND)
	public List<Post> retreiveAllPosts(@PathVariable("id") int id, @PathVariable("pid") int pid) {
		Optional<User> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = userOptional.get();
		
		Post post = new Post();
		post.setUser(user);
		
		postRepository.findAllById();
		
		List<Post> posts = postRepository.findAll();
		
		return posts; 
		
		
	}
}
