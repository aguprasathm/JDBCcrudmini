package com.palletech;

import java.util.Scanner;

public class Myprogram {

	public static void main(String[] args) 
	{
		int val=0;
		Scanner sc=new Scanner(System.in);
		//System.out.println("press 1 to create table");;
		for(int i=1;i<=5;i++) 
		{
			val=sc.nextInt();
			
			switch(val)
			{
			case 1:
				//System.out.println("press 1 to create table");
				
				Employee.creating();
				System.out.println("press 2 to insert a row into table");
				break;
				
			case 2:
				//System.out.println("press 2 to insert a row into table");
				Employee.inserting();
				System.out.println("press 3 to udate a table");
				break;
				
			case 3:
				//System.out.println("press 3 to udate a table");
				Employee.Updating();
				break;
				
			case 4:
				System.out.println("press 4 to delete the table");
				Employee.Deleting();
				break;
				
			case 5:
				System.out.println("press 5 to exit table");
				break;
			}
		}
		
	}

}
