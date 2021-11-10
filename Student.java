package com.assignment4;

/* A Comparable class is needed in order to compare our
csv list in numerical order */
public class Student implements Comparable<Student> {
	
	/*Create 4 private String's for the Student() Class. They will
	define the variables for the csv list, create our array, and print out 
	the properties */
	private String studentID;
	private String studentName;
	private String course;
	private String grade;
	
//-----------------------Constructor and Comparable Methods-----------------------//
	Student() {
		
	}
	
	/*Create Student() constructor using a StudentInfo as an argument.
	It defines the elements within our array, and which variables belongs to 
	which. */
	Student(String[] studentInfo) {
		this.studentID = studentInfo[0];
		this.studentName = studentInfo[1];
		this.course = studentInfo[2];
		this.grade = studentInfo[3];
	}
	
	/* this method is called within Student() to recieve the get() method for
	each variable and return a String */
	public static String StudentInfo(Student student) {
		String studentString = (student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
		+ "," + student.getGrade() + "\n");
		return studentString;
	}
	
	/*After setting our comparable in our class, create a compare method to 
	measure the weight of each grade by decreasing order*/
	public int compareTo(Student o) {
		if (o != null) {
			if (Integer.parseInt(this.getGrade()) > (Integer.parseInt(o.getGrade()))) {
				return -1;
			} else if (Integer.parseInt(this.getGrade()) == ((Integer.parseInt(o.getGrade())))) {
				return 0;
			} else {
				return 1;
			}
		} else {
			return 0;
		}
	}
	
	//Create getter and setter for the private variables
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String arrs) {
		this.studentID = arrs;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}