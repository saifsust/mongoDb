package org.javawebdevelopment.algorithms;

import java.util.List;

import org.javawebdevelopment.models.Post;
import org.javawebdevelopment.repositories.PostRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class DbModelProcessor {

	private static Query query;

	/***** Post finding using id *****/
	public static Post getSpecificPostById(String id, MongoOperations mongoOperations) throws Exception {
		query = new Query(Criteria.where("id").is(id));
		return mongoOperations.findOne(query, Post.class);

	}

	/****** find all post using profile id ******/

	public static List<Post> getAuthorAllPost(String authorId, PostRepository postRepository) throws Exception {
		return postRepository.getAuthorAllPostByAuthorId(authorId);
	}

	/***** delete post using id *****/
	public static void deletePostById(String id, PostRepository postRepository) throws Exception {
		postRepository.delete(id);
	}
	
	/****** find specific post using id *******/
	
	
	
	

}
