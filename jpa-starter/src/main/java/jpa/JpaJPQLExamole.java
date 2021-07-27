package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.internal.build.AllowSysOut;

public class JpaJPQLExamole {

	public static void main(String[] args) {


		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
	
	//	e where e.name like '%Bar'
	//  e where e.age between 22 and 32 
	//	e where e.card.isActive = true
	// TypedQuery<String> query= .... select e.name from Employee e; List<String>=to list
	//	Query = select e.age, e.name from Employee e; List result= to list
		
		TypedQuery<Object[]> queryOfObjects= entityManager.createQuery(
				"select e.name, e.age from Employee e"
				, Object[].class);
		List<Object[]> resultList2= queryOfObjects.getResultList();
		resultList2.forEach(e-> System.out.println(e[0]+" "+ e[1]));
		
		
		
		TypedQuery<Employee> listOfEmployees = entityManager.createQuery(
				"select e From Employee e where e.age>25 order by e.name desc"
				, Employee.class);
		List<Employee> resultList= listOfEmployees.getResultList();
		resultList.forEach(System.out::println);
		
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
