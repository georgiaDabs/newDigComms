import java.io.*;

import java.nio.file.Files;
public class InText
{
    public String output;
    public InText(String filename, int swSize, int bSize,String outFile){
        long startTime=0;
        long endTime=0;

        try{
            File f=new File(filename);
            byte[] byteArray=Files.readAllBytes(f.toPath());
            encode(byteArray,swSize, bSize);
            printOutput(outFile);
        }catch(IOException e){

        }

    }

    public void encode(byte[] bArray,int swSize,int bSize){
        int current=0;
        output="";
        while(current<bArray.length){

            int greatestL=0;
            int greatestD=0;
            for(int d=1;d<swSize;d++){
                boolean match=true;
                int l=0;
                while((match)&&((current-d)>=0)&&((current+l)<bArray.length)&&(l<d)){
                    if(l<bSize){
                        if(bArray[current-d+l]==bArray[current+l]){
                            //System.out.println("success at d="+d);
                            l++;
                        }else{
                            match=false;
                        }
                    }else{
                        match=false;
                    }
                }
                if(l>greatestL){
                    //if(d>1024 && l<4){}else{
                    if(d>1000 && l<3){}else{
                        if(d>100 && l<2){}else{
                        greatestL=l;
                        greatestD=d;
                    }
                    //}
                    
                }
                    //System.out.println("top l at "+current+" gives D="+greatestD+" L="+greatestL);
                }
            }
            if((current+greatestL)>=bArray.length){
                output+=(""+greatestD+","+greatestL+",32");
            }else{
                if(greatestD!=0){
                    try{
                        //System.out.println("greatestD is"+greatestD+"greatestL"+greatestL);
                        output+=(""+greatestD+","+greatestL+","+(byte)bArray[current+greatestL]+"\n");
                        //System.out.println(","+(byte)bArray[current+greatestL]+"\n");
                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("GreatestD:"+greatestD);
                        System.out.println("GreatestL:"+greatestL);
                        System.out.println("Current:"+current);
                        System.out.println("ArraySize:"+bArray.length);
                        System.out.println("Current+greatestL:"+(current+greatestL));
                    }
                }else{
                    //System.out.print(bArray[current+greatestL]+"\n");
                    //System.out.println(","+(byte)bArray[current]+"\n");

                    output+=(greatestD+","+greatestL+","+(byte)bArray[current]+"\n");
                }}

            current+=greatestL+1;
        }
    }

    public void printOutput(String outFile){
        try{
            PrintWriter out=new PrintWriter(outFile);
            out.print(output);
            out.close();
        }catch(IOException e){
            System.out.println("file not found");
        }
    }
}
