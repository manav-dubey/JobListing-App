package com.manav.joblisting.Controller;

import java.io.IOException;
import java.util.List;
import com.manav.joblisting.Model.Post;
import com.manav.joblisting.Repository.PostRepository;
import com.manav.joblisting.Repository.SearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

//In this project we are talking about JobPost with the term Post as model.

@RestController
public class PostController 
{	
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@RequestMapping("/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui/index.html");
	}
	
	@GetMapping("/posts")
	@ResponseBody
	public List<Post> getAllPosts(){
		return repo.findAll();
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text){		
		return srepo.findByText(text);
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {		
		return repo.save(post);
	}
}
