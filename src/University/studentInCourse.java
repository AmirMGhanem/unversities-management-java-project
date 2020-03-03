package University;

public class studentInCourse {
	
	private student student;
	private course course;
	private int grade;
	private lecturer lecturer;
	public boolean isFailed=isFailed();
	
	
	
	public studentInCourse(student s,course c,lecturer l)
	{
		setCourse(c);
		setStudent(s);
		setLecturer(l);
		
	
	}

	public student getStudent() {
		return student;
	}

	public void setStudent(student student) {
		this.student = student;
	}

	public course getCourse() {
		return course;
	}

	public void setCourse(course course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		if(grade>=0 && grade<=100)
			this.grade = grade;
	}
		
	public boolean isFailed()
	{
		if(grade<55)
			return true;
		else 
			return false;
				
	}

	public lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
}
