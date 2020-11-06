package com.mukscode.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mukscode.hibernate.entity.Instructor;
import com.mukscode.hibernate.entity.InstructorDetail;


public class GetInstructorDetails {

public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			//start transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId = 29;
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("Instructor Detail: "+theInstructorDetail);
			if(theInstructorDetail!=null) {
			//print associated instructor
			System.out.println("The associated Instructor: "+theInstructorDetail.getInstructor());
			}else {
				System.out.println("Instructor Detail not found");
			}
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally 
		{
			session.close();
			
			factory.close();
		}
		
	}

}
