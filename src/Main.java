import Midi.*;

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
            final int maximumNotes=1000;
            MidiOperation midiOperation=new MidiOperation(1);
            int counter=0;
            while(++counter<maximumNotes){
                int note=random.nextInt(40)+40;
                int startTick=nowTick;
                int endTick=nowTick+random.nextInt(4);
                midiOperation.addNoteToTrack(note,startTick,endTick);
                nowTick+=random.nextInt(3);

            }
            midiOperation.savedSetting();
            midiOperation.play();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
