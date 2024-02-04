package com.rest.automation;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class RestAssuredExample {

	private final static String url = "https://gorest.co.in/";
	
	public void getUsers() {
		
		//GoRestUserPojo gp = new GoRestUserPojo();
		//gp.setName();
	
		
		
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		RestAssured.baseURI = url;
		List<Person> list = RestAssured.given()
		.when().log().all()
		.get("public/v2/users")
		.then().log().all()
		.extract()
		.body()
		.jsonPath()
		.getList("", Person.class);
//		
//		Person p = new Person();
//		p.setEmail("a@abc.com");
//		p.setId(789);
//		p.setGender("Female");
//		p.setName("Swati");
//		p.setStatus("active");
//		p.setMessage("dfghj");
//		
		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValueAsString(p);
//		
//		RestAssured.given()
//		.header("Authorization","Bearer 07a4f234c7a8bc3d52235823303df5491df3f2d97ec21e184942837b3ef2331d")
//		.header("Content-Type","application/json")
//		.body(p)
//		.when().log().all()
//		.post("public/v2/users")
//		.then().log().all()
//		.statusCode(201);
		
		
		 for (Person user : list) {
	            System.out.println("User: " + user.getName());
	        }
		
		
	}
}
