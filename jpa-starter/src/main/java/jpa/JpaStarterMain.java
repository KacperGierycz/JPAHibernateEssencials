package jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterMain {

	public static void main(String[] args) {
		
		
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Employee employee = entityManager.find(Employee.class, 1);
		
		
		
//		System.out.println(employee.toString());
//		employee.setAge(30);
//		employee.setType(EmployeeType.CONTRACTOR);
		
//		EntityTransaction transaction = entityManager.getTransaction();
//		transaction.begin();
//	//	entityManager.persist(employee);	
//		entityManager.remove(employee);	
//
//		transaction.commit();
//		entityManager.close();
//		entityManagerFactory.close();
		
		
		
		Employee employee = new Employee();
		employee.setName("Foo Bar");
		employee.setSsn("123");
		employee.setDob(new Date());
		employee.setType(EmployeeType.FULL_TIME);
		employee.setAge(20);
		
		
		Employee employee1 = new Employee();
		employee1.setName("Foo");
		employee1.setSsn("1234");
		employee1.setDob(new Date());
		employee1.setType(EmployeeType.FULL_TIME);
		employee1.setAge(20);
		
		AccessCard card = new AccessCard();
		card.setIssueDate(new Date());
		card.setActive(true);
		card.setFirmwareVersion("1.0.0");
		
		AccessCard card1 = new AccessCard();
		card1.setIssueDate(new Date());
		card1.setActive(true);
		card1.setFirmwareVersion("1.0.0");
		
		
		
		
//		Employee employee2 = new Employee();
//		employee2.setName("Bar");
//		employee2.setSsn("1235");
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);	
		entityManager.persist(employee1);
		entityManager.persist(card);	
		entityManager.persist(card1);
//		entityManager.persist(employee2);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}

}
