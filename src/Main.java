import Midi.*;

        import java.util.Random;

public class Main {
    private static int nearestNote(int note,String tone){
        int size=note/12;
        int offset=note%12;
        int toneOffset=MidiProcessInput.getOffset(tone);
        int firstNote=toneOffset+12;
        if(offset==firstNote||offset==firstNote+2||offset==firstNote+4||offset==firstNote+5||
                offset==firstNote+7||offset==firstNote+9||offset==firstNote+11||offset==firstNote+12){
            return note;
        }
        else{
            if(new Random().nextBoolean()){
                return note+1;
            }
            else return note-1;
        }
    }

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
            int firstTone=MidiProcessInput.getOffset("D");
            final int[] cnNote={0,2,4,7,9};
            while(++counter<maximumNotes){
                int note=random.nextInt(50)+40;
                int startTick=nowTick;
                int endTick=nowTick+random.nextInt(4);
                //midiOperation.addNoteToTrack(note,startTick,endTick);
                note=random.nextInt(3)*12+72+firstTone+cnNote[random.nextInt(4)];
                midiOperation.addNoteToTrack(note,startTick-1+random.nextInt(2),endTick-1+random.nextInt(2));
                //midiOperation.addNoteToTrack((note/12)*12+firstTone+cnNote[random.nextInt(4)],
                //        startTick-1+random.nextInt(2),endTick-1+random.nextInt(2));
                nowTick+=random.nextInt(4);

            }
            midiOperation.savedSetting();
            midiOperation.play();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
