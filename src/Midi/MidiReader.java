package Midi;

import TypeOperation.FromByte;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.*;
import java.util.ArrayList;

public class MidiReader {
    private File midiFile;
    private byte buffer[];

    //Kinds of perporties
    private boolean isSynMultiTrack;
    private short numOfTracks;     //Global track already included
    private short ticksOfQuarter;
    private ArrayList<Track>tracks=new ArrayList<>();

    public MidiReader(String src)throws IOException{
        midiFile=new File(src);
        if(!midiFile.exists()){
            throw new FileNotFoundException(src);
        }
        buffer=toByteArray();
    }

    public MidiReader(String src,String out)throws IOException{
        midiFile=new File(src);
        FileInputStream fileInputStream=new FileInputStream(midiFile);
        FileOutputStream fileOutputStream=new FileOutputStream(out);
        buffer=new byte[new Long(midiFile.length()).intValue()*2];

        int count;

        while((count=fileInputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,count);
        }

        fileInputStream.close();
        fileOutputStream.close();

        System.out.println("success");
    }

    private byte[] toByteArray()throws IOException{
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

    public byte[] getBuffer() {
        return buffer;
    }

    public Sequence analyse() throws MidiFileReadingException,
            InvalidMidiDataException{
        long bufferSize=buffer.length;
        if(!(buffer[0]==0x4d&&buffer[1]==0x54&&buffer[2]==0x68&&buffer[3]==0x64))
            throw new MidiFileReadingException("Invalid File Header");
        if(!(buffer[4]==0x00&&buffer[5]==0x00&&buffer[6]==0x00&&buffer[7]==0x06))
            throw new MidiFileReadingException("Invalid File Header Length");
        isSynMultiTrack=(buffer[8]==0x00&&buffer[9]==0x01);
        if(!isSynMultiTrack)
            throw new MidiFileReadingException("Invalid File Header");
        numOfTracks= FromByte.getShort(buffer[10],buffer[11]);
        ticksOfQuarter=FromByte.getShort(buffer[12],buffer[13]);
        int p=14; //Tracks Analyser start pointer
        if(buffer[p]==0x4d&&buffer[++p]==0x54&&buffer[++p]==0x72&&buffer[++p]==0x6b){
            int ticks=0;
            int turns=0;
            ArrayList<Byte>eachData=new ArrayList<>();
            while(buffer[++p]>=128){
                eachData.add((byte)(buffer[p]-128));
                ++turns;
            }
            eachData.add((byte)(buffer[p]-128));
            for(int i=0;i<=turns;++i){
                ticks+=Math.pow(128,i)*eachData.get(eachData.size()-i-1);
            }
            byte event=buffer[++p];
            switch (event){
                case (byte)0xff:

            }
        }
        else throw new MidiFileReadingException("Unseen global track");

        return new Sequence(Sequence.PPQ,4);
    }
}

class MidiFileReadingException extends Exception{
    public MidiFileReadingException(String message){
        super(message);
    }
}