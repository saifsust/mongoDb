package org.javawebdevelopment.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.javawebdevelopment.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	public List<Post> getAuthorAllPostByAuthorId(String authorId);

	public void delete(String id);

	public Post getPostById(ObjectId id);


}
