package com.assignment4;

/* Each class (Courses in the master-file) needs its own class and constructor and
an extend to properties of Student() receive the get() methods */

public class ClassAMPTH extends Student {
	
		/* Have the class extend Student to inherit the properties of the 
		variables privates */
	
		ClassAMPTH(Student student) {
			this.setStudentID(student.getStudentID());
			this.setStudentName(student.getStudentName());
			this.setCourse(student.getCourse());
			this.setGrade(student.getGrade());

		}
}