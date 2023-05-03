package com.jspiders.hibernate.dao;

import javax.activation.MailcapCommandMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOInsertStd{
	
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	
	public static void openConnection(){
		
		
		factory=Persistence.createEntityManagerFactory("student");
		
		manager=factory.createEntityManager();
		
		transaction=manager.getTransaction();
	}
	
	public static void closeConnection() {
		
		if (factory!=null) {
			factory.close();
		}
		if (manager !=null) {
			manager.close();
		}
		
		
	}
	public static void main(String[] args) {
		openConnection();
		transaction.begin();
		
		StudentDTO student=new StudentDTO();
		student.setCity("Beed");
		student.setContact(1234567891L);
		student.setEmail("warrior@gmail.com");
		student.setId(4);
		student.setName("warrior");
		
	    manager.persist(student);
		transaction.commit();
		closeConnection();
	}

}
