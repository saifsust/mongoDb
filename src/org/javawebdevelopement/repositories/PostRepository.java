package org.javawebdevelopement.repositories;

import java.util.List;

import org.javawebdevelopment.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> getAuthorAllPostByAuthorId(String authorId);

}
