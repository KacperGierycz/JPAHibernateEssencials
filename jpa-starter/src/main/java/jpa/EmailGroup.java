package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EmailGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "emailGroups",fetch = FetchType.EAGER)
	private List<Employee> members= new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getMembers() {
		return members;
	}
	public void setMembers(List<Employee> members) {
		this.members = members;
	}
	
	public void addMember(Employee employee) {
		this.members.add(employee);
		
	}
	
	
	
	
	
	
}
