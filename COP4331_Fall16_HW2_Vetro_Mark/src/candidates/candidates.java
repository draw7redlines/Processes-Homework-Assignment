package candidates;

import java.util.LinkedList;
import java.util.Scanner;
import candidates.inputFileProcessing;
import candidates.generateScores;
import candidates.sanitizeAndSort;

public class candidates {

	//Start of main
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String departmentName= getDepartmentName();
		System.out.print("Got the dept name as: " + departmentName + "\n");
		
		inputFileProcessing.getCandidateInfo();
		
		LinkedList<String> candidateList = inputFileProcessing.candidateList;
		LinkedList<Integer> scoreOne = inputFileProcessing.scoreOne;
		LinkedList<Integer> scoreTwo = inputFileProcessing.scoreTwo;
		LinkedList<String> preferred = inputFileProcessing.preferred;
		LinkedList<Integer> preferenceOrder= inputFileProcessing.preferenceOrder;
		LinkedList<Double> competitiveScores= new LinkedList<Double>();
		
		System.out.print("candidates who picked " + departmentName + " and their scores: \n");
		for(int x=0; x<candidateList.size(); x++)
		{
			if(preferred.get(x).equals(departmentName))
			{
				double candidateCompetitiveScore = generateScores.generateScores(scoreOne.get(x), scoreTwo.get(x));
				competitiveScores.add(candidateCompetitiveScore);
				System.out.print(candidateList.get(x) + " " + candidateCompetitiveScore + "\n");
			}
			else
				competitiveScores.add((double) -1);
		}
		
		sanitizeAndSort.sanitizeSort(competitiveScores, candidateList, preferenceOrder);
		System.out.print("made it here \n");
		
	}
	
	//Get name of the department to funnel candidate info into
	public static String getDepartmentName()
	{
		System.out.print("Enter the department name here: \n");
		try(Scanner getName= new Scanner(System.in)){
		String departmentName = getName.nextLine();
		System.out.println("Read Dept. Name as: " + departmentName + "\n");
		return departmentName;
		
		}
	}

}
