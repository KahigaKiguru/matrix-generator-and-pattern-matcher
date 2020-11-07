package ca.sheridancollege.ca.finalexam.service;

import java.util.Optional;

import org.springframework.stereotype.Service;


import ca.sheridancollege.ca.finalexam.entity.User;
import ca.sheridancollege.ca.finalexam.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(String username) {
		if(username.equals(null)) {
			username = "player";
		}
		userRepository.save(new User(username, 1, 0, 0, 0 ));
	}

//	add game played
	public void addGamePlayed(String username, boolean won) {
		User user = userRepository.findByName(username);
		if (won) {
			user.addGamesPlayed(true);
			userRepository.save(user);
		} else {
			user.addGamesPlayed(false);
			userRepository.save(user);
		}
	}
	
	public Optional<User> findUserByName(String name) {
		return Optional.ofNullable(userRepository.findByName(name));
	}

}
