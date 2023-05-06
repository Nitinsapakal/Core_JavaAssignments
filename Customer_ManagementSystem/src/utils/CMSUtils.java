package utils;
import custom_exceptions.*;
import com.iacsd.*;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.ArrayList;
import java.util.List;;
public class CMSUtils {
	
	public static List<Customer> pupulateList() throws CustomerHandlingException{
	
	ArrayList<Customer> customers = new ArrayList <>();
	
	customers.add(validateAllInputs("kiran", "seth", "kiran@gmail.com", "3456",2000, "1998-12-01", "GOLD", customers));
	customers.add(validateAllInputs("Rama", "kher", "rama@gmail.com", "3428",1000, "2000-02-15", "SILVER", customers));
	customers.add(validateAllInputs("akash", "seth", "akash@gmail.com", "3456",2000, "1999-10-01", "GOLD", customers));
	customers.add(validateAllInputs("rahul", "mahale", "rahul@gmail.com", "3456",10000, "1997-05-01", "PLATINUM", customers));
	customers.add(validateAllInputs("gautam", "seth", "gautam@gmail.com", "3456",2000, "1996-12-01", "GOLD", customers));
	customers.add(validateAllInputs("saurabh", "seth", "saurabh@gmail.com", "3456",10000, "1999-06-05", "PLATINUM", customers));
	customers.add(validateAllInputs("viru", "seth", "viru@gmail.com", "3456",2000, "2001-04-01", "GOLD", customers));
	customers.add(validateAllInputs("karan", "seth", "karan@gmail.com", "3456",2000, "1998-03-04", "GOLD", customers));
	
	
	return customers;
	}
}
