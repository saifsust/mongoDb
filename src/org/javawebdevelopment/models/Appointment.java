package org.javawebdevelopment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "appointment")
public class Appointment {

	@Id
	private String id;
	private User user;
	private String date;

}
