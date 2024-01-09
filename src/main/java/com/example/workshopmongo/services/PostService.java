package com.example.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository PostRepository;

	public Post findById(String id) {
		Optional<Post> obj = PostRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException ("There isn't a user with the id: " + id));
		
	}
	
	
}
