package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(name = "emp name asc", query= "select e from Employee e where e.age>:age order by e.name")
public class Employee {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="EMPLOYEE_NAME")
	private String name;
	
	private int age;
	
	@Column(unique=true, length=10, nullable=false, updatable=false)
	private String ssn;
	

	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@Transient
	private String debug;
	
	@OneToOne//(fetch = FetchType.LAZY)
	private AccessCard card;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
	private List<PayStub>payStubs= new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
	joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
	inverseJoinColumns = @JoinColumn(name="SUBSCRIPTION_EMAIL_ID")
	
			)
	private List<EmailGroup> emailGroups= new ArrayList<>();
	
	
	public List<EmailGroup> getEmailGroups() {
		return emailGroups;
	}
	public void setEmailGroups(List<EmailGroup> emailGroups) {
		this.emailGroups = emailGroups;
	}
	public AccessCard getCard() {
		return card;
	}
	public void setCard(AccessCard card) {
		this.card = card;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
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
	public List<PayStub> getPayStubs() {
		return payStubs;
	}
	public void setPayStubs(List<PayStub> payStubs) {
		this.payStubs = payStubs;
	}
	


	public void addPayStub(PayStub payStub) {
		this.payStubs.add(payStub);
	}
	
	public void addEmailSubscription(EmailGroup emailGroup) {
		this.emailGroups.add(emailGroup);
	}
	

}
