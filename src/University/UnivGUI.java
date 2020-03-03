package University;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class UnivGUI extends JFrame implements ActionListener, MouseListener {

	ArrayList<course> ALcrs = new ArrayList<course>();
	ArrayList<department> ALdep = new ArrayList<department>();
	ArrayList<university> ALuniv = new ArrayList<university>();
	ArrayList<lecturer> ALlec = new ArrayList<lecturer>();
	ArrayList<student> ALstd = new ArrayList<student>();
	ArrayList<employee> ALemp = new ArrayList<employee>();
	ArrayList<signInfo> ALsi = new ArrayList<signInfo>();
	protected String dateNow;
	static int flag1 = 0;
	static int flag2 = 0;
	static int flag3 = 0;
	static int flag4 = 0;
	static int flag5 = 0;
	// LINE_END Components
	JPanel pDetails;
	protected JLabel LadminLogin;
	protected JTextField TFadminLogin;
	protected JLabel LadminPassword;
	protected JPasswordField TFadminPassword;
	protected JButton BSubmit;
	protected JButton Register;
	// LINE_START components
	JPanel pNav;
	protected JButton Bstudents;
	protected JButton Buniversities;
	protected JButton Bdepartments;
//	protected JButton BstaffSignUP;
	protected JButton Bcourses;
	protected JButton Bsettings;

	// PAGE_START components
	JPanel pToolBar;

	protected JLabel LtimeMessage;
	protected JLabel LdateInfo;

	// PAGE_END components
	JPanel pBottomBar;

	protected JLabel Lxyposes;

	// CENTER JPanels
	// TODO
	JPanel puniversities;
	JLabel LuniversityName;
	JTextField TFuniversityName;
	JLabel LuniversityId;
	JTextField TFuniversityId;
	JLabel LuniversityAddress;
	JTextField TFuniversityCity;
	JTextField TFuniversityStreet;
	JTextField TFuniversityZip;
	JLabel LuniversityManager;
	Choice CHuniversityManager;
	JButton BunivInsert, BunivInsertDB, BunivExport, BunivClear, BfindUniv, BaddManager;
	JLabel LsearchResuniv;

	JPanel pDepartments;
	JLabel Ldepartmentuniv;
	Choice CHdepartmentuniv;
	JLabel LdepartmentName;
	JTextField TFdepartmentName;
	JLabel LdepartmentId;
	JTextField TFdepartmentId;
	JButton BdepInsert, BdepInsertDB, BdepExport, BdepClear, BfindDep;
	JLabel LsearchResdep;

	JPanel pCourses;

	JLabel LcourseDep;
	Choice CHcourseDep;
	JLabel LcourseName;
	JTextField TFcourseName;
	JLabel LcoursePoints;
	SpinnerModel SMcoursePoints = new SpinnerNumberModel(0, 0, 9, 1); // default value,lower bound,upper bound,increment
																		// by
	JSpinner spinner = new JSpinner(SMcoursePoints);
	JLabel LcourseLecturer;
	Choice CHcourseLecturer;
	JLabel LfindCrs;
	JButton BcourseInsert, BcourseInsertDB, BcourseExport, BcourseClear, BfindCourse, BaddLecturer; // ***

	JPanel pCenter;
	JPanel pCenter1;
	JPanel pCenter2;

	JPanel ManagerAdder;
	JLabel LmanagerId;
	JTextField TFmanagerId;
	JLabel LmanagerFirst;
	JTextField TFmanagerFirst;
	JLabel LmanagerLast;
	JTextField TFmanagerLast;
	JLabel LmanagerBD;
	JTextField TFmanagerBD;
	JLabel LmanagerSex;
	Choice CHsex;
	JLabel Lsalary;
	SpinnerModel SMmanagerSal = new SpinnerNumberModel(6000, 6000, 40000, 1000);
	JSpinner spinner2 = new JSpinner(SMmanagerSal);

	JLabel LmanagerAdd;
	JTextField TFmanagerCity;
	JTextField TFmanagerStreet;
	JTextField TFmanagerZip;

	JLabel LcontactNo;
	JTextField TFmanagerContact;
	JButton BmanagerAdder;
	JButton BmanagerClear;
	JButton BmanagerClose;
	// ---------------------------------------------

	JPanel LecturerAdder;
	JLabel LlecturerID;
	JTextField TFlecturerID;
	JLabel LlecturerFirst;
	JTextField TFlecturerFirst;
	JLabel LlecturerLast;
	JTextField TFlecturerLast;
	JLabel LlecturerBD;
	JTextField TFlecturerBD;
	JLabel LlecturerSex;
	Choice CHlecsex;
	JLabel Llecsalary;
	SpinnerModel SMlecturerSal = new SpinnerNumberModel(6000, 6000, 40000, 1000);
	JSpinner spinner3 = new JSpinner(SMlecturerSal);

	JLabel LlecturerAdd;
	JTextField TFlecturerCity;
	JTextField TFlecturerStreet;
	JTextField TFlecturerZip;

	JLabel LleccontactNo;
	JTextField TFlecContact;
	JButton BlecturerAdder;
	JButton BLecturerClear;
	JButton BlecturerClose;

	JPanel pStaffSignUp;
	JPanel pStudents;

	JLabel LcourseSTD;
	Choice ChcourseSTD;
	JLabel LstudentID;
	JTextField TFStudentID;
	JLabel LstudentFirstName;
	JTextField TFstudentFirstName;
	JLabel LstudentLastName;
	JTextField TFstudentLastName;
	JLabel LstudentNum;
	JTextField TFstudentNum;
	JLabel LstudentSex;
	Choice CHstudentSex;
	JLabel LstudentBD;
	JTextField TFstudentBD;
	JLabel LstudentAddress;
	JTextField TFstudentCity;
	JTextField TFstudentStreet;
	JTextField TFstudentZIP;
	JButton BstudentClear, BstudentExport, BstudentInsert, BstudentInsertDB;

	JPanel pSRCH;
	JLabel LsrchId;
	JTextField TFsrchId;
	JRadioButton RBstd;
	JRadioButton RBlec;
	JRadioButton RBdep;
	JRadioButton RBuniv;
	JRadioButton RBemp;
	JTextArea TAsrchRes;
	JButton Bfind;
	// CENTER JPanels END!!!!!
	Universities All;

	public UnivGUI() {
		super("University Manager");
		pCenter = new JPanel(new GridLayout(0, 1));
		pCenter1 = new JPanel(new FlowLayout());
		pCenter.add(pCenter1);

		pCenter2 = new JPanel(new FlowLayout());
		pCenter.add(pCenter2);
		pSRCH = new JPanel(new GridLayout(0, 1));
		pNav = new JPanel(new GridLayout(0, 1));
		pDetails = new JPanel(new FlowLayout(2));
		pToolBar = new JPanel();
		pBottomBar = new JPanel();
		pCourses = new JPanel(new GridLayout(0, 2));
		pDepartments = new JPanel(new GridLayout(0, 2));
		puniversities = new JPanel(new GridLayout(0, 2));
		ManagerAdder = new JPanel(new GridLayout(0, 2));
		LecturerAdder = new JPanel(new GridLayout(0, 2));
		pStudents = new JPanel(new GridLayout(0, 2));
		pCenter1.add(puniversities);
		pCenter2.add(ManagerAdder);
		pCenter1.add(pDepartments);
		pCenter1.add(pCourses);
		pCenter1.add(pStudents);
		pCenter2.add(LecturerAdder);
		pCenter2.add(pSRCH);

		siReader();
		DataInit();
		pSRCHinit();
		pNavBarInit();
		pNav.setVisible(false);
		pBottomBarInit();
		pToolBarInit();
		pDetailsInit();
		pDepInit();
		pCourseInit();
		pStudentsInit();
		pManagerAdder();
		plecturerAdder();
		pUnivInit();
		add(pCenter, BorderLayout.CENTER);
		setSize(1300, 700);
		addMouseListener(this);
		this.setBackground(Color.black);
	}

	private void siReader() {
		Connection myConn;
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC", "root", "");

			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT username,password FROM signinfo ");
			while (myRs.next()) {
				System.out.println("username : "+ myRs.getString("username") + " -- password : " + myRs.getString("password"));
				signInfo SI = new signInfo(myRs.getString("username"), myRs.getString("password"));
				ALsi.add(SI);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	private void DataInit() {

		employee manager1 = new employee("123456789", "Nabeel", "Ayoub", new GregorianCalendar(1987, 11, 25), "Male",
				25000, new address("Mughar", "rasElkhabye", "20128"), "Manager", "0508762828");
		ALemp.add(manager1);
		// ----------------------------------------------------------------------------------------------------------------------------

		lecturer l1 = new lecturer(10500, new address("Karmiel", "Havazelet", "19274"), "lecturer", "0529874719",
				"354675213", "Tom", "Duany", new GregorianCalendar(1990, 8, 9), "Male");
		lecturer l2 = new lecturer(16500, new address("TelAviv", "Alnby", "993321"), "lecturer", "0502389123",
				"553434542", "Hen", "ifrgan", new GregorianCalendar(1989, 11, 6), "Female");
		lecturer l3 = new lecturer(11850, new address("Mughar", "westnieborhood", "20128"), "lecturer", "0507481938",
				"847103183", "Shadi", "Asakly", new GregorianCalendar(1985, 8, 21), "Male");
		lecturer l4 = new lecturer(14822, new address("turaan", "shayeb", "32141"), "lecturer", "0502748194",
				"319464719", "dudu", "tassa", new GregorianCalendar(1991, 2, 6), "Male");
		lecturer l5 = new lecturer(163831, new address("ramatGan", "Hashmal", "43211"), "lecturer", "0528572936",
				"298541894", "aviv", "gefen", new GregorianCalendar(1985, 8, 26), "Male");
		lecturer l6 = new lecturer(20300, new address("birut", "alsdaka", "19873"), "lecturer", "0506661111",
				"198453221", "haifa", "wehbi", new GregorianCalendar(1985, 4, 20), "Female");
		lecturer l7 = new lecturer(9800, new address("elaboun", "almahaba", "23411"), "lecturer", "0502198237",
				"284755980", "Ezat", "ibrahem", new GregorianCalendar(1992, 6, 19), "Male");

		ALlec.add(l1);
		ALlec.add(l2);
		ALlec.add(l3);
		ALlec.add(l4);
		ALlec.add(l5);
		ALlec.add(l6);
		ALlec.add(l7);

		// ----------------------------------------------------------------------------------------------------------------------------

		// START
		// 3 COURSES FOR DEP1 - SOFTWARE ENGINEERING
		// LECTURERS IS L1,L2,L3

		course crs1 = new course("C++", 4, l1);
		crs1.readFromFile("src\\courseStudents1.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l1.addCourse(crs1.getName());

		course crs2 = new course("java", 5, l2);
		crs2.readFromFile("src\\courseStudents2.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l2.addCourse(crs2.getName());

		course crs3 = new course("python", 3, l3);
		crs3.readFromFile("src\\courseStudents3.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l3.addCourse(crs3.getName());
		// END

		// ------------------------------------------------------------------------------------------------------------------------
		// START
		// 3 COURSES FOR DEP2 - DATA ANALYSIS
		// LECTURERS IS L4,L5,L6
		course crs4 = new course("dbStructers", 5, l4);
		crs4.readFromFile("src\\courseStudents4.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l4.addCourse(crs4.getName());

		course crs5 = new course("powerBI", 2, l5);
		crs5.readFromFile("src\\courseStudents5.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l5.addCourse(crs5.getName());

		course crs6 = new course("BigDATA", 3, l6);
		crs6.readFromFile("src\\courseStudents6.txt"); // TXT FILE FOR IMPORTING STUDENTS
		// l6.addCourse(crs6.getName());
		// END

		// ------------------------------------------------------------------------------------------------------------------------
		// START
		// 3 COURSES FOR DEP3 - CYBER SECURITY
		// LECTURER IS L3
		course crs7 = new course("Defence", 6, l7);
		crs7.readFromFile("src\\courseStudents7.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs7.getName());

		course crs8 = new course("Offensive", 6, l7);
		crs8.readFromFile("src\\courseStudents8.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs8.getName());

		course crs9 = new course("FISMA", 4, l7);
		crs9.readFromFile("src\\courseStudents9.txt"); // TXT FILE FOR IMPORTING STUDENTS
		l7.addCourse(crs9.getName());
		// END
		ALcrs.add(crs1);
		ALcrs.add(crs2);
		ALcrs.add(crs3);
		ALcrs.add(crs4);
		ALcrs.add(crs5);
		ALcrs.add(crs6);
		ALcrs.add(crs7);
		ALcrs.add(crs8);
		ALcrs.add(crs9);
		for (int i = 0; i < ALcrs.size(); i++) {
			if (ALcrs.get(i).getStudent() != null) {
				ALstd.addAll(ALcrs.get(i).getStudent());

			}
		}
		System.out.println("Initializing students -- " + ALstd.size());
		System.out.println("Courses Added -- "  + ALcrs.size());

		// ------------------------------------------------------------------------------------------------------------------------
		department dep1 = new department(5000, "Software Engineering");
		department dep2 = new department(5001, "Data Analysis");
		department dep3 = new department(5002, "Cyber Security");

		// ------------------------------------------------------------------------------------------------------------------------
		dep1.addCourse(crs1);
		dep1.addCourse(crs2); // ADDING THE COURSES INTO A DEPARTMENT
		dep1.addCourse(crs3);
		// ------------------------------------------------------------------------------------------------------------------------
		dep2.addCourse(crs4);
		dep2.addCourse(crs5); // ADDING THE COURSES INTO A DEPARTMENT
		dep2.addCourse(crs6);
		// ------------------------------------------------------------------------------------------------------------------------

		dep3.addCourse(crs7);
		dep3.addCourse(crs8); // ADDING THE COURSES INTO A DEPARTMENT
		dep3.addCourse(crs9);
		// ------------------------------------------------------------------------------------------------------------------------
		ALdep.add(dep1);
		ALdep.add(dep2);
		ALdep.add(dep3);
		System.out.println("departments Added -- "  + ALdep.size());

		university univ1 = new university(9000, "Ort", new address("Karmiel", "maalyORT", "19274"), manager1);
		univ1.addDepartments(dep1);
		univ1.addDepartments(dep2); // ADDING THE DEPARTMENTS INTO A UNIVERSITY
		univ1.addDepartments(dep3);
		univ1.setSi(new signInfo("123456789", "9000"));
		ALuniv.add(univ1);
		System.out.println("universities Added -- "  + ALuniv.size());

		// ------------------------------------------------------------------------------------------------------------------------
		All = new Universities();
		All.addUniv(univ1);

		// --------------------------------------------------------------------------------------------
		// All.insertIntoDB();
		// l1.insertIntoDB();
		// l2.insertIntoDB();
		// l3.insertIntoDB();
		// l4.insertIntoDB();
		// l5.insertIntoDB();
		// l6.insertIntoDB();
		// l7.insertIntoDB();
		// manager1.insertIntoDB();
		// univ1.insertIntoDB();
		// dep1.insertIntoDB();
		// dep2.insertIntoDB();
		// dep3.insertIntoDB();
		// for (int i = 0; i < ALcrs.size(); i++) {
		// ALcrs.get(i).insertStudentsDB();
		// ALcrs.get(i).insertIntoDB();
		// }

		// for(int i=0;i<ALcrs.size();i++)
		// {
		// for(int j=0;j<ALcrs.get(i).getStudent().size();j++)
		// {
		// ALcrs.get(i).insertIntoSTDCRS(ALcrs.get(i).getStudent().get(j));
		// }
		// }

		// for(int i=0;i<ALuniv.size();i++) {
		// for(int j=0;j<ALuniv.get(i).getDepartments().size();j++) {
		// String sql = "insert into depinuniv values("+ALuniv.get(i).getId()
		// +","+ALuniv.get(i).getDepartments().get(j).getId()+")";
		// ALuniv.get(i).insertDepinuniv(sql);
		// }
		// }
	}

	private void pSRCHinit() {
		if (flag5 == 0) {
			LsrchId = new JLabel("ID");
			TFsrchId = new JTextField(15);
			RBstd = new JRadioButton("Student");
			RBlec = new JRadioButton("Lecturer");
			RBdep = new JRadioButton("Department");
			RBuniv = new JRadioButton("University");
			RBemp = new JRadioButton("Employee");
			ButtonGroup BG = new ButtonGroup();
			BG.add(RBstd);
			BG.add(RBemp);
			BG.add(RBlec);
			BG.add(RBuniv);
			BG.add(RBdep);
			Bfind = new JButton("Find");

			pSRCH.add(LsrchId);
			pSRCH.add(TFsrchId);
			pSRCH.add(RBstd);
			pSRCH.add(RBemp);
			pSRCH.add(RBlec);
			pSRCH.add(RBuniv);
			pSRCH.add(RBdep);
			pSRCH.add(Bfind);
			// pSRCH.add(TAsrchRes);

			RBdep.addActionListener(this);
			RBuniv.addActionListener(this);
			RBlec.addActionListener(this);
			RBemp.addActionListener(this);
			RBstd.addActionListener(this);
			Bfind.addActionListener(this);
			pSRCH.setVisible(false);
			flag5 = 1;
		} else
			pSRCH.setVisible(true);
	}

	private void pManagerAdder() {
		LmanagerId = new JLabel("Manager ID :");
		TFmanagerId = new JTextField(10);
		LmanagerFirst = new JLabel("FirstName:");
		TFmanagerFirst = new JTextField(10);
		LmanagerLast = new JLabel("LastName :");
		TFmanagerLast = new JTextField(10);
		LmanagerBD = new JLabel("BirthDate :");
		TFmanagerBD = new JTextField(10);
		LmanagerSex = new JLabel("Gender :");
		CHsex = new Choice();
		CHsex.add("Male");
		CHsex.add("Female");
		Lsalary = new JLabel("Salary :");
		spinner2 = new JSpinner(SMmanagerSal);

		LmanagerAdd = new JLabel("Address");
		TFmanagerCity = new JTextField(10);
		TFmanagerStreet = new JTextField(10);
		TFmanagerZip = new JTextField(10);

		LcontactNo = new JLabel("Contact Num :");
		TFmanagerContact = new JTextField(10);

		BmanagerAdder = new JButton("Add");
		BmanagerClear = new JButton("Clear");
		BmanagerClose = new JButton("Close");
		ManagerAdder.add(LmanagerId);
		ManagerAdder.add(TFmanagerId);
		ManagerAdder.add(LmanagerFirst);

		ManagerAdder.add(TFmanagerFirst);
		ManagerAdder.add(LmanagerLast);
		ManagerAdder.add(TFmanagerLast);

		ManagerAdder.add(LmanagerBD);
		ManagerAdder.add(TFmanagerBD);
		ManagerAdder.add(LmanagerSex);

		ManagerAdder.add(CHsex);
		ManagerAdder.add(Lsalary);
		ManagerAdder.add(spinner2);

		ManagerAdder.add(LmanagerAdd);
		ManagerAdder.add(TFmanagerCity);
		ManagerAdder.add(TFmanagerStreet);
		ManagerAdder.add(TFmanagerZip);
		ManagerAdder.add(LcontactNo);
		ManagerAdder.add(TFmanagerContact);
		ManagerAdder.add(BmanagerAdder);
		ManagerAdder.add(BmanagerClear);
		ManagerAdder.add(BmanagerClose);
		BmanagerAdder.addActionListener(this);
		BmanagerClear.addActionListener(this);
		BmanagerClose.addActionListener(this);
		ManagerAdder.setVisible(false);
	}

	private void plecturerAdder() {
		LlecturerID = new JLabel("Lecturer ID :");
		TFlecturerID = new JTextField(10);
		LlecturerFirst = new JLabel("FirstName:");
		TFlecturerFirst = new JTextField(10);
		LlecturerLast = new JLabel("LastName :");
		TFlecturerLast = new JTextField(10);
		LlecturerBD = new JLabel("BirthDate :");
		TFlecturerBD = new JTextField(10);
		LlecturerSex = new JLabel("Gender :");
		CHlecsex = new Choice();
		CHlecsex.add("Male");
		CHlecsex.add("Female");
		Llecsalary = new JLabel("Salary :");
		spinner3 = new JSpinner(SMmanagerSal);

		LlecturerAdd = new JLabel("Address");
		TFlecturerCity = new JTextField(10);
		TFlecturerStreet = new JTextField(10);
		TFlecturerZip = new JTextField(10);

		LleccontactNo = new JLabel("Contact Num :");
		TFlecContact = new JTextField(10);
		BlecturerAdder = new JButton("Add");
		BLecturerClear = new JButton("Clear");
		BlecturerClose = new JButton("Close");
		LecturerAdder.add(LlecturerID);
		LecturerAdder.add(TFlecturerID);
		LecturerAdder.add(LlecturerFirst);

		LecturerAdder.add(TFlecturerFirst);
		LecturerAdder.add(LlecturerLast);
		LecturerAdder.add(TFlecturerLast);

		LecturerAdder.add(LlecturerBD);
		LecturerAdder.add(TFlecturerBD);
		LecturerAdder.add(LlecturerSex);

		LecturerAdder.add(CHlecsex);
		LecturerAdder.add(Llecsalary);
		LecturerAdder.add(spinner3);

		LecturerAdder.add(LlecturerAdd);
		LecturerAdder.add(TFlecturerCity);
		LecturerAdder.add(TFlecturerStreet);
		LecturerAdder.add(TFlecturerZip);
		LecturerAdder.add(LleccontactNo);
		LecturerAdder.add(TFlecContact);
		LecturerAdder.add(BlecturerAdder);
		LecturerAdder.add(BLecturerClear);
		LecturerAdder.add(BlecturerClose);
		BlecturerAdder.addActionListener(this);
		BLecturerClear.addActionListener(this);
		BlecturerClose.addActionListener(this);
		LecturerAdder.setVisible(false);
	}

	private void pNavBarInit() {

		Bstudents = new JButton("Students");

		Buniversities = new JButton("Universities");

		Bdepartments = new JButton("Departments");
		// BstaffSignUP = new JButton("Staff SignUp");
		Bcourses = new JButton("Courses");
		
		
		pNav.add(Buniversities);
		Buniversities.addActionListener(this);
		Buniversities.hide();
		pNav.add(Bdepartments);
		Bdepartments.addActionListener(this);
		pNav.add(Bcourses);
		Bcourses.addActionListener(this);
		// pNav.add(BstaffSignUP);
		pNav.add(Bstudents);
		Bstudents.addActionListener(this);
		
		// setLayout(new BorderLayout());
		add(pNav, BorderLayout.LINE_START);
	}

	private void pToolBarInit() {
		LtimeMessage = new JLabel("Hi There!");
		LdateInfo = new JLabel();

		Date date = new Date();
		if (date.getHours() < 12)
			LtimeMessage.setText("Good Morning");
		else if (date.getHours() > 12 && date.getHours() < 18)
			LtimeMessage.setText("Good Afternoon");
		else if (date.getHours() > 18 && date.getHours() < 23)
			LtimeMessage.setText("Good Evening");
		pToolBar.add(LtimeMessage);
		dateNow = date.toString();
		LdateInfo.setText(dateNow);
		pToolBar.add(LdateInfo);
		add(pToolBar, BorderLayout.PAGE_START);
	}

	private void pBottomBarInit() {
		Lxyposes = new JLabel("positions :");

		pBottomBar.add(Lxyposes);

		add(pBottomBar, BorderLayout.PAGE_END);

	}

	private void pDetailsInit() {

		pDetails.setBackground(Color.GRAY);

		LadminLogin = new JLabel("UserName :");
		LadminLogin.setForeground(Color.BLUE);
		TFadminLogin = new JTextField(5);
		LadminPassword = new JLabel("password :");
		TFadminPassword = new JPasswordField(5);
		BSubmit = new JButton("Submit");
		Register = new JButton("Register");
		Register.addActionListener(this);
		BSubmit.addActionListener(this);

		pDetails.add(LadminLogin);
		pDetails.add(TFadminLogin);
		pDetails.add(LadminPassword);
		pDetails.add(TFadminPassword);
		pDetails.add(BSubmit);
		pDetails.add(Register);
		add(pDetails, BorderLayout.LINE_END);

	}

	private void pUnivInit() {

		if (pCourses.isVisible() || pDepartments.isVisible() || pStudents.isVisible()) {
			pCourses.setVisible(false);
			pDepartments.setVisible(false);
			pStudents.setVisible(false);
		}
		if (flag3 == 0) {

			LuniversityName = new JLabel("Universirty Name : ");
			TFuniversityName = new JTextField(20);
			LuniversityId = new JLabel("University ID :");
			TFuniversityId = new JTextField(20);
			LuniversityAddress = new JLabel("University Address :");
			TFuniversityCity = new JTextField(10);
			TFuniversityStreet = new JTextField(10);
			TFuniversityZip = new JTextField(10);
			LuniversityManager = new JLabel("Choose Manager:");
			CHuniversityManager = new Choice();
			for (int i = 0; i < ALemp.size(); i++)
				if (ALemp.get(i).getPosition() == "Manager")
					CHuniversityManager.add(ALemp.get(i).getFulName());

			BunivInsert = new JButton("Insert");
			BunivInsertDB = new JButton("Insert Into DB");
			BunivExport = new JButton("Export To File");
			BunivClear = new JButton("Clear");
			BfindUniv = new JButton("Find Univ");
			BaddManager = new JButton("Add Manager");
			LsearchResuniv = new JLabel();

			puniversities.add(LuniversityName);
			puniversities.add(TFuniversityName);
			puniversities.add(LuniversityId);
			puniversities.add(TFuniversityId);
			puniversities.add(LuniversityAddress);
			puniversities.add(TFuniversityCity);
			puniversities.add(TFuniversityStreet);
			puniversities.add(TFuniversityZip);
			puniversities.add(LuniversityManager);
			puniversities.add(CHuniversityManager);
			puniversities.add(BunivInsert);
			puniversities.add(BunivInsertDB);
			puniversities.add(BunivExport);
			puniversities.add(BunivClear);
			puniversities.add(BfindUniv);
			puniversities.add(BaddManager);
			puniversities.add(LsearchResuniv);

			BunivInsert.addActionListener(this);
			BunivInsertDB.addActionListener(this);
			BunivExport.addActionListener(this);
			BunivClear.addActionListener(this);
			BfindUniv.addActionListener(this);
			BaddManager.addActionListener(this);

			flag3 = 1;
		} else {
			puniversities.setVisible(true);
		}
	}

	private void pDepInit() {

		if ((pCourses.isVisible() || puniversities.isVisible() || pStudents.isVisible())) {
			pCourses.setVisible(false);
			puniversities.setVisible(false);
			pStudents.setVisible(false);
		}

		if (flag1 == 0) {
			Ldepartmentuniv = new JLabel("Univ:");
			CHdepartmentuniv = new Choice();
			for (int i = 0; i < ALuniv.size(); i++)
				CHdepartmentuniv.add(ALuniv.get(i).getName());
			LdepartmentName = new JLabel("Department Name : ");
			TFdepartmentName = new JTextField(10);
			LdepartmentId = new JLabel("Department Id : ");
			TFdepartmentId = new JTextField(10);
			BdepInsert = new JButton("Insert");
			BdepInsertDB = new JButton("Insert Into DB");
			BdepExport = new JButton("Export");
			BdepClear = new JButton("Clear");
			BfindDep = new JButton("Find");
			LsearchResdep = new JLabel();
			pDepartments.add(Ldepartmentuniv);
			pDepartments.add(CHdepartmentuniv);
			pDepartments.add(LdepartmentId);
			pDepartments.add(TFdepartmentId);
			pDepartments.add(LdepartmentName);
			pDepartments.add(TFdepartmentName);
			pDepartments.add(BdepInsert);
			pDepartments.add(BdepInsertDB);
			pDepartments.add(BdepExport);
			pDepartments.add(BdepClear);
			pDepartments.add(BfindDep);
			pDepartments.add(LsearchResdep);
			BdepInsert.addActionListener(this);
			BdepInsertDB.addActionListener(this);
			BdepExport.addActionListener(this);
			BdepClear.addActionListener(this);
			BfindDep.addActionListener(this);
			flag1 = 1;

		}

		else {
			pDepartments.setVisible(true);
		}

	}

	private void pCourseInit() {

		if (pDepartments.isVisible() || puniversities.isVisible() || pStudents.isVisible()) {
			pDepartments.setVisible(false);
			puniversities.setVisible(false);
			pStudents.setVisible(false);
		}

		if (flag2 == 0) {
			LcourseDep = new JLabel("Department ID:");
			CHcourseDep = new Choice();
			for (int i = 0; i < ALdep.size(); i++) {
				CHcourseDep.add(ALdep.get(i).getName());
			}

			LcourseName = new JLabel("Course Name :");
			TFcourseName = new JTextField();
			LcoursePoints = new JLabel("Points :");
			spinner = new JSpinner(SMcoursePoints);
			LcourseLecturer = new JLabel("Lecturer :");
			CHcourseLecturer = new Choice();
			for (int i = 0; i < ALlec.size(); i++)
				CHcourseLecturer.add(ALlec.get(i).getFulName());

			BcourseInsert = new JButton("Insert");
			BcourseInsertDB = new JButton("Insert Into DB");
			BcourseExport = new JButton("Export");
			BcourseClear = new JButton("Clear");
			BfindCourse = new JButton("Find");
			BaddLecturer = new JButton("Add Lecturer");
			LfindCrs = new JLabel();
			pCourses.add(LcourseDep);
			pCourses.add(CHcourseDep);
			pCourses.add(LcourseName);
			pCourses.add(TFcourseName);
			pCourses.add(LcoursePoints);
			pCourses.add(spinner);
			pCourses.add(LcourseLecturer);
			pCourses.add(CHcourseLecturer);

			pCourses.add(BcourseInsert);
			pCourses.add(BcourseInsertDB);
			pCourses.add(BcourseExport);
			pCourses.add(BcourseClear);
			pCourses.add(BfindCourse);
			pCourses.add(BaddLecturer);
			pCourses.add(LfindCrs);
			BcourseInsert.addActionListener(this);
			BcourseInsertDB.addActionListener(this);
			BcourseExport.addActionListener(this);
			BcourseClear.addActionListener(this);
			BfindCourse.addActionListener(this);
			BaddLecturer.addActionListener(this);

			flag2 = 1;
		} else {

			pCourses.setVisible(true);
		}
	}

	private void pStudentsInit() {
		if (pCourses.isVisible() || pDepartments.isVisible() || puniversities.isVisible()) {
			pCourses.setVisible(false);
			pDepartments.setVisible(false);
			puniversities.setVisible(false);

		}
		if (flag4 == 0) {

			// student s= new student(id, firstName, lastName, birthDate, sex, studentNum,
			// address)

			LcourseSTD = new JLabel("Course Name :");
			ChcourseSTD = new Choice();
			for (int i = 0; i < ALcrs.size(); i++)
				ChcourseSTD.add(ALcrs.get(i).getName());
			LstudentID = new JLabel("Student ID :");
			TFStudentID = new JTextField(30);
			LstudentFirstName = new JLabel("First Name:");
			TFstudentFirstName = new JTextField(10);
			LstudentLastName = new JLabel("Last Name");
			TFstudentLastName = new JTextField(10);
			LstudentAddress = new JLabel("Address ");
			TFstudentCity = new JTextField(10);
			TFstudentStreet = new JTextField(10);
			TFstudentZIP = new JTextField(10);
			LstudentSex = new JLabel("Sex");
			CHstudentSex = new Choice();
			CHstudentSex.add("Male");
			CHstudentSex.add("Female");
			LstudentBD = new JLabel("BirthDate");
			TFstudentBD = new JTextField();
			BstudentClear = new JButton("Clear");
			BstudentExport = new JButton("Export");
			BstudentInsert = new JButton("Insert");
			BstudentInsertDB = new JButton("Insert Into DB");
			LstudentNum = new JLabel("Student Num");
			TFstudentNum = new JTextField(10);
			pStudents.add(LcourseSTD);
			pStudents.add(ChcourseSTD);
			pStudents.add(LstudentID);
			pStudents.add(TFStudentID);
			pStudents.add(LstudentFirstName);
			pStudents.add(TFstudentFirstName);
			pStudents.add(LstudentLastName);
			pStudents.add(TFstudentLastName);
			pStudents.add(LstudentNum);
			pStudents.add(TFstudentNum);
			pStudents.add(LstudentSex);
			pStudents.add(CHstudentSex);
			pStudents.add(LstudentBD);
			pStudents.add(TFstudentBD);
			pStudents.add(LstudentAddress);
			pStudents.add(TFstudentCity);
			pStudents.add(TFstudentStreet);
			pStudents.add(TFstudentZIP);
			pStudents.add(BstudentInsert);
			pStudents.add(BstudentInsertDB);
			pStudents.add(BstudentExport);
			pStudents.add(BstudentClear);

			BstudentClear.addActionListener(this);
			BstudentExport.addActionListener(this);
			BstudentInsert.addActionListener(this);
			BstudentInsertDB.addActionListener(this);

			flag4 = 1;

		} else {
			pStudents.setVisible(true);
		}
	}

	public static void main(String[] args) {

	}

	@Override

	public void mouseClicked(MouseEvent e) {

		// TODO Auto-generated method stub
		int mouseX = e.getX(); // TODO
		int mouseY = e.getY(); // TODO
		Lxyposes.setText("positions :" + mouseX + " , " + mouseY);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX(); // TODO
		int mouseY = e.getY(); // TODO
		Lxyposes.setText("positions :" + mouseX + " , " + mouseY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX(); // TODO
		int mouseY = e.getY(); // TODO
		Lxyposes.setText("positions :" + mouseX + " , " + mouseY);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX(); // TODO
		int mouseY = e.getY(); // TODO
		Lxyposes.setText("positions :" + mouseX + " , " + mouseY);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		int mouseX = e.getX(); // TODO
		int mouseY = e.getY(); // TODO
		Lxyposes.setText("positions :" + mouseX + " , " + mouseY);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();

		if (e.getSource().equals(BstudentInsertDB)) {
			for (int i = 0; i < ALstd.size(); i++) {
				if (TFStudentID.getText().equals(ALstd.get(i).getId()))
					ALstd.get(i).insertIntoDB();
			}

			for (int i = 0; i < ALcrs.size(); i++) {
				if (ChcourseSTD.getSelectedItem().equals(ALcrs.get(i).getName()))
					for (int j = 0; j < ALstd.size(); j++) {
						if (TFStudentID.getText().equals(ALstd.get(j).getId()))
							ALcrs.get(i).insertIntoSTDCRS(ALstd.get(j));
					}
			}
		}

		if (e.getSource().equals(BstudentInsert)) {
			boolean flag = false;

			for (int i = 0; i < ALstd.size(); i++) {
				if (TFStudentID.getText().equals(ALstd.get(i).getId())
						|| TFstudentNum.getText().equals(ALstd.get(i).getId()))
					flag = true;
			}

			if (flag != true) {

				String gender = CHstudentSex.getSelectedItem();
				String[] BD = TFstudentBD.getText().split("/");
				GregorianCalendar GC = new GregorianCalendar(1990, 8, 9);
				student std = new student(TFStudentID.getText(), TFstudentFirstName.getText(),
						TFstudentLastName.getText(),
						new GregorianCalendar((Integer.parseInt(BD[2])), (Integer.parseInt(BD[1])),
								(Integer.parseInt(BD[0]))),
						gender, Integer.parseInt(TFstudentNum.getText()),
						new address(TFstudentCity.getText(), TFstudentStreet.getText(), TFstudentZIP.getText()));

				ALstd.add(std);

				for (int i = 0; i < ALcrs.size(); i++) {
					if (ALcrs.get(i).getName().equals(ChcourseSTD.getSelectedItem())) {
						ALcrs.get(i).AddStudent(std);

						System.out.println(ALcrs.get(i).getStudent().size() + "  --  " + ALcrs.get(i));
						break;
					}

				}
				System.out.println(std.toString());
				System.out.println(ALstd.size());

			}
		}

		if (e.getSource().equals(BstudentExport)) {
			FileWriter f = null;
			try {
				f = new FileWriter("src/StudentsOutput.txt");

				for (int i = 0; i < ALcrs.size(); i++) {
					if (ALcrs.get(i).getName().equals(ChcourseSTD.getSelectedItem())) {

						ALcrs.get(i).ExportToFile(f);
					}

				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(BstudentClear)) {
			TFstudentBD.setText("");
			TFstudentCity.setText("");
			TFstudentFirstName.setText("");
			TFStudentID.setText("");
			TFstudentLastName.setText("");
			TFstudentNum.setText("");
			TFstudentStreet.setText("");
			TFstudentZIP.setText("");

		}

		if (e.getSource().equals(BcourseInsertDB)) {
			for (int i = 0; i < ALcrs.size(); i++) {
				if (TFcourseName.getText().toLowerCase().equals(ALcrs.get(i).getName().toLowerCase()))
					ALcrs.get(i).insertIntoDB();
			}

		}

		if (e.getSource().equals(BcourseInsert)) {
			boolean flag = false;

			for (int i = 0; i < ALcrs.size(); i++) {
				if (TFcourseName.getText().toLowerCase().equals(ALcrs.get(i).getName().toLowerCase()))
					flag = true;
			}

			if (flag != true) {
				course c = new course(TFcourseName.getText());
				c.setPoints((Integer) spinner.getValue());
				for (int i = 0; i < ALlec.size(); i++) {
					if (ALlec.get(i).getFulName().equals(CHcourseLecturer.getSelectedItem())) {
						if (ALlec.get(i) instanceof lecturer)
							c.AddLecturer((lecturer) ALlec.get(i));

					}
				}
				ALcrs.add(c);

				for (int i = 0; i < ALdep.size(); i++) {
					if (ALdep.get(i).getName().equals(CHcourseDep.getSelectedItem())) {
						ALdep.get(i).addCourse(c);
						System.out.println(ALdep.get(i).getCourses().size() + "  --  " + ALdep.get(i));

						break;
					}
				}
				ChcourseSTD.add(c.getName());
				System.out.println(ALcrs.size());

			}

		}

		if (e.getSource().equals(BcourseExport)) {
			FileWriter f = null;
			try {
				f = new FileWriter("src/coursesOutput.txt");

				for (int i = 0; i < ALdep.size(); i++) {
					if (ALdep.get(i).getName().equals(CHcourseDep.getSelectedItem())) {

						ALdep.get(i).ExportDepToFile(f);
					}

				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(BcourseClear)) {
			TFcourseName.setText("");

		}

		if (e.getSource().equals(BfindCourse)) {

			for (int i = 0; i < ALcrs.size(); i++) {
				if (ALcrs.get(i).getName().toLowerCase().equals((TFcourseName.getText().toLowerCase()))) {
					LfindCrs.setText("Found");
					break;
				} else
					LfindCrs.setText("UnFound");

			}
			System.out.println(ALcrs.size());
		}

		if (e.getSource().equals(BunivExport)) {
			FileWriter f = null;
			try {
				f = new FileWriter("src/universitiesOutput.txt");
				All.ExportToFile(f);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource().equals(BfindUniv)) {
			for (int i = 0; i < ALuniv.size(); i++) {
				if (ALuniv.get(i).getId() == (Integer.parseInt(TFuniversityId.getText()))) {
					LsearchResuniv.setText("Found");
					break;
				} else
					LsearchResuniv.setText("UnFound");

			}
			System.out.println(ALuniv.size());

		}

		if (e.getSource().equals(BunivInsertDB)) {

			for (int i = 0; i < ALuniv.size(); i++) {
				if (ALuniv.get(i).getId() == (Integer.parseInt(TFuniversityId.getText()))) {
					All.insertIntoDB(ALuniv.get(i));

					break;
				}
			}
		}

		if (e.getSource().equals(BunivInsert)) {
			boolean flag = false;
			employee emp = null;
			for (int i = 0; i < ALemp.size(); i++) {
				if (ALemp.get(i).getFulName().equals(CHuniversityManager.getSelectedItem())) {
					emp = new employee(ALemp.get(i));
				}
			}
			for (int i = 0; i < ALuniv.size(); i++) {
				if (TFuniversityId.getText().equals(Integer.toString(ALuniv.get(i).getId())))
					flag = true;
			}

			if (flag != true) {
				university u = new university(Integer.parseInt(TFuniversityId.getText()), TFuniversityName.getText(),
						new address(TFuniversityCity.getText(), TFuniversityStreet.getText(),
								TFuniversityZip.getText()));
				u.addManager(emp);
				ALuniv.add(u);
				All.addUniv(u);
				CHdepartmentuniv.add(u.getName().toString());
			}

		}

		if (e.getSource().equals(BdepInsert)) {
			boolean flag = false;

			for (int i = 0; i < ALdep.size(); i++) {
				if (TFdepartmentId.getText().equals(Integer.toString(ALdep.get(i).getId())))
					flag = true;
			}

			if (flag != true) {
				department d = new department(Integer.parseInt(TFdepartmentId.getText()), TFdepartmentName.getText());
				ALdep.add(d);

				for (int i = 0; i < ALuniv.size(); i++) {
					if (ALuniv.get(i).getName().equals(CHdepartmentuniv.getSelectedItem())) {
						ALuniv.get(i).addDepartments(d);

						System.out.println(ALuniv.get(i).getDepartments().size() + "  --  " + ALuniv.get(i));

						break;
					}
				}
				CHcourseDep.add(d.getName().toString());

				System.out.println(ALdep.size());

			}
		}

		if (e.getSource().equals(BdepInsertDB)) {

			for (int i = 0; i < ALdep.size(); i++) {
				if (ALdep.get(i).getId() == (Integer.parseInt(TFdepartmentId.getText()))) {
					ALdep.get(i).insertDepDB();
					break;
				}

			}
			for (int i = 0; i < ALuniv.size(); i++) {
				if (ALuniv.get(i).getName().equals(CHdepartmentuniv.getSelectedItem())) {
					String sql = "insert into depinuniv values(" + Integer.parseInt(TFdepartmentId.getText()) + ","
							+ ALuniv.get(i).getId() + ")";
					ALuniv.get(i).insertDepinuniv(sql);
				}

			}

		}

		if (e.getSource().equals(BdepExport)) {
			FileWriter f = null;
			try {
				f = new FileWriter("src/departmentsOutput.txt");

				for (int i = 0; i < ALuniv.size(); i++) {
					if (ALuniv.get(i).getName().equals(CHdepartmentuniv.getSelectedItem())) {

						ALuniv.get(i).ExportDepToFile(f);
					}

				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource().equals(BfindDep)) {
			for (int i = 0; i < ALdep.size(); i++) {
				if (ALdep.get(i).getId() == (Integer.parseInt(TFdepartmentId.getText()))) {
					LsearchResdep.setText("Found");
					break;
				} else
					LsearchResdep.setText("UnFound");

			}
			System.out.println(ALdep.size());

		}

		if (e.getSource().equals(BdepClear)) {
			TFdepartmentId.setText("");
			TFdepartmentName.setText("");
		}

		if (e.getSource().equals(BmanagerClear)) {
			TFmanagerContact.setText("");
			TFmanagerBD.setText("");
			TFmanagerCity.setText("");
			TFmanagerFirst.setText("");
			TFmanagerId.setText("");
			TFmanagerLast.setText("");
			TFmanagerStreet.setText("");
			TFmanagerZip.setText("");
		}

		if (e.getSource().equals(BunivClear)) {
			TFuniversityCity.setText("");
			TFuniversityId.setText("");
			TFuniversityName.setText("");
			TFuniversityStreet.setText("");
			TFuniversityZip.setText("");
		}
		if (e.getSource().equals(BlecturerClose))
			LecturerAdder.setVisible(false);

		if (e.getSource().equals(BmanagerClose))
			ManagerAdder.setVisible(false);

		if (e.getSource().equals(BmanagerAdder)) {
			String[] BD = TFmanagerBD.getText().split("/");

			String gender = CHsex.getSelectedItem();
			employee emp = new employee(TFmanagerId.getText(), TFmanagerFirst.getText(), TFmanagerLast.getText(),
					new GregorianCalendar((Integer.parseInt(BD[2])), (Integer.parseInt(BD[1])),
							(Integer.parseInt(BD[0]))),
					gender, (Integer) spinner2.getValue(),
					new address(TFmanagerCity.getText(), TFmanagerStreet.getText(), TFmanagerZip.getText()), "Manager",
					TFmanagerContact.getText());
			ALemp.add(emp);
			CHuniversityManager.add(emp.getFulName());
			emp.insertIntoDB();
			ManagerAdder.setVisible(false);
		}

		if (e.getSource().equals(BLecturerClear)) {
			TFlecContact.setText("");
			TFlecturerBD.setText("");
			TFlecturerCity.setText("");
			TFlecturerFirst.setText("");
			TFlecturerID.setText("");
			TFlecturerLast.setText("");
			TFlecturerStreet.setText("");
			TFlecturerZip.setText("");

		}

		if (e.getSource().equals(BlecturerAdder)) {

			String[] BD = TFlecturerBD.getText().split("/");
			String gender = CHlecsex.getSelectedItem();
			lecturer lec = new lecturer((Integer) spinner3.getValue(),
					new address(TFlecturerCity.getText(), TFlecturerStreet.getText(), TFlecturerZip.getText()),
					"Lecturer", "", TFlecturerID.getText(), TFlecturerFirst.getText(), TFlecturerLast.getText(),
					new GregorianCalendar((Integer.parseInt(BD[2])), (Integer.parseInt(BD[1])),
							(Integer.parseInt(BD[0]))),
					gender);
			ALlec.add(lec);
			CHcourseLecturer.add(lec.getFulName());
			lec.insertIntoDB();
			LecturerAdder.setVisible(false);
		}

		if (e.getSource().equals(BaddLecturer)) {
			LecturerAdder.setVisible(true);
		}
		if (e.getSource().equals(BaddManager)) {
			ManagerAdder.setVisible(true);
		}

		if (e.getSource().equals(BstudentClear)) {
			TFstudentBD.setText("");
			TFstudentCity.setText("");
			TFstudentFirstName.setText("");
			TFStudentID.setText("");
			TFstudentLastName.setText("");
			TFstudentNum.setText("");
			TFstudentStreet.setText("");
			TFstudentZIP.setText("");

		}

		if (e.getSource().equals(Bstudents)) {
			pStudentsInit();
			pSRCHinit();

		}

		if (e.getSource().equals(Bfind)) {
			if (RBdep.isSelected()) {
				Area tadep = new Area();

				for (int i = 0; i < ALdep.size(); i++) {
					if (ALdep.get(i).getId() == Integer.parseInt(TFsrchId.getText())) {
						try {
							tadep.ta.setText(ALdep.get(i).getName() + " " + ALdep.get(i).getId() + " "
									+ ALdep.get(i).getcoursesName());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
			}
			if (RBemp.isSelected()) {
				Area taemp = new Area();
				for (int i = 0; i < ALemp.size(); i++) {
					if (ALemp.get(i).getId().equals(TFsrchId.getText())) {
						taemp.ta.setText(ALemp.get(i).getFulName() + "  " + ALemp.get(i).getId() + "  "
								+ ALemp.get(i).getPosition() + "  " + ALemp.get(i).getSalary());
					}
				}
			}
			if (RBlec.isSelected()) {
				Area talec = new Area();
				for (int i = 0; i < ALlec.size(); i++) {
					if (ALlec.get(i).getId().equals(TFsrchId.getText())) {
						talec.ta.setText(ALlec.get(i).getFulName() + "  " + ALlec.get(i).getId() + "  "
								+ ALlec.get(i).getPosition() + "  " + ALlec.get(i).getSalary());
					}
				}
			}
			if (RBstd.isSelected()) {
				Area tastd = new Area();
				for (int i = 0; i < ALstd.size(); i++) {
					if (ALstd.get(i).getId().equals(TFsrchId.getText())) {
						tastd.ta.setText(ALstd.get(i).getFulName() + "  " + ALstd.get(i).getId() + "  "
								+ ALstd.get(i).getStudentNum() + "  " + ALstd.get(i).getAddressString());
					}
				}

			}
			if (RBuniv.isSelected()) {
				Area tauniv = new Area();
				for (int i = 0; i < ALuniv.size(); i++) {
					if (ALuniv.get(i).getId() == (Integer.parseInt(TFsrchId.getText()))) {
						tauniv.ta.setText(ALuniv.get(i).getName() + "  " + ALuniv.get(i).getId() + "  "
								+ ALuniv.get(i).getManager().getFulName() + "  "
								+ ALuniv.get(i).getAddress().getCity());
					}
				}

			}
		}

		if (e.getSource().equals(Bdepartments)) {
			pDepInit();

		}
		if (e.getSource().equals(Bcourses)) {
			pCourseInit();
			pSRCH.setVisible(false);
		}
		if (e.getSource().equals(Buniversities)) {
			pUnivInit();
			pSRCH.setVisible(false);
		}

		if (s == "Submit") {
			if (TFadminLogin.getText().equals("admin") && TFadminPassword.getText().equals("admin")) {
				pNav.setVisible(true);

				Buniversities.show();
			}

			for (int i = 0; i < ALsi.size(); i++) {
				if (ALsi.get(i).getUsername().equals(TFadminLogin.getText())
						&& ALsi.get(i).getPassword().equals(TFadminPassword.getText())) {
					pNav.setVisible(true);
				}
			}


		}
		if(e.getSource().equals(Register))
		{
			Register r = new Register();
			r.f.show();
		}

	}
}
