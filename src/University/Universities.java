package University;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Universities implements IdbMySQL {

	ArrayList<university> univList;
	
	public Universities()
	{
		univList=new ArrayList<university>();
	}
	
	public void addUniv(university u) {
		univList.add(u);
	}

	
	public void ExportToFile(FileWriter f) throws IOException {
		ArrayList<String> strarr = new ArrayList<String>();

		for (int i = 0; i < this.univList.size(); i++) {
			strarr.add(this.univList.get(i).getId() + ", " + this.univList.get(i).getName() + ", "
					+ this.univList.get(i).getAddress().getCity() + ", " + this.univList.get(i).getManager().getFulName() + " ");
		}

		

		for (int i = 0; i < strarr.size(); i++) {

			f.write(strarr.get(i));
			f.write(System.getProperty("line.separator"));
		}
		f.close();
	}
	
	
	@Override
	public String toString() {
		return "Universities [univList=" + univList + "]";
	}

	@Override
	public void insertIntoDB() {
		try {
			for(int i=0;i<univList.size();i++) {
			String sql="INSERT INTO university VALUES("+univList.get(i).getId()+",'"+univList.get(i).getAddress().getCity() + " " + univList.get(i).getAddress().getStreet()+"','"+univList.get(i).getManager().getFulName()+"')";
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
	public void insertIntoDB(university u) {
		try {
			 {
			String sql="INSERT INTO university VALUES("+u.getId()+",'"+u.getAddress().getCity() + " " + u.getAddress().getStreet()+"','"+u.getManager().getFulName()+"')";
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
