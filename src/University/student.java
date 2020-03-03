package University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

public class student extends person   {

	private int studentNum;
	private address address;

	public student() {
	}

	public student(String id, String firstName, String lastName, GregorianCalendar birthDate, String sex, int studentNum,
			University.address address) {
		super(id, firstName, lastName, birthDate, sex);
		// TODO Auto-generated constructor stub
		setStudentNum(studentNum);
		setAddress(address);

	}

	public student(student s) {
		super(s);
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		if (numValidation(Integer.toString(studentNum)))
			this.studentNum = studentNum;
	}

	public address getAddress() {
		return address;
	}

	public String getAddressString()
	{
		return address.getCity() + " " + address.getStreet();
	}
	
	public void setAddress(address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "student [studentNum=" + studentNum + "," + getAddressString() + "," + super.toString() + "]";
	}

	public String getFulName() {
		return this.getFirstName() + " " + this.getLastName();

	}
	
	public boolean numValidation(String str) {  // for students num validation
		String expression = "^([0-9]{3,4})$";
		return str.matches(expression);
	}
	
	
	public void insertIntoDB() {
		try {
			String sql="INSERT INTO student VALUES("+getId()+",'"+getFirstName()+"','"+getLastName()+"',"+this.studentNum+",'"+this.getAddressString()+"')";
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
		
		e.printStackTrace();
	}		
		
	}
}
