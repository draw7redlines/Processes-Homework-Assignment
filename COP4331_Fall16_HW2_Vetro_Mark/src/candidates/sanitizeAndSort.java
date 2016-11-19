package candidates;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import candidates.output;

public class sanitizeAndSort {
	
	public static void sanitizeSort(LinkedList<Double> competitiveScores, LinkedList<String> candidateList, LinkedList<Integer> preferenceOrder, String departmentName)
	{
		LinkedList<Integer> temp3 = preferenceOrder;
		LinkedList<String> temp2 = candidateList;
		LinkedList<Double> temp = competitiveScores;
		int flag=temp.size();
		double scoreArr[] = new double[temp.size()];
		String nameArr[] = new String[temp.size()];
		int prefArr[] = new int[temp.size()];
		for(int x=0; x<flag; x++)
		{
			if(Collections.max(temp)!=-1)
			{
			scoreArr[x]= Collections.max(temp);
			nameArr[x]= temp2.get(temp.indexOf(Collections.max(temp)));
			prefArr[x]= temp3.get(temp.indexOf(Collections.max(temp)));
			temp3.remove(temp.indexOf(Collections.max(temp)));
			temp2.remove(temp.indexOf(Collections.max(temp)));
			temp.remove(Collections.max(temp));
			}
		}
		
		
		for(int x=0; x<prefArr.length-1; x++)
		{
			if((scoreArr[x]-scoreArr[x+1])<=1)
			{
				if(prefArr[x]>prefArr[x+1])
			{
				String tempString= nameArr[x];
				Double tempScore = scoreArr[x];
				int tempPref = prefArr[x];
				
				nameArr[x]= nameArr[x+1];
				nameArr[x+1] = tempString;
				
				scoreArr[x] = scoreArr[x+1];
				scoreArr[x+1] = tempScore;
				
				prefArr[x] = prefArr[x+1];
				prefArr[x+1] = tempPref;
			}
			}
			
		}
		
		try {
			output.writeToOutput(nameArr, departmentName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
