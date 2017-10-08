import Midi.MidiOperation;
import Midi.MidiReader;
import TypeOperation.FromByte;
import TypeOperation.ToByte;
import TypeOperation.Visuallize;

import java.io.FileOutputStream;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args){
        /*try {
            MidiOperation midiOperation = new MidiOperation(1);
            midiOperation.addNoteToTrack(50,1,3);
            midiOperation.addNoteToTrack(52,3,5);
            midiOperation.addNoteToTrack(53,5,11);
            midiOperation.addNoteToTrack(52,11,13);
            midiOperation.addNoteToTrack(53,13,17);
            midiOperation.addNoteToTrack(57,17,21);
            midiOperation.addNoteToTrack(52,21,33);
            midiOperation.savedSetting();
            midiOperation.play();
        }
        catch (Exception e){
            e.printStackTrace();
        }*/

        try{
            MidiReader midiReader=new MidiReader("ResFile/Unravel.mid");
            byte[] b=midiReader.toByteArray();
            String out= FromByte.toHexArray(b);
            FileWriter fileWriter=new FileWriter("OutFile/out.txt");
            fileWriter.write(out);
            byte[] testBytes= ToByte.hexToBytes(out);
            String out1=FromByte.toHexArray(testBytes);
            out1= Visuallize.formatHexString(out1);
            FileWriter fileWriter1=new FileWriter("OutFile/out2.txt");
            fileWriter1.write(out1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
