package com.mphasis.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mphasis.dao.EmployeeDao;
import com.mphasis.model.Employee;
import com.mphasis.model.Salary;
import com.mphasis.sorteg.Student;
import com.mphasis.model.Manager;

public class Employeecontroller implements EmployeeInterface {
	public Employeecontroller() {
		super();
	}
	Employee emp;
	Salary sal;
	Manager man;
	List emplist = new ArrayList();
	EmployeeDao empdao = new EmployeeDao();
	//Student s = new Student();
	//private Object cors;
	public List addEmployee() {
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);
		emp.setEname(enam);
		
		sal = new Salary(eno, eno, eno, eno, eno);

		System.out.println("Enter basic Salary");
		int basic = (int) sc.nextDouble();
		sal= new Salary(basic);
		
		//sal.setBasic(basic);
	
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter PF");
		int pf= sc.nextInt();
		sal.setPf((int) basic);
		
		sal.setGross(basic,sal.getDa(),sal.getHra());
		sal.setNet(sal.getGross(),sal.getPf());
	//	sal.setGross(basic, da, hra);
	//	sal.setNet(sal.getGross(),pf);
		emp.setSalary(sal);
		//emplist.add(emp);
		
		empdao.insertEmp(emp);
		System.out.println("Employee "  + eno + " Succesfully added");
		return emplist;
	}
public void viewEmployee(List emplist) {

	/*	Iterator i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}*/
	empdao.viewEmp();
}
public void addManager()
{
	man = new Manager();
	Scanner  sc = new Scanner(System.in);
	System.out.println("Enter mname");
	String mn = sc.next();
	man.setEname(mn);
	System.out.println("Enter dept");
	String dn = sc.next();
	man.setEname(dn);
	System.out.println("Employee dept Succesfully added");
	}
public void viewManager()
{
	System.out.println(man+" "+emp);	
}
	public void sortByName(List emplist)

	{
		Collections.sort(emplist,Employee.nameComparator);
		/*
		 Iterator i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			*/
			
			emplist.forEach(lis ->System.out.println(lis)); 
		}

	@Override
	public void serial()
	{
		FileOutputStream fos =null ;
		ObjectOutputStream oos =null;
		try {
			fos= new FileOutputStream("myfile.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			
			System.out.println("Data successfully Serialized...");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	@Override
	public void Deserial() {

			Employee st = null;
		
				try (FileInputStream fis = new FileInputStream("myfile.txt");
						ObjectInputStream ois = new ObjectInputStream(fis)) {
					st =(Employee)ois.readObject();
					fis.close();
					ois.close();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(st.getEid());
			System.out.println(st.getEname());
			System.out.println(st.getSalary());
			
		}

	public void insertUsingProc()
	{
		Employee e = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}
	
	public void rsmd()
	{
		empdao.rsmd();
	}


	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}

	

	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();
		
	}

	
	@Override
	public void type_scroll_sensitive_rs_update() {
		empdao.type_scroll_sensitive_rs_update();
		
	}

	@Override
	public void batchUpdate() {
		empdao.batchUpdate();
		
	}
	}
	


	




