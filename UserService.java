package com.assignment4;

import java.util.Arrays;
import java.util.Comparator;

public class UserService {
	public static Student newStudent(String[] arr) {
		
		//Call and import a new variable upon the Student Class 
		Student student = new Student();
		
		//Set the student to be positioned within our array.
		student.setStudentID(arr[0]);
		student.setStudentName(arr[1]);
		student.setCourse(arr[2]);
		student.setGrade(arr[3]);
		return student;
	}	
	
	public static Student[] StudentFileUpload(String fileName) {
		return SortFileList.StudentFileUpload(fileName);
	}
	
	//Create this class to order our objects in the Student array
	public static void sortStudentArray(Student[] arr) {
			Arrays.sort(arr, new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					if (o1 == null && o2 == null) {
						return 0;
					}
					if (o1 == null) {
						return 1;
					}
					if (o2 == null) {
						return -1;
					}
					return o1.compareTo(o2);
				}
			});
		}
}
