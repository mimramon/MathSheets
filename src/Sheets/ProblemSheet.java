package Sheets;

public class ProblemSheet
{
	Problem problems[];
	public String name;
	
	public ProblemSheet(String name)
	{
		this.name = name;
		problems = new Problem[2];
		problems[0] = new TestProblem();
		problems[1] = new TestProblem();
	}
	
	public String body()
	{
		String body = "";
		for(int i = 0; i < problems.length-1; i++)
		{
			body = body + problems[i].question();
		}
		body = body + "\n\\newpage\n";
		for(int i = 0; i < problems.length-1; i++)
		{
			body = body + problems[i].solution();
		}
		return body;
	}
}

