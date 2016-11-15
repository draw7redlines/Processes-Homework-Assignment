package candidates;

import java.util.Scanner;
import candidates.inputFileProcessing;

public class candidates {

	//Start of main
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String departmentName= getDepartmentName();
		System.out.print("Got the dept name as: " + departmentName + "\n");
		
		inputFileProcessing process = new inputFileProcessing();
		process.getCandidateInfo();

	}
	
	//Get name of the department to funnel candidate info into
	public static String getDepartmentName()
	{
		System.out.print("Enter the department name here: \n");
		Scanner getName= new Scanner(System.in);
		String departmentName = getName.nextLine();
		System.out.println("Read Dept. Name as: " + departmentName + "\n");
		return departmentName;
		
		
	}

}
