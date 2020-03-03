package University;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class university implements IService,IdbMySQL {

	private int id;
	private String name;
	private address address;
	private employee manager;
	private ArrayList<department> departments = new ArrayList<department>();
	private ArrayList<employee> role = new ArrayList<employee>();
	private signInfo si;
	
	public university(int id,String name, address address ) {
		setId(id);
		setAddress(address);
		setName(name);
	}
	
	
	public university(int id,String name, address address, employee manager) {
		setId(id);
		setAddress(address);
		setManager(manager);
		setName(name);
	}

	public void addManager(employee manager)
	{
		setManager(manager);
	}
	
	public void addDepartments(department dep) {
		departments.add(dep);

	}
	

	public int getId() {
		return id;
	}

	public address getAddress() {
		return address;
	}

	public void setAddress(address address) {
		this.address = address;
	}

	public employee getManager() {
		return manager;
	}

	public void setManager(employee manager) {
		this.manager = manager;
	}

	public ArrayList<department> getDepartments() {
		return departments;
	}

	public void setDepartments(ArrayList<department> departments) {
		this.departments = departments;
	}

	public ArrayList<employee> getRole() {
		return role;
	}

	public void setRole(ArrayList<employee> role) {
		this.role = role;
	}
	
	public void addRole(employee e) {role.add(e);}
	
	public void setId(int id) {
		if (numValidation(Integer.toString(id), 4))
			this.id = id;
	}

	public void ExportDepToFile(FileWriter f) throws IOException {
		
		ArrayList<String> strarr = new ArrayList<String>();
		for (int i = 0; i < this.departments.size(); i++) {
			strarr.add((this.departments.get(i).getName() + " " + this.departments.get(i).getId() + " "));
		}

		

		for (int i = 0; i < strarr.size(); i++) {

			f.write(strarr.get(i));
			f.write(System.getProperty("line.separator"));
		}
		f.close();
	}



	@Override
	public String toString() {
		return "university [id=" + id + ", address=" + address + ", manager=" + manager + ", departments=" + departments
				+ ", role=" + role + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(nameValidation(name))
			this.name = name;
	}

	public void insertDepinuniv(String sql)
	{
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
		
		e.printStackTrace();
	}		
	}	
	
	
		public void insertIntoDB(department d) {
			try {
				String sql="INSERT INTO department VALUES("+d.getId()+",'"+d.getName() +"')";
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
				
				Statement myStmt = myConn.createStatement();
				myStmt.executeUpdate(sql);
				System.out.println(sql);
				}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}	
	
		@Override
		public void insertIntoDB() {
			try {
				for(int i=0;i<departments.size();i++) {
				String sql="INSERT INTO department VALUES("+departments.get(i).getId()+",'"+departments.get(i).getName() +"')";
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

	@Override
	public void dropFromDB() {
		// TODO Auto-generated method stub
		
	}


	public signInfo getSi() {
		return si;
	}


	public void setSi(signInfo si) {
		this.si = si;
	}




}
