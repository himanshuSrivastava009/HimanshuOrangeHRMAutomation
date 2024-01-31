package com.selenium.webelements.utilities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


class StudentInfo{
	
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "StudentInfo [students=" + students + "]";
	}
	
	
}
public class Student {

	
	private String id;
	private String name;
	private String collegeName;
	
	public Student(){
		
	}
	public Student(String id, String name, String collegeName){
		
		this.id = id;
		this.name = name;
		this.collegeName = collegeName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", collegeName=" + collegeName + "]";
	}

	public static void main(String[] args) throws JsonProcessingException {
		ArrayList<Student> al = new ArrayList<>();
		
		al.add(new Student("1","Himanshu","DSI")); 
		al.add(new Student("2","Swati","East West College of Engineering"));
		
		StudentInfo st = new StudentInfo();
		st.setStudents(al);
		
		ObjectMapper mapper = new ObjectMapper();
		String val  = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(st);
		System.out.println(val.toString());
		
		ObjectMapper mapper1 = new ObjectMapper();
		StudentInfo readValue = mapper1.readValue(val, StudentInfo.class);
		System.out.println(readValue.getStudents().get(0).getId());
		
		
	}
}
