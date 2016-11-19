package candidates;

public class generateScores {

	
	public static double generateScores(int writeExam, int programExam)
	{
		double candidateScore = (.4*writeExam)+(.6*programExam);
		
		return candidateScore;
	}
	
	
}
