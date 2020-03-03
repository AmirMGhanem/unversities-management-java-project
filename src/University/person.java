package University;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

abstract class person implements IService,IdbMySQL{

	private Calendar today = new GregorianCalendar();
	
	private String id;
	private String firstName;
	private String lastName;
	private GregorianCalendar birthDate ;  //DATE
	private String sex;

	public person() {
	
	}

	public person(String id, String firstName, String lastName, GregorianCalendar birthDate, String sex) {
		setId(id);
		setBirthDate(birthDate);
		setFirstName(firstName);
		setLastName(lastName);
		setSex(sex);
	}

	public person(person p) {

		setId(p.id);
		setBirthDate(p.birthDate);
		setFirstName(p.firstName);
		setLastName(p.lastName);
		setSex(p.sex);
	}

	
	public int getAge() {
		
		int age =today.get(Calendar.YEAR);
		 
		return age-birthDate.get(Calendar.YEAR);
	}

	// abstract String getFulName();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (numValidation(id,9))
			this.id = id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {
		if (nameValidation(firstName))
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
	if(nameValidation(lastName))
		this.lastName = lastName;
	}

	public GregorianCalendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(GregorianCalendar birthDate) {
		if (birthDate.get(Calendar.YEAR) < 2004)
			this.birthDate = birthDate;
	}

	public String getSex() {
			return sex;
	}

	public void setSex(String sex) {
		if (nameValidation(sex))
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate.get(Calendar.YEAR)+"/"+birthDate.get(Calendar.MONTH)+"/"+birthDate.get(Calendar.DAY_OF_MONTH)
				+ ", sex=" + sex + "]";
	}

	

	@Override
	public void insertIntoDB() {
		String sql = "insert into person values('" +this.id +
					"','"+this.firstName +
					"','" + this.lastName +"')";
		// TODO Auto-generated method stub
		dbConnection();
		try {
			System.out.println(sql);
			myStmt.executeQuery("insert into person Values('123123123','amir','ghanem')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void dropFromDB() {
		// TODO Auto-generated method stub
		
	}



}
