package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("There isn't a user with the id: " + id));
		
	}
	
	public User insert (User obj) {
		return userRepository.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update (User obj) {
		User newUser = findById(obj.getId());
		updataData(newUser, obj);
		return userRepository.save(newUser);
	}
	
	private void updataData(User newUser, User obj) {
		newUser.setName(obj.getName());
		newUser.setEmail(obj.getEmail());
		
		
	}

	public User fromDTO (UserDTO user) {
		return new User (user.getId(), user.getName(), user.getEmail());
	}

}
