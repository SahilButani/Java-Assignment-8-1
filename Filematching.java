import java.io.*;

import java.util.Scanner;
import java.util.regex.*;

public class Filematching
{
    public static void main(String a[]) {
        File directory = new File("/home/zadmin/");
        File[] files = directory.listFiles();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
        Pattern p= Pattern.compile(sc.next());
            for (File f : files) {
                if (f.isFile()) {
                    Matcher m=p.matcher(f.getName());
                    if(m.matches()){
                        System.out.println(f.getAbsolutePath());
                    }
                }
            }

        }
    }
}
