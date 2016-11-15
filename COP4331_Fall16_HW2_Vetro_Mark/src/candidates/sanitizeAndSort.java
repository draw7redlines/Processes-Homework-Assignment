package candidates;

import java.util.Collections;
import java.util.LinkedList;

public class sanitizeAndSort {
	
	public static void sanitizeSort(LinkedList<Double> competitiveScores, LinkedList<String> candidateList, LinkedList<Integer> preferenceOrder)
	{
		LinkedList<Double> temp = competitiveScores;
		System.out.print("The descending order of the list is... \n");
		for(int x=0; x<competitiveScores.size(); x++)
		{
			if(Collections.max(temp)!=-1)
			{
			System.out.print(Collections.max(temp) + "\n");
			System.out.print("The original index of this element is... " + temp.indexOf(Collections.max(temp)) + "\n");
			System.out.print("Therefore, this gives me:" + candidateList.get(temp.indexOf(Collections.max(temp))) + "with score of " + Collections.max(temp) + "\n");
			temp.remove(Collections.max(temp));
			}
		}
		
	}

}
