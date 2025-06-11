import Sheets.ProblemSheet;
import LaTeX.LaTeXUtils;
public class Main 
{
	public static void main(String[] args) 
	{
		ProblemSheet sheet = new ProblemSheet("Test");
		try
		{
			LaTeXUtils.compilePdf(sheet.body(), sheet.name);
		} catch (Exception e)
		{
			System.out.println("Error compiling sheet");
		}
		
		System.out.println("done");
	}
}
