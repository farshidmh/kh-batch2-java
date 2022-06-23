package com.kh.UserManager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.UserManager.exception.UserNotFoundException;
import com.kh.UserManager.model.User;
import com.kh.UserManager.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		userRepository.save(user);
	}

	public void updateUserInfo(Long id, User user) throws UserNotFoundException {

		Optional<User> userFromDB = userRepository.findById(id);

		if (userFromDB.isPresent()) {

			User userToBeUpdated = userFromDB.get();

			userToBeUpdated.setName(user.getName());
			userToBeUpdated.setFamily(user.getFamily());
			userToBeUpdated.setActive(user.isActive());

			userRepository.save(userToBeUpdated);

		} else {
			throw new UserNotFoundException("The provided ID is not in our database");
		}

	}

	public void deleteUserById(Long id) throws UserNotFoundException

	{

		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new UserNotFoundException("The provided ID is not in our database");
		}

	}

	public User getUser(Long id) throws UserNotFoundException {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		} else {
			throw new UserNotFoundException("The provided ID is not in our database");
		}
	}

	public List<User> getAllUsers() {

		List<User> userList = userRepository.findAll();

		if (userList.size() > 0) {

			return userList;

		} else {

			return new ArrayList<User>();

		}

	}

}
