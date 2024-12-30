package com.manav.joblisting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.manav.joblisting.Model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}
