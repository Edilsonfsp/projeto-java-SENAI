package com.edilson.projeto.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.edilson.projeto.entities.User;
import com.edilson.projeto.repositories.UserRepository;

@Component
public class TestConfig implements CommandLineRunner {
	
	private final UserRepository userRepository;
	
	public TestConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "911111111", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "922222222", "123456");
		User user3 = new User(null, "Edilson Souza", "edilson@gmail.com", "93333333", "123456");
		User user4 = new User(null, "Magda Souza", "magda@gmail.com", "944444444", "123456");
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
	}
	
}
