package candidates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class output {
	
	
	public static void writeToOutput(String[] nameArr, String departmentName) throws FileNotFoundException
	{
		String redundantFileName = departmentName + ".txt";		
		File outputFile = new File(redundantFileName);
		
		try {
			outputFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter output = new PrintWriter(outputFile);
		
		
		System.out.print("\n This is what the output file will look like: \n");
		
		int godOfDestructionBeerus = 0;
		while(godOfDestructionBeerus <4 && nameArr[godOfDestructionBeerus]!=null)
		{
			System.out.print(nameArr[godOfDestructionBeerus] + "\n");
			output.println(nameArr[godOfDestructionBeerus] + "\n");
			godOfDestructionBeerus++;
		}
		
		output.close();
		
	}

}
