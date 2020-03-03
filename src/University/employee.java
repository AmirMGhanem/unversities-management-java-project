package University;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

public class employee extends person  {

	private int salary;
	private address address;
	private String position;
	private String contactNo;

	public employee() {
	}

	public employee(String id, String firstName, String lastName, GregorianCalendar birthDate, String sex, int salary,
			University.address address, String position, String contactNo) {
		super(id, firstName, lastName, birthDate, sex);
		setSalary(salary);
		setAddress(address);
		setPosition(position);
		setContactNo(contactNo);

	}

	public employee(employee e) {
		super(e.getId(), e.getFirstName(), e.getLastName(), e.getBirthDate(), e.getSex());
		setSalary(e.salary);
		setAddress(e.address);
		setPosition(e.position);
		setContactNo(e.contactNo);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		if (salary > 0)
			this.salary = salary;
	}

	public address getAddress() {
		return address;
	}

	public void setAddress(address address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		
		this.position = position;
	}

	public String getContactNo() {
		
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		if (numValidation(contactNo, 10))
			this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "employee [salary=" + salary + ", " + address.toString() + ", position=" + position + ", contactNo="
				+ contactNo + " " + super.toString() + " ]";
	}

	public String getFulName() {
		return this.getFirstName() + " " + this.getLastName();

	}
@Override
	public void insertIntoDB() {
	try {
		 {
		String sql="INSERT INTO employee VALUES('"+this.getId()+"','"+this.getFirstName() + "',' " + this.getLastName()+"',"+this.getSalary()+",'"+this.getAddress().getCity()+" "+this.getAddress().getStreet()+"','"+this.position+"','"+this.contactNo+"')";
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
