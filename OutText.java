import java.io.*;
import java.util.ArrayList;
public class OutText
{
    public ArrayList<Byte> output;
    
    public OutText(String encodedFile, String decodedFile){
        decode(encodedFile);
        printFile(decodedFile);
    }
    public void decode(String file){
        try{
        output=new ArrayList<Byte>();
        File f=new File(file);
        BufferedReader reader=new BufferedReader(new FileReader(f));
        String currentLine;
        File byteFile=new File("C://Users//GIIIIIIINGEEEEEEE//Digital Communications//DigComms//textFiles//bytes.txt");
        FileOutputStream outStream=new FileOutputStream(byteFile);
        while((currentLine=reader.readLine())!=null){
            ArrayList<Byte> currentBytes=new ArrayList<Byte>();
            
            String[] parts=currentLine.split(",");
            outStream.write(Byte.valueOf(parts[2]));
            if(parts[0].equals("0")){
                currentBytes.add(Byte.valueOf(parts[2]));
            }else{
                int distance= Integer.parseInt(parts[0]);
                
                int length=Integer.parseInt(parts[1]);
                //System.out.println("distance"+distance+"length"+length);
                for(int j=0;j<length;j++){
                    currentBytes.add(output.get(output.size()-distance+j));
                }
                currentBytes.add(Byte.valueOf(parts[2]));
            }
            output.addAll(currentBytes);
            
        }
        outStream.flush();
        outStream.close();
    }catch(IOException e){
        System.out.println("file not found");
    }
    }
    public void printFile(String outFile){
        try{
        File file=new File(outFile);
        FileOutputStream outStream=new FileOutputStream(file);
        
        for(Byte b:output){
            //System.out.print(b.toString());
            outStream.write(b);
        }
        outStream.flush();
        outStream.close();
    }catch(IOException e){
        
    }
    }
}
