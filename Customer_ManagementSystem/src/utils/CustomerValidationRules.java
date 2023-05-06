package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.iacsd.Customer;
import com.iacsd.ServicePlan;

import custom_exceptions.CustomerHandlingException;

public class CustomerValidationRules {
	
	//add a static method  to invoke all validation rules 
	
	
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password, double regAmount, String dob,
			String plan, List<Customer> customerList) throws CustomerHandlingException{
		
		checkForDup(customerList,email);
		ServicePlan servicePlan = parseValidatePlanAndRegAmount(plan,regAmount);
		LocalDate validDob = ValidateDob(dob);
		return new Customer(firstName,lastName,email,password,regAmount,validDob,servicePlan);
	}
	
	
	
	
	
	
//add a static method to check for dup
	public static void checkForDup(List<Customer> customerList, String newEmail) throws CustomerHandlingException {
		// 1. wrap email in customer ref.

		Customer newCustomer = new Customer(newEmail);
		if (customerList.contains(newCustomer))
			throw new CustomerHandlingException("Dup Email ID , choose new email !!!!!");
		System.out.println("no dup email found....");

		// add static method for plan pasrsing n validation

	}
	
	
	
	

//	public static ServicePlan parseAndValidatePlan(String planName) throws IllegalArgumentException{
//		
//		return ServicePlan.valueOf(planName.toUpperCase());
//		
//	}
//	
//	
//	// add a Static method to validate reg amount matching with the plan
//	
//	
//	public static void ValidateRegAmountForPlan (double regAmount, ServicePlan chosenplan) throws CustomerHandlingException  {
//		
//		
//		if(chosenplan.getPlanCost() != regAmount) {
//			
//			throw new CustomerHandlingException("Invalid reg Amount");
//		}	
//		
//	}

	
	
	
	
	public static ServicePlan parseValidatePlanAndRegAmount(String planName, double regAmount)
			throws IllegalArgumentException, CustomerHandlingException {

		ServicePlan serviceplan = ServicePlan.valueOf(planName.toUpperCase());

		if (serviceplan.getPlanCost() != regAmount)
			throw new CustomerHandlingException("invalid reg amount");
		return serviceplan;
	} 

	
	
	
	
	public static LocalDate ValidateDob(String dob) throws CustomerHandlingException {

		LocalDate date = LocalDate.parse(dob);

		int ageInYears = Period.between(date, LocalDate.now()).getYears();
		if (ageInYears > 21)

			return date;

		throw new CustomerHandlingException("Invalid dob");

	}

	
	public static Customer customerLogin(String Eemail,String pass, List<Customer> custList) throws CustomerHandlingException{
		
		// search customer by email. pk
		Customer email = new Customer(Eemail);
		int index = custList.indexOf(email);
		if(index == -1)
			throw new CustomerHandlingException("Invalid Email login failed ...");
	  Customer validCustomer = custList.get(index);
		
	  if(validCustomer.getPassword().equals(pass))
		  
		  throw new CustomerHandlingException("Invalid Passworld Login again ...");
	  
	  return validCustomer;
	}
	
	
	
}
