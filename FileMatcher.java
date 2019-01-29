import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;
import java.util.regex.PatternSyntaxException;



public class FileMatcher
{
	static boolean isMatched=false;

  /*
	 * Main method takes home directory and retrieves all files and ask user for a regular expression.
	 * Then it calls findMatchingFiles function to find files which match the regex.
	 */
  public static void main(String a[]) throws InputMismatchException
	{
		File directory = new File("/home/zadmin/");
		File[] files = directory.listFiles();
		System.out.println("Enter a regular expression or press ctrl+c to exit");
		findMatchingFiles();
	}
  
  
	/*
	 * This function takes file array containing all file names and a regular expression
	 * function matches each regex to a file name and if it matches, it prints the
	 * absolute path.
	 * If the file is a Directory then it Recursively calls the method again.
	 */
	private static void printFiles(File[] files,String regex)
	{

		Pattern p= Pattern.compile(regex);
		for (File f : files) {
			if (f.isFile()) {
				Matcher m=p.matcher(f.getName());
				if(m.find()==true){
					isMatched=true;
					System.out.println(f.getAbsolutePath());
				}
			}
			else if(f.isDirectory())
			{
				printFiles(f.listFiles(),regex);
			}
		}

	}
	
  /*
	 * This function takes regular expression input from user and calls printFiles function which will print
	 * files whose names matched with the regex.
	 */
	private static void findMatchingFiles()
	{
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			try
			{

				String regex=sc.nextLine();

				printFiles(files,regex);

				if(isMatched==false)
					System.out.println("No files matched");
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid input");
			}

		}
	}
	
	
}




/*
Test Case
1)
   Enter a regular expression or press ctrl+c to exit
   input-> .txt
   output->
   /home/zadmin/.eclipse/org.eclipse.oomph.setup.installer/installRoot.txt
   /home/zadmin/.eclipse/org.eclipse.oomph.jreinfo/infos.txt
   /home/zadmin/.IdeaIC2018.3/config/disabled_plugins.txt
   /home/zadmin/.IdeaIC2018.3/system/compile-server/demoproject_482198fc/targets/java-production/demoProject_6de0fb6/kotlin/has-k
   otlin-marker.txt
   /home/zadmin/.IdeaIC2018.3/system/compile-server/demoproject_482198fc/targets/java-test/demoProject_6de0fb6/kotlin/has-kotlin-
   marker.txt
   /home/zadmin/.IdeaIC2018.3/system/compile-server/java-general_634d17cc/targets/java-production/Java-General_cd0403d/kotlin/has
   -kotlin-marker.txt
   /home/zadmin/.IdeaIC2018.3/system/compile-server/demo_3451b689/targets/java-production/demo_2efde3/kotlin/has-kotlin-marker.tx
   t
   /home/zadmin/.IdeaIC2018.3/system/compile-server/demo_3451b689/targets/java-test/demo_2efde3/kotlin/has-kotlin-marker.txt
   /home/zadmin/.IdeaIC2018.3/system/compile-server/dateandtime_459f1373/targets/java-production/DateandTime_1406d5b6/format-vers
   ion.txt
 .......................................(and many more files....)

  2)
   input-> .java
   output-> No files matched.
           ctrl+c

  3)
  input-> .
  output->
  /home/zadmin/.bash_logout
  /home/zadmin/.wget-hsts
  /home/zadmin/.sql

 4)
 input->.l
 output->
 /home/zadmin/.bash_logout
/home/zadmin/.sql
/home/zadmin/zadmin.iml
/home/zadmin/intellij-idea.desktop

 5)
 input->""
 output->
 no files matched.
*/
