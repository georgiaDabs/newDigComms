import java.io.*;
public class Controller
{
    public static void main(String[] args){
        try{
            FileOutputStream fos = new FileOutputStream("C://Users//GIIIIIIINGEEEEEEE//Digital Communications//newDigComms//testResults//smileyFaceResults.txt");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String results="";
            for(int i=2000;i<=20000;i+=2000){
                String currentEncodeTimes="";
                String currentDecodeTimes="";
                String ratios="";
                for(int j=20;j<=200;j+=20){

                    String inFile="C://Users//GIIIIIIINGEEEEEEE//Digital Communications//newDigComms//testTexts//smileyFace.png";

                    String encodedFile="C://Users//GIIIIIIINGEEEEEEE//Digital Communications//DigComms//textFiles//encodedSample.txt";
                    String decodedFile="C://Users//GIIIIIIINGEEEEEEE//Digital Communications//DigComms//textFiles//decoded.png";
                    final long startEncode= System.currentTimeMillis();
                    InText in=new InText(inFile,i,j,encodedFile);
                    final long endEncode=System.currentTimeMillis();
                    OutText out=new OutText(encodedFile,decodedFile);
                    final long endDecode=System.currentTimeMillis();
                    final long encodeTime=endEncode-startEncode;
                    currentEncodeTimes+=(encodeTime+"  ");
                    final long decodeTime=endDecode-endEncode;
                    currentDecodeTimes+=(decodeTime+"  ");
                    long originalSize=new File(inFile).length(); 
                    long encodeSize=new File(encodedFile).length();
                    float ratio=((float)originalSize/encodeSize);
                    ratios+=(ratio+"  ");
                }
                System.out.println("Finiched sliding window:"+i);
                bw.write("Results for SlidingWindow="+i);
                bw.newLine();
                bw.write("Encode Times:"+currentEncodeTimes);
                bw.newLine();
                bw.write("Decode Time:"+currentDecodeTimes);
                bw.newLine();
                bw.write("Ratios:"+ratios+"/n");
                bw.newLine();
                bw.write("====================================================================");
                bw.newLine();
            }
            bw.close();
        }catch(FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("problem with buffered writer");
        }
    }
}
