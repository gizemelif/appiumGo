package Views;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Reports {
        public static void report(String status, String page, String messsage){
            String foo = status+" - "+page+" - "+messsage;
            System.out.println(foo);

            String str = foo;

            try{
                File file = new File("C:\\Users\\geatalay\\Desktop\\appiumTestGo\\report2.txt");

                FileWriter writer = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(writer);
                bw.append(str);
                bw.newLine();
                bw.close();

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

}

