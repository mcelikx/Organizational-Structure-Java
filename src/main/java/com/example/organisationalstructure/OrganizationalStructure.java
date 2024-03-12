package com.example.organisationalstructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@RestController
public class OrganizationalStructure {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationalStructure.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}

	@Autowired
	private UserDao userDao;

	@PostMapping("/add-user")
	public String addUser(@RequestParam String name, @RequestParam String email) {
		User user = new User(name, email);
		userDao.save(user);
		return "User added successfully!";
	}

	@GetMapping("/get-users")
	public ResponseEntity<Iterable<User>> getUsers() {
		return ResponseEntity.ok(userDao.findAll());
	}

	@PostMapping("/remove-user")
	public String removeUser(@RequestParam Long id) {
		userDao.deleteById(id);
		return "User removed successfully!";
	}

}
