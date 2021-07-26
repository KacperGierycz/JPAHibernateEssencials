package jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sun.tools.javac.util.List;

public class JpaPersistenceContextDemo {

	public static void main(String[] args) {		
		
		
		Employee employee = new Employee();
		employee.setName("new Employee");
		employee.setSsn("12345334 ");
		employee.setDob(new Date());
		employee.setType(EmployeeType.FULL_TIME);
		employee.setAge(25);
		
		
		
		System.out.println("****************Created employee instance");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		System.out.println("****************Starting the transaction");
		entityManager.persist(employee);
		
		System.out.println("****************After persistance method caled");
		
		Employee emplo1 = entityManager.find(Employee.class,1);
		System.out.println(employee);
		System.out.println(emplo1);
		System.out.println(employee == emplo1);
		
		
		transaction.commit();
		System.out.println("****************After transaction closed");
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}

}
