package University;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class department implements IService,IdbMySQL {

	private int id;
	private String name;
	private ArrayList<course> courses = new ArrayList<course>();

	public department() {
	}

	public department(int id, String name) {
		setId(id);
		setName(name);
	}

	public void addCourse(course c) {
		courses.add(c);

	}

	public ArrayList<String> getcoursesName() throws IOException {

		ArrayList<String> strarr = new ArrayList<String>();

		for (int i = 0; i < this.courses.size(); i++) {
			strarr.add((this.courses.get(i).getName()));
		}

		return strarr;

	}

	public ArrayList<course> getCourses() {

		return courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (numValidation(Integer.toString(id), 4))
			this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		if (nameValidation(name))
			this.name = name;
	}

	public void ExportDepToFile(FileWriter f) throws IOException {
		ArrayList<String> strarr = new ArrayList<String>();

		for (int i = 0; i < this.courses.size(); i++) {
			strarr.add((this.courses.get(i).getName() + " " + this.courses.get(i).getLecturer().getFulName()  + " "+ this.courses.get(i).getPoints()));
		}

		

		for (int i = 0; i < strarr.size(); i++) {

			f.write(strarr.get(i));
			f.write(System.getProperty("line.separator"));
		}
		f.close();
	}
	
	
	public void ExportToFile() {
		ArrayList<String> strarr = new ArrayList<String>();

		for (int i = 0; i < this.courses.size(); i++) {
			strarr.add((this.courses.get(i).getName() + " " + this.courses.get(i).getPoints() + " "
					+ this.courses.get(i).getLecturer().getFirstName() + " "));
		}

		FileWriter f = null;
		try {
			f = new FileWriter("src/CoursesOutput.txt");

			for (int i = 0; i < strarr.size(); i++) {

				f.write(strarr.get(i));
				f.write(System.getProperty("line.separator"));
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "department [id=" + id + ", name=" + name + ", courses=" + courses + "]";
	}

	

	public boolean nameValidation(String str) {
		String expression = "^[A-Za-z\\s]+$";
		return str.matches(expression);
	}

	@Override
	public void insertIntoDB() {
		try {
			for(int i=0;i<courses.size();i++) {
			String sql="INSERT INTO course VALUES('"+courses.get(i).getName()+"',"+courses.get(i).getPoints()+")";
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);}
		} catch (SQLException e) {
		
		e.printStackTrace();
	}		
}

	
	
	public void insertDepDB()
	{
		try {
			String sql="INSERT INTO department VALUES("+this.id+",'"+this.name+"')";
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
		
		e.printStackTrace();
	}		
	}
	
	@Override
	public void dropFromDB() {
		// TODO Auto-generated method stub
		
	}
}
