package com.manav.joblisting.Repository;
import java.util.List;
import com.manav.joblisting.Model.Post;


public interface SearchRepository {
	
	List<Post> findByText(String text);
}
