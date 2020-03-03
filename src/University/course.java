package University;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class course implements IService ,IdbMySQL{

	private String name;
	private int points;
	private lecturer lecturer;
	private ArrayList<student> students = new ArrayList<student>(50);

	public course() {

	}

	public course(String name) {setName(name);}
	
	public course(course c) {

		setName(c.name);
		setPoints(c.points);
		setLecturer(c.getLecturer());

	}

	public course(String name, int points, University.lecturer lecturer) {
		setName(name);
		setPoints(points);
		setLecturer(lecturer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//if (nameValidation(name))
			this.name = name;

	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		if (points > 0)
			this.points = points;
	}

	public lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public void printStudentsDetails() {
		for (student std : students) {
			if (std != null)
				System.out.println(std.getFulName() + "  " + std.getStudentNum());
		}
	}

	public void ExportToFile(FileWriter f) throws IOException {
		ArrayList<String> strarr = new ArrayList<String>();

		for (int i = 0; i < this.students.size(); i++) {
			strarr.add(this.students.get(i).getFirstName() + " " + this.students.get(i).getStudentNum() + " "
					+ this.students.get(i).getAddress().getCity() + " " + this.students.get(i).getSex() + " ");
		}

		

		for (int i = 0; i < strarr.size(); i++) {

			f.write(strarr.get(i));
			f.write(System.getProperty("line.separator"));
		}
		f.close();
	}

	private student[] ReadFromFileToConstructor(File file) throws FileNotFoundException {

		try (Scanner input = new Scanner(file)) {
			ArrayList<String> list = new ArrayList<String>();
			String[][] line = new String[50][];
			student[] s = new student[50];

			while (input.hasNextLine()) {
				list.add(input.nextLine());
			}
			list.trimToSize();
			for (int i = 0; i < list.size(); i++) {
				line[i] = list.get(i).split(" ");
			}

			for (int i = 0; i < list.size(); i++) {
				int stdno = Integer.parseInt(line[i][5]);
				int year = Integer.parseInt(line[i][2]);

				int month = Integer.parseInt(line[i][0]);
				int day = Integer.parseInt(line[i][1]);

				s[i] = new student(line[i][6], line[i][7], line[i][8], new GregorianCalendar(year, month, day), line[i][3], stdno,
						new address(line[i][10], line[i][9], line[i][4]));

			}
			return s;
		}
	}

	public void readFromFile(String src)
	{
		File file1= new File(src);
		student[] std = null;
		try {
			std = ReadFromFileToConstructor(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<std.length;i++)
			if(std[i]!=null)
				AddStudent(std[i]);

	}
	
	
	public ArrayList<student> getStudent() {
		return students;
	}

	public void setStudents(ArrayList<student> student) {
		this.students = student;
	}

	public void AddStudent(student s) {
		if (students.size() < 50)
			students.add(s);
	}

	public void AddStudent(String id, String firstName, String lastName, GregorianCalendar birthDate, String sex, int studentNum,
			University.address address) {
		students.add(new student(id, firstName, lastName, birthDate, sex, studentNum, address));
	}
	
	public void AddLecturer(lecturer lec)
	{
		setLecturer(lec);
	}
	
	@Override
	public String toString() {
		return "course [name=" + name + ", points=" + points + ", lecturer=" + lecturer + ", student=" + students + "]";
	}

	public void RemoveStudent(int index) {
		if (students.get(index) != null)
			students.remove(index);
	}

	
	
	@Override
	public void insertIntoDB() {
		try {
			String sql="INSERT INTO course VALUES('"+this.name+"',"+this.points+",'"+this.getLecturer().getFulName()+"')";
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}
	
	
	public void insertStudentsDB() {
		
		
		try {
			for(int i=0;i<students.size();i++) {
			String sql="INSERT INTO student VALUES("+students.get(i).getId()+",'"+students.get(i).getFirstName()+"','"+students.get(i).getLastName()+"',"+students.get(i).getStudentNum()+",'"+students.get(i).getAddressString()+"')";
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
			
			Statement myStmt = myConn.createStatement();
			myStmt.executeUpdate(sql);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void insertIntoSTDCRS(student s)
	{
		try {
			String sql="INSERT INTO studentincourse VALUES('"+s.getId()+"','"+this.name+"','"+this.getLecturer().getId()+"')";
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

	@Override
	public void dbConnection() {
		// TODO Auto-generated method stub
		
	}

	


}
