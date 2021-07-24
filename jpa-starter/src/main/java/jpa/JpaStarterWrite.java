package jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sun.tools.javac.util.List;

public class JpaStarterWrite {

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
		employee.setCard(card);
		card.setOwner(employee);
		
		AccessCard card1 = new AccessCard();
		card1.setIssueDate(new Date());
		card1.setActive(true);
		card1.setFirmwareVersion("1.0.0");
		employee1.setCard(card1);
		card1.setOwner(employee1);
		
		
//		Employee employee2 = new Employee();
//		employee2.setName("Bar");
//		employee2.setSsn("1235");
		
		
		PayStub payStub1= new PayStub();
		payStub1.setPayPeriodEnd(new Date());
		payStub1.setPayPeriodStart(new Date());
		payStub1.setSalary(1000);
		payStub1.setEmployee(employee1);
		
		PayStub payStub2= new PayStub();
		payStub2.setPayPeriodEnd(new Date());
		payStub2.setPayPeriodStart(new Date());
		payStub2.setSalary(2000);
		payStub2.setEmployee(employee1);
		
		employee1.setPayStubs(List.of(payStub1, payStub2));
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);	
		entityManager.persist(employee1);
		entityManager.persist(card);	
		entityManager.persist(card1);
		entityManager.persist(payStub1);
		entityManager.persist(payStub2);

//		entityManager.persist(employee2);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}

}
