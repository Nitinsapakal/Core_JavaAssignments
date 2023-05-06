package com.iacsd;

import java.time.LocalDate;

/*
 * customer id(int) ,first name, last name (string),email(string),password(string),
 * registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
 */
public class Customer implements Comparable<Customer>{
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	// static id gen
	public static int idGenerator;
	
	static {
		
		idGenerator = 1000;
		
	}

	public Customer(String firstName, String lastName, String email, String password, double regAmount, LocalDate dob,
			ServicePlan plan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
		this.customerId = ++idGenerator;
	}
	// for verification (to be used along with equals) , add overloaded ctor to wrap
	// PK(UID) : email

	public Customer(String email) {
		super();
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public double getRegAmount() {
		return regAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
	}

	// for PK based equality testing
	
	
	@Override
	public boolean equals(Object o) {
		System.out.println("in cust equals");
		if(o instanceof Customer)
			return this.email.equals(((Customer)o).email);
		return false;
		
	}
	
	
	//compare to assending order
	
//	@Override
//	public int compareTo(Customer anotherCustomer) {
//		
//		System.out.println("in compreTo method");
//		return this.email.compareTo(anotherCustomer.email);
//	}
	
	
	// compare to descending order
	
	@Override
	public int compareTo(Customer anotherCustomer) {
		
		System.out.println("in compreTo method");
		return anotherCustomer.email.compareTo(email);
	}
	

//	@Override
//	public boolean equals(Object o) {
//
//		System.out.println("inside Cust equals");
//		if (o instanceof Customer)
//
//			return this.email.equals(((Customer) o).email);
//
//		return false;
//
//	}

}
