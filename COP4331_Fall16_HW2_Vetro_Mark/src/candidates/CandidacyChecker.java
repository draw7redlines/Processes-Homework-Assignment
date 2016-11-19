package candidates;

import java.util.LinkedList;
import candidates.inputFileProcessing;
import candidates.generateScores;
import candidates.sanitizeAndSort;

public class CandidacyChecker {

	//Start of main
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String departmentName = args[0];
		inputFileProcessing.getCandidateInfo();
		
		LinkedList<String> candidateList = inputFileProcessing.candidateList;
		LinkedList<Integer> scoreOne = inputFileProcessing.scoreOne;
		LinkedList<Integer> scoreTwo = inputFileProcessing.scoreTwo;
		LinkedList<String> preferred = inputFileProcessing.preferred;
		LinkedList<Integer> preferenceOrder= inputFileProcessing.preferenceOrder;
		LinkedList<Double> competitiveScores= new LinkedList<Double>();
		
		for(int x=0; x<candidateList.size(); x++)
		{
			if(preferred.get(x).equals(departmentName))
			{
				double candidateCompetitiveScore = generateScores.generateScores(scoreOne.get(x), scoreTwo.get(x));
				competitiveScores.add(candidateCompetitiveScore);
			}
			else
				competitiveScores.add((double) -1);
		}
		
		sanitizeAndSort.sanitizeSort(competitiveScores, candidateList, preferenceOrder, departmentName);
		
		
	}

}
