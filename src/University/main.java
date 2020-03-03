package University;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class main {

	public static void main(String[] args) throws IOException {
		employee manager1= new employee("123456789", "Nabeel", "Ayoub", new GregorianCalendar(1987,11,25), "Male",25000 , new address("Mughar", "rasElkhabye", "20128"), "Manager", "0508762828"); 
		
		//----------------------------------------------------------------------------------------------------------------------------

		lecturer l1 = new lecturer(10500, new address("Karmiel", "Havazelet", "19274"), "lecturer", "0529874719", "354675213", "Tom", "Duany", new GregorianCalendar(1990,8,9),"Male");
		lecturer l2 = new lecturer(16500, new address("TelAviv", "Alnby", "993321"), "lecturer", "0502389123", "553434542", "Hen", "ifrgan", new GregorianCalendar(1989,11,6),"Female");
		lecturer l3= new lecturer(11850, new address("Mughar", "westnieborhood", "20128"), "lecturer", "0507481938", "847103183", "Shadi", "Asakly", new GregorianCalendar(1985,8,21),"Male");
		lecturer l4 = new lecturer(14822, new address("turaan", "shayeb", "32141"), "lecturer", "0502748194", "319464719", "dudu", "tassa", new GregorianCalendar(1991,2,6),"Male");
		lecturer l5 = new lecturer(163831, new address("ramatGan", "Hashmal", "43211"), "lecturer", "0528572936", "298541894", "aviv", "gefen", new GregorianCalendar(1985,8,26),"Male");
		lecturer l6 = new lecturer(20300, new address("birut", "alsdaka", "19873"), "lecturer", "0506661111", "198453221", "haifa", "wehbi", new GregorianCalendar(1985,4,20),"Female");
		lecturer l7 = new lecturer(9800, new address("elaboun", "almahaba", "23411"), "lecturer", "0502198237", "284755980", "Ezat", "ibrahem", new GregorianCalendar(1992,6,19),"Male");

		//----------------------------------------------------------------------------------------------------------------------------
		
		//START
		//3 COURSES FOR DEP1 - SOFTWARE ENGINEERING 
		// LECTURERS IS L1,L2,L3
		
		course crs1= new course("C++",4, l1);   
		crs1.readFromFile("src\\courseStudents1.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l1.addCourse(crs1.getName());
		crs1.insertIntoDB();
		course crs2= new course("java", 5, l2);
		crs2.readFromFile("src\\courseStudents2.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l2.addCourse(crs2.getName());
		
		course crs3 = new course("python",3,l3);
		crs3.readFromFile("src\\courseStudents3.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l3.addCourse(crs3.getName());
		//END
		
		
		//------------------------------------------------------------------------------------------------------------------------
		//START
		//3 COURSES FOR DEP2 - DATA ANALYSIS
		// LECTURERS IS L4,L5,L6
		course crs4 = new course("dbStructers",5,l4);
		crs4.readFromFile("src\\courseStudents4.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l4.addCourse(crs4.getName());
		
		course crs5 = new course("powerBI",2,l5);
		crs5.readFromFile("src\\courseStudents5.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l5.addCourse(crs5.getName());
		
		course crs6 = new course("BigDATA",3,l6);
		crs6.readFromFile("src\\courseStudents6.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		//l6.addCourse(crs6.getName());
		//END

		//------------------------------------------------------------------------------------------------------------------------
		//START
		//3 COURSES FOR DEP3 - CYBER SECURITY
		// LECTURER IS L3
		course crs7= new course("Defence",6,l7);
		crs7.readFromFile("src\\courseStudents7.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs7.getName());
		
		course crs8= new course("Offensive",6,l7);
		crs8.readFromFile("src\\courseStudents8.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs8.getName());
		
		course crs9 = new course("FISMA",4,l7);
		crs9.readFromFile("src\\courseStudents9.txt"); 				//TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs9.getName());
		//END
		//------------------------------------------------------------------------------------------------------------------------
		department dep1= new department(5000, "Software Engineering");
		department dep2= new department(5001,"Data Analysis");
		department dep3 = new department(5002, "Cyber Security");

		//------------------------------------------------------------------------------------------------------------------------
			
		dep1.addCourse(crs1);
		dep1.addCourse(crs2); 			                           	//ADDING THE COURSES INTO A DEPARTMENT
		dep1.addCourse(crs3);
		//------------------------------------------------------------------------------------------------------------------------
		dep2.addCourse(crs4);
		dep2.addCourse(crs5); 			                           	//ADDING THE COURSES INTO A DEPARTMENT
		dep2.addCourse(crs6);
		//------------------------------------------------------------------------------------------------------------------------

		dep3.addCourse(crs7);
		dep3.addCourse(crs8); 			                           	//ADDING THE COURSES INTO A DEPARTMENT
		dep3.addCourse(crs9);
		//------------------------------------------------------------------------------------------------------------------------

		System.out.println(dep1.getCourses());
		university univ1= new university(9000,"Ort", new address("Karmiel","maalyORT" ,"19274"), manager1);
		univ1.addDepartments(dep1);
		univ1.addDepartments(dep2); 			                  	//ADDING THE DEPARTMENTS INTO A UNIVERSITY
		univ1.addDepartments(dep3);
		//------------------------------------------------------------------------------------------------------------------------
		UnivGUI p = new UnivGUI();
		
		
		
		
		p.show();	
		
	}
}
