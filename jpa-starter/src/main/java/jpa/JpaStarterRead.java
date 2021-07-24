package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		Employee employee1 = entityManager.find(Employee.class, 1);
//	//	System.out.println(employee1);
//		System.out.println("---fetching employee");
//		System.out.println(employee1.getName());
//		System.out.println("---fetching card");
//
//		System.out.println(employee1.getCard());

	//	AccessCard card = entityManager.find(AccessCard.class, 3);

	//	PayStub paySub = entityManager.find(PayStub.class, 5);
		//System.out.println(paySub.getEmployee());

		
		  Employee employee = entityManager.find(Employee.class, 2);
		  System.out.println(employee.getPayStubs());
			
		  
		  
		  
		  
	}

}
