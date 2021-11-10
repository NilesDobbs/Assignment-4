package com.assignment4;

public class OrgStudents {
	public static void main(String[] args) {
		
		// Call the ClassCOSC from the ClassCOSC to create an array/
		ClassCOSC[] CStudents = new ClassCOSC[50];
		
		/* Class Tally. Keeps track of how many students are 
		enrolled in  which specific class. */
		int COSCTally = 0;
		
		ClassAMPTH[] AStudents = new ClassAMPTH[50];
		int AMPTHTally = 0;
		
		ClassSTATS[] SStudents = new ClassSTATS[50];
		int STATTally = 0;
		
		//---------------Student set comparison--------------//
		
		int i = 0;
		Student[] completeStudentSet = UserService.StudentFileUpload("student-master-list.csv");
		
		/* This while loop will loop over every instance of a Course inside their 
		 * respective classes */
		while (i < completeStudentSet.length) {
			
			/* Our While loop needs to utilize a Regular Expression ensure
			that each set matches the correct column. */
			if (completeStudentSet[i].getCourse().matches("^COMPSCI\s[0-9]{0,3}")) {
				CStudents[COSCTally] = new ClassCOSC(completeStudentSet[i]);
				//If the String matches the array, it will add a Tally to the class.
				COSCTally++;
			} else if (completeStudentSet[i].getCourse().matches("^AMPTH\s[0-9]{0,3}")) {
				AStudents[AMPTHTally] = new ClassAMPTH(completeStudentSet[i]);
				AMPTHTally++;
			} else if (completeStudentSet[i].getCourse().matches("^STAT\s[0-9]{0,3}")) {
				SStudents[STATTally] = new ClassSTATS(completeStudentSet[i]);
				STATTally++;
			}
		}
		///--------------User Service Imports--------------//
		
		/* Call the sorted array from the UserService for each Class set and then
		call the SortFileList to write the sortedArray to each respective file*/
		UserService.sortStudentArray(CStudents);
		SortFileList.WriteToFile(CStudents, "course1.csv");
		
		UserService.sortStudentArray(AStudents);
		SortFileList.WriteToFile(AStudents, "course2.csv");
		
		UserService.sortStudentArray(SStudents);
		SortFileList.WriteToFile(SStudents, "course3.csv");	
	}
}