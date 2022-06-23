package com.kh.UserManager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.UserManager.exception.UserNotFoundException;
import com.kh.UserManager.model.User;
import com.kh.UserManager.repository.UserRepository;
import com.kh.UserManager.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	private ResponseEntity<Map> getUser(@PathVariable("id") Long id) {

		Map<String, String> returnMap = new HashMap<>();

		try {
			User u = userService.getUser(id);

			returnMap.put("name", u.getName());

			returnMap.put("family", u.getFamily());

			return new ResponseEntity<Map>(returnMap, new HttpHeaders(), HttpStatus.OK);

		} catch (UserNotFoundException e) {

			returnMap.put("message", e.getMessage());

			return new ResponseEntity<Map>(returnMap, new HttpHeaders(), HttpStatus.NOT_FOUND);

		}

	}

	@PostMapping
	private ResponseEntity<Map> createUser(@RequestBody User user) {

		userService.createUser(user);

		Map<String, String> returnMap = new HashMap<>();

		returnMap.put("message", "User has been created");

		return new ResponseEntity<Map>(returnMap, new HttpHeaders(), HttpStatus.CREATED);

	}

	@PutMapping("/{id}")
	private String updateUser(@PathVariable("id") Long id, @RequestBody User user) {

		try {

			userService.updateUserInfo(id, user);

			return "OK";

		} catch (UserNotFoundException e) {

			return e.getMessage();

		}

	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Map> deleteUser(@PathVariable("id") Long id) {

		try {
			Map<String, String> returnMap = new HashMap<>();

			returnMap.put("message", "User has been removed");

			userService.deleteUserById(id);

			return new ResponseEntity<Map>(returnMap, new HttpHeaders(), HttpStatus.OK);
		} catch (UserNotFoundException e) {

			Map<String, String> returnMap = new HashMap<>();

			returnMap.put("message", e.getMessage());

			return new ResponseEntity<Map>(returnMap, new HttpHeaders(), HttpStatus.NOT_FOUND);

		}

	}

}
