package org.javawebdevelopment.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.javawebdevelopment.algorithms.StringProcessor;
import org.javawebdevelopment.models.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class Main {

	private static final Log log = LogFactory.getLog(Main.class);

	public static void main(String[] args) {
		try {

			/*
			 * if(log.isDebugEnabled()){
			 * 
			 * }
			 * 
			 * System.out.println("Hello");
			 * 
			 * ApplicationContext context = new GenericXmlApplicationContext(
			 * "/org/javawevdevelopment/beanconfig/mongo-config.xml");
			 * MongoOperations operate = (MongoOperations)
			 * context.getBean("mongoTemplate");
			 * 
			 * Users users = new Users("5", "liton"); operate.insert(users);
			 * log.info("MongoDb {} ");
			 * 
			 * System.out.println("End");
			 */
			
			System.out.println(StringProcessor.getCurrentTime());
			

			//System.out.println(StringProcessor.descriptionProcess("djgadg|liton|jdajdjagd<saiful>"));

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
