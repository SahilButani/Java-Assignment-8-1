import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Filematching
{
  static boolean matched=false;
  /*
   * This function takes file array containing all file names and a regular expression
   * function matches each regex to a file name and if it matches, it prints the
   * absolute path.
   * If the file is a Directory then it Recursively calls the method again.
   */
  public static void findMatchingFiles(File[] files,String regex)
  {
    Pattern p= Pattern.compile(regex);
        for (File f : files) {
            if (f.isFile()) {
                Matcher m=p.matcher(f.getName());
                if(m.find()==true){
                  matched=true;
                    System.out.println(f.getAbsolutePath());
                }
            }
            else if(f.isDirectory())
            {
              findMatchingFiles(f.listFiles(),regex);
            }
  }
}
/*
 * Main method takes home directory and retrieves all files and passes the file
 * array to findMatchingFiles function.
 */
    public static void main(String a[]) throws InputMismatchException
     {
        File directory = new File("/home/zadmin/");
        File[] files = directory.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a regular expression or press ctrl+c to exit");
        while (sc.hasNext())
        {
          try
          {
            matched=false;
            String regex=sc.nextLine();
            findMatchingFiles(files,regex);
            if(matched==false)
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
   .txt
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
    .java
    No files matched.
    ctrl+c
*/
