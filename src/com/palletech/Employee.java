package com.palletech;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee 
{
	private static String url="jdbc:mysql://localhost:3306/emp";
	private static String username="root";
	private static String password="admin";
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static Statement s=null;
	
  public static void creating()
  {
	  try 
	  {
		  Scanner sc = new Scanner(System.in);
		    System.out.print("Enter table name: ");
		    String tableName = sc.next();
		  
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		s=con.createStatement();
		s.executeUpdate("create table employee(eno int primary key ,ename varchar(40),esal int)");
		s.close();
		con.close();
	}
	  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  finally
	  {
		 
			try {
				if(s!=null)
				s.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	  }
		
	  
  }
  
  public static void inserting()//int no,String name ,int sal)
  {
	  try
	  {
		  Scanner sc = new Scanner(System.in);
		   System.out.print("Enter employee id: ");
		   int e=sc.nextInt();
		    System.out.print("Enter employee name: ");
		    String Name = sc.next();
		    System.out.print("Enter salary: ");
		    int i=sc.nextInt();
		  
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("insert into employee(eno,ename,esal) values(?,?,?)");
		
		ps.setInt(1, e);
		ps.setString(2, Name);
		ps.setInt(3, i);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	} 
	  catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  finally
	  {
		 
			try
			{
				if(ps!=null)
				ps.close();
				if(con!=null)
					con.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	  }
	  		
  }
  
  public static void Updating()//int no,String name,int sal)
  {
	  try
	  {
		  Scanner sc = new Scanner(System.in);
		  
		    System.out.println("Enter emp new Name:");
		    String name=sc.next();
		    System.out.println("enter new salary:");
		    int sal=sc.nextInt();
		    System.out.print("Enter emp id: ");
		    int i = sc.nextInt();
		  
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("update employee set ename=?,esal=? where eno=?");
		
		ps.setString(1, name);
		ps.setInt(2, sal);
		ps.setInt(3, i);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	  catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  finally
	  {
		  
			try
		  {
				if(ps!=null)
				ps.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
  }
  
  public static void Deleting()//int no)
  {
	  try {
		  
		  Scanner sc = new Scanner(System.in);
		    System.out.print("Enter emp id to delete: ");
		    int i = sc.nextInt();
		    
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("delete from employee where eno=?");
		ps.setInt(1, i);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally
	  {
		  
		  try 
		  {
			 if(ps!=null) 
			 {
				ps.close();
			 }
		     if(con!=null)
		     {
		    	 con.close();
		     }
					  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
  }
  
  
  
}
