package com.mphasis.view;


import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.sql.SQLException;
import com.mphasis.util.MyDBConnection;
import com.Exception.EmployeenotfoundException;
//EmployeeNotFoundException
import com.mphasis.controller.EmployeeInterface;
import com.mphasis.controller.Employeecontroller;
import com.mphasis.model.Employee;
import com.mphasis.model.Manager;

public class MainClass extends EmployeenotfoundException { 

	public static void main(String[] args) {
		EmployeeInterface ec = new Employeecontroller();
		Manager m = new Manager();
		//ManagerController mg=new ManagerController();
		Scanner sc = new Scanner(System.in);
		List<Employee> elist=null;
		//List<Manager> mlist=null;
		String input = null;
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter password");
		String pwd=sc.next();
		
		try
		{	
			BiPredicate<String, String> pred = (un,pw)->un.equals("prat")&&pw.equals("pd");
		
		
			if (pred.test(user,pwd))
				{
				
				System.out.println("Please wait!!! ");
				try{
					Thread.sleep(3000);
				}
				catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
		do {
			System.out.println("Enter your Choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Add Manager");
			System.out.println("4. View Manager");
			System.out.println("5. Sort Employee byname");
		//	System.out.println("6. View sorted list");
			System.out.println("6. serialize");
			System.out.println("7. Deserialize");
			System.out.println("8. Procedure Insert");
			System.out.println("9. Get ResultSet MetaData Info ");
			System.out.println("10. RS Forward Only");
			System.out.println("11. RS scroll insensitive");
			System.out.println("12. RS scroll sensitive");
			System.out.println("13. RS scroll sensitive - update");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				elist=ec.addEmployee();
				break;
			}

			case 2: {
					ec.viewEmployee(elist);
				break;
			}
			case 3: {
				ec.addManager();
				break;
			}
			case 4: {
				ec.viewManager();
				break;
			}
			case 5: {
				ec.sortByName(elist);
				break;
			}
			
			case 6: {
				ec.serial();
				break;
			}
			case 7: {
				ec.Deserial();
				break;
			}
			case 8: {
				ec.insertUsingProc();
				break;
			}
			case 9: {
				ec.rsmd();
				break;
			}
			case 10: {
				ec.type_forward_only_rs();
				break;
			}
			case 11: {
				ec.type_scroll_insensitive_rs();
				break;
			}
			case 12: {
				ec.type_scroll_sensitive_rs_insert();
			}
			case 13: {
				ec.type_scroll_sensitive_rs_update();
			}
			case 14: {
				ec.batchUpdate();
			}

			default: {

			}

			}
			System.out.println("Do you want to continue ? Y or y for yes");
			input = sc.next();
		} while (input.equals("Y") || input.equals("y"));
		System.out.print("System exited.. ");
		System.exit(0);
		}
			else
			{
				throw new EmployeeNotFoundException();
			}
		}
		catch(EmployeeNotFoundException enf)
		{
			System.out.println(enf);
		}
		finally
		{
			System.out.println("Finally Executed");
		}
	}
}
	
		
		
	

		
	
		



			
		