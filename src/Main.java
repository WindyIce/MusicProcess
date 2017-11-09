import Midi.*;
import Player.BasicPlayer;
import TypeOperation.FromByte;
import TypeOperation.ToByte;
import TypeOperation.Visuallize;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Random;

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

            //MidiReaderSample.MidiToText("ResFile/Unravel.mid","OutFile/out2.txt");
            //BasicPlayer player=new BasicPlayer("ResFile/Unravel.mid");
            //player.play();
            //MidiModifierSample.cityInTheSky();
        try {
            Random random=new Random();
            int nowTick=1;
            while(true){
                int note=random.nextInt(127);
                double sleepTick=random.nextDouble()*3+1;
                MidiOperation.playGlobal(note,random.nextInt(3)+1);
                Thread.sleep((long)((int)60*sleepTick));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
