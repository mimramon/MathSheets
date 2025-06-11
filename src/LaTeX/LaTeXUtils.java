package LaTeX;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LaTeXUtils
{
	
	public static String getHeader(String title) 
	{
		return "\\documentclass{article}\r\n"
				+ "\\title{"+title+"}\r\n"
				+ "\\begin{document}\r\n"
				+ "\\maketitle\n";
	}
	
	public static String getFooter() 
	{
		return "\n\\end{document}";
	}
	
	public static void compilePdf(String body, String title) throws IOException,InterruptedException
	{
		File workingDir = new File("LaTeX Output");
		workingDir.mkdirs();
		File texFile = new File(workingDir + "/" + title + ".tex");
		FileWriter writer = new FileWriter(texFile);
		writer.write(getHeader(title) + body + getFooter());
		writer.close();
		ProcessBuilder builder = new ProcessBuilder("pdflatex", title + ".tex");
		builder.directory(workingDir);
		builder.redirectErrorStream(true);
		Process compile = builder.start();
		compile.waitFor();
		
	}
}
