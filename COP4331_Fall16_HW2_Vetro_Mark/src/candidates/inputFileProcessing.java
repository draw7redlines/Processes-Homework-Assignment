package candidates;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class inputFileProcessing {
	
	
	static LinkedList<String> candidateList = new LinkedList<String>();
	
	static LinkedList<Integer> scoreOne = new LinkedList<Integer>();

	static LinkedList<Integer> scoreTwo = new LinkedList<Integer>();
	
	static LinkedList<String> preferred = new LinkedList<String>();
	
	static LinkedList<Integer> preferenceOrder= new LinkedList<Integer>();
	
	//Took advantage of Java's built in linked list structure and just made one for each attribute
	//This is messy, I know, but it was easier than building a list with nodes, and saved me time that I'm always
	//Short on. It works though!!!
	public static void getCandidateInfo()
	{
		FileInputStream input = null;
		
		
		
		try{
			input = new FileInputStream("candidates.txt");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner lineScan = new Scanner(input).useDelimiter(";|\\n");
		
		int ticker=1;
		
		while(lineScan.hasNextLine())
		{
			String lineIn = lineScan.next();
			
			if(ticker==5)
			{
				String tempString= lineIn.trim();
				lineIn= tempString;
				int temp = Integer.parseInt(lineIn);
				preferenceOrder.add(temp);
				temp=0;
				ticker=1;
			}
			
			else if(ticker==1)
			{
				candidateList.add(lineIn);	
				ticker++;
			}
			else if(ticker==2)
			{
				int temp= Integer.parseInt(lineIn);
				scoreOne.add(temp);
				temp=0;
				ticker++;
			}
			
			else if(ticker==3)
			{
				int temp= Integer.parseInt(lineIn);
				scoreTwo.add(temp);
				temp=0;
				ticker++;
			}
			
			else if(ticker==4)
			{
				preferred.add(lineIn);
				ticker++;
				
			}
			
			else{
				System.out.print("A hold got ripped in the fabric of time, you shouldn't have been able to get here ghostrider \n");
			}
				
		}
		
	}

}
