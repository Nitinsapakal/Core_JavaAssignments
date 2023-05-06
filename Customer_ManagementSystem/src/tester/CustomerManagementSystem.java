package tester;

import static utils.CustomerValidationRules.customerLogin;
import static utils.CustomerValidationRules.validateAllInputs;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.iacsd.Customer;

import custom_exceptions.CustomerHandlingException;
import static utils.CMSUtils.pupulateList;

public class CustomerManagementSystem {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {

			List<Customer> customerList = pupulateList();// new ArrayList<>();

			boolean exit = false;
			while (!exit) {
				System.out.println("1. Sign Up");
				System.out.println("2. Sign In");
				System.out.println("3. Display All");
				System.out.println("4. Change Password");
				System.out.println("5. Unsubscribe customer");
				System.out.println("6. sort  customer by email");
				System.out.println("7. sort  customer by dob regAmount ");
				System.out.println("0. Exit");

				System.out.println("Choose Option");

				try {

					switch (sc.nextInt()) {

					case 1:// sing up
						System.out
								.println(" Enter firstName, lastName, email, password,  regAmount, dob,	ServicePlan ");
						Customer ValidCustomer = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), sc.next(), customerList);
						customerList.add(ValidCustomer);
						System.out.println("Customer registerd.....!!!!!");
						break;

					case 2:// sing in
						System.out.println("Enter Email and Password");
						ValidCustomer = customerLogin(sc.next(), sc.next(), customerList);
						System.out.println(ValidCustomer);
						break;

					case 3:
						for (Customer c : customerList) {

							System.out.println(c);
						}
						break;

					case 4:
						System.out.println("Enter email, old Pass , new Pass");
						ValidCustomer = customerLogin(sc.next(), sc.next(), customerList);
						ValidCustomer.setPassword(sc.next());
						System.out.println(ValidCustomer);
						break;

					case 5:
						System.out.println("Enter Email id");
						Customer choosenEmail = new Customer(sc.next());
						int index = customerList.indexOf(choosenEmail);
						if (index == -1)
							throw new CustomerHandlingException("Email not found !!!?");

						Customer eobj = customerList.get(index);
						System.out.println("Enter Pass");
						if (!eobj.getPassword().equals(sc.next()))
							throw new CustomerHandlingException("pass not match");
//						customerList.remove(eobj);//--by obj remove
						// customerList.remove(index);//--by index remove
						System.out.println("Unsubscribe scuccesfully" + customerList.remove(index));
//					Iterator<Customer> itr = customerList.iterator();	
//						while(itr.hasNext())
//							if(itr.next().getEmail().equals(choosenEmail))
						break;
					case 6:

						Collections.sort(customerList);
						break;
					case 7:
						Collections.sort(customerList, new Comparator<Customer>() {

							@Override
							public int compare(Customer c1, Customer c2) {

								int returnvalue = c1.getDob().compareTo(c2.getDob());

								if (returnvalue == 0) {

//									if (c1.getRegAmount() < c2.getRegAmount())
//
//										return -1;
//
//									if (c1.getRegAmount() > c2.getRegAmount())
//
//										return 1;
//									return 0;
						         return ((Double)c1.getRegAmount()).compareTo(((Double)c2.getRegAmount()));
																		
								}

								return returnvalue;
							}

						});

						break;
					case 0:
						exit = true;
						break;

					}// switch
				} catch (Exception e) {

					e.printStackTrace();
					sc.nextLine();

				}

			} // while

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
