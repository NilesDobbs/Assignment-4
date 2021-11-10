package com.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SortFileList {
	
	static BufferedWriter fileWrite = null;
	
	public static String[] newStudentArrayString(String fileName) {
		int i = 0;
		
		BufferedReader fileReader = null;
		String[] students = new String[101];
		
		/* We create a while loop to have each line fileName in the length read through the array */ 
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			fileReader.readLine();
			while (i < students.length) {
				students[i] = fileReader.readLine();
				System.out.println(students[i]);
				i++;		
				}
		//Catch the error if it cannot access/Read the File
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		//If it doesn't map to a predestined exception type. Should comes last.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			/* After our block runs, we want to close out the FileRead and throw an exception
			in case it tries to read again */
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
	
	public static void WriteToFile(Student[] ArrayofStudents, String fileName) {
		
		int i = 0;
		
		try {
			//Write a file at the start of the code that print's the student categories.
			fileWrite = new BufferedWriter(new FileWriter(fileName));
			fileWrite.write("Student ID, Student Name, Course, Grade \n");
			while (i < ArrayofStudents.length) {
				if (ArrayofStudents[i] != null) {
					fileWrite.write(Student.StudentInfo(ArrayofStudents[i]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* After our block runs, we want to close out the FileRead and throw an exception
			in case it tries to read again */
			try {
				fileWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Student[] StudentFileUpload(String fileName) {
		
		int i = 0;
		Student[] students = new Student[101];
		String[] studentStringArray = newStudentArrayString(fileName);
		
		while (i < studentStringArray.length) {
			//The String with areas containing empty space will add a semicolon at the region of the index
			students[i] = UserService.newStudent(studentStringArray[i].split(","));
		}
		return students;
	}
}
