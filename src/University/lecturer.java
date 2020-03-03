package University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;


public class lecturer extends employee{
	
	private ArrayList<String> taughtCourses= new ArrayList<String>();
	
	public ArrayList<String> getTaughtCourses() {
		return taughtCourses;
	}


	public void setTaughtCourses(ArrayList<String> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}


	public lecturer(int salary, University.address address, String position, String contactNo, String id,
			String firstName, String lastName, GregorianCalendar birthDate, String sex) {
		super(id, firstName, lastName, birthDate, sex,salary,address,position,contactNo);
		// TODO Auto-generated constructor stub
		
	}

	
	public void addCourse(String courseName)
	{
			taughtCourses.add(courseName);
		
	}

	public void removeCourse(int index)
	{
		taughtCourses.remove(index);
	}

	public int CoursesTaughtNo()
	{
		return taughtCourses.size();
	}


	
	public String courses()
	{
		String str="";
		for(int i=0;i<taughtCourses.size();i++)
			str+=   taughtCourses.get(i)+" , ";
		return str;
		}
	
	@Override
	public String toString() {
		return "lecturer [taughtCourses=" + taughtCourses+super.toString()+"]";
	}

	public void insertIntoDB() {
	try {
		 {
		String sql="INSERT INTO lecturer VALUES('"+this.getId()+"','"+this.getFirstName() + "',' " + this.getLastName()+"',"+this.getSalary()+",'"+this.getAddress().getCity()+" "+this.getAddress().getStreet()+"','"+getPosition()+"','"+getContactNo()+"')";
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
		
		Statement myStmt = myConn.createStatement();
		myStmt.executeUpdate(sql);
		System.out.println(sql);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	

}

