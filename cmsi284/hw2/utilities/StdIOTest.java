import java.io.*;
import java.text.*;

public class StdIOTest {
         static InputStreamReader converter = new InputStreamReader (System.in);
         static BufferedReader in = new BufferedReader(converter);
     public static void main(String[] args){
     try{
         System.out.println(in.readLine());
     }
     catch( Exception e){
         System.out.println("Balls!");
     }
     }
}
