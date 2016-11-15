package candidates;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class inputFileProcessing {
	
	//Took advantage of Java's built in linked list structure and just made one for each attribute
	//This is messy, I know, but it was easier than building a list with nodes, and saved me time that I'm always
	//Short on. It works though!!!
	public static void getCandidateInfo()
	{
		FileInputStream input = null;
		FileOutputStream output = null;
		
		LinkedList<String> candidateList = new LinkedList<String>();
		
		LinkedList<Integer> scoreOne = new LinkedList<Integer>();

		LinkedList<Integer> scoreTwo = new LinkedList<Integer>();
		
		LinkedList<String> preferred = new LinkedList<String>();
		
		LinkedList<Integer> preferenceOrder= new LinkedList<Integer>();
		
		
		try{
			input = new FileInputStream("candidates.txt");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner lineScan = new Scanner(input).useDelimiter(";");
		
		int ticker=1;
		
		while(lineScan.hasNext())
		{
			String lineIn = lineScan.next();
			
			if(lineIn=="\\n"){
				lineScan.nextLine();
				//lineIn=lineScan.next();
			}
			
			else if(ticker==1)
			{
				candidateList.add(lineIn);	
				ticker++;
				System.out.print(lineIn);
			}
			else if(ticker==2)
			{
				int temp= Integer.parseInt(lineIn);
				scoreOne.add(temp);
				temp=0;
				ticker++;
				System.out.print(lineIn);
			}
			else if(ticker==3)
			{
				int temp= Integer.parseInt(lineIn);
				scoreTwo.add(temp);
				temp=0;
				ticker++;
				System.out.print(lineIn);
			}
			else if(ticker==4)
			{
				preferred.add(lineIn);
				ticker++;
				System.out.print(lineIn);
				
			}
			else if(ticker==5)
			{
				int temp = Integer.parseInt(lineIn);
				preferenceOrder.add(temp);
				temp=0;
				ticker=1;
				System.out.print(lineIn);
				System.out.print("got here\n");
			}
			else{
				System.out.print("Something broke, shouldn't have been able to get here lol \n");
			}
				
		}
		
		
		
		
		//This method will work by printing via indexes, assuming that everything in the input got tokenized correctly
		System.out.print("\n Let's see if we can keep all of this straight... The output is: \n");
		
		for(int flag = 0; flag<4; flag++)
		{
			System.out.print(candidateList.get(flag) + " " + scoreOne.get(flag) + " " + scoreTwo.get(flag) + " "  + preferred.get(flag) + " " + preferenceOrder.get(flag)+ " ");
			
		}
		
	}

}
