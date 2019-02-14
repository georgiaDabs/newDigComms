import java.util.Scanner;
import java.io.*;
public class Check
{
    public static void main(String[] args){
        try{File file=new File("C://Users//GIIIIIIINGEEEEEEE//Digital Communications//DigComms//textFiles//encodedSample.txt");
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String currentLine;
            Scanner sc;
            while((currentLine=reader.readLine())!=null){
                String[] parts=currentLine.split(",");
                System.out.print(parts[0]+","+parts[1]+","+Byte.valueOf(parts[2]));
                System.out.println("");
            }
        }catch(IOException e){}
    }
}
