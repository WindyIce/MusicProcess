package Midi;

import java.io.*;

public class MidiReader {
    private File midiFile;
    private byte buffer[];

    public MidiReader(String src)throws FileNotFoundException{
        midiFile=new File(src);
        if(!midiFile.exists()){
            throw new FileNotFoundException(src);
        }
    }

    public MidiReader(String src,String out)throws IOException ,IOException{
        midiFile=new File(src);
        FileInputStream fileInputStream=new FileInputStream(midiFile);
        FileOutputStream fileOutputStream=new FileOutputStream(out);
        buffer=new byte[new Long(midiFile.length()).intValue()*2];

        int count,i;

        while((count=fileInputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,count);
        }

        fileInputStream.close();
        fileOutputStream.close();

        System.out.println("success");
    }

    public byte[] toByteArray()throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(new Long(midiFile.length()).intValue());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(midiFile));
        int bufSize = 1024;
        byte[] buffer = new byte[bufSize];
        int length = 0;
        while (-1 != (length = bufferedInputStream.read(buffer, 0, bufSize))) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        bufferedInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public void sequenceAnalysis(){
        //buffer=toByteArray();

    }

}
