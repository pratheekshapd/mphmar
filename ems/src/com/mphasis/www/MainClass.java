package com.mphasis.www;

public class MainClass{
	int y=150;
	public void eat()
	{
		System.out.println("eating..");
	}
	public void sleep()
	{
		System.out.println("sleeping..");
	}
	public static void main(String[] args){
		System.out.println("hello world!!!");
		System.out.println("Sun");
		System.out.println("static variable:");
		int x=566;
		
		
		MainClass ravi= new MainClass() ;  //Instantiation of class
		ravi.eat();
		ravi.sleep();
		System.out.println(ravi);

		new MainClass().eat();
		System.out.println(new MainClass());
		
}
}
