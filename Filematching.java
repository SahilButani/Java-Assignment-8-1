import java.io.*;

import java.util.Scanner;
import java.util.regex.*;

public class FileMatch
{
  /*
   *This function takes all the files in the "/home/zadmin/" directory and matches the file
   *with the regular expression given as an input by the user. If the regex matches function
   *prints the absolute path of the file.
   */
  public static fileMatching()
  {
    File directory = new File("/home/zadmin/");
        File[] files = directory.listFiles();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
        Pattern p= Pattern.compile(sc.next());
            for (File f : files)
            {
                if (f.isFile())
                {
                    Matcher m=p.matcher(f.getName());
                    if(m.matches())
                    {
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String a[])
    {
        fileMatching();
    }
}
