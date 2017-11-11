package Midi;
//http://blog.csdn.net/shao941122/article/details/46124865
//http://blog.sina.com.cn/s/blog_6f72ff900101f95b.html
import javax.sound.midi.*;

public class MidiOperation {

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private int defaultTicks;  //tick - the time-stamp for the event, in MIDI ticks


    public MidiOperation(int instrument)throws MidiUnavailableException,
            InvalidMidiDataException{
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        /**
         * The tempo-based timing type, for which the resolution is expressed in pulses (ticks) per quarter note.
         * @see #Sequence(float, int)
         */
        sequence=new Sequence(Sequence.PPQ,4);

        track=sequence.createTrack();
        ShortMessage firstMessage=new ShortMessage();
        firstMessage.setMessage(192,1,instrument,0);
        MidiEvent firstEvent=new MidiEvent(firstMessage,1);
        track.add(firstEvent);
    }

    public MidiOperation(int instrument,float framesPerSec)throws MidiUnavailableException,
            InvalidMidiDataException{
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        /**
         * The tempo-based timing type, for which the resolution is expressed in pulses (ticks) per quarter note.
         * @see #Sequence(float, int)
         */
        sequence=new Sequence(framesPerSec,4);

        track=sequence.createTrack();
        ShortMessage firstMessage=new ShortMessage();
        firstMessage.setMessage(192,1,instrument,0);
        MidiEvent firstEvent=new MidiEvent(firstMessage,1);
        track.add(firstEvent);
    }

    /*public void addNoteToTrack(int note)throws InvalidMidiDataException{
            ShortMessage shortMessage=new ShortMessage();
            shortMessage.setMessage(144, 1, note, 100);
            MidiEvent noteEvent=new MidiEvent(shortMessage,defaultTicks);
            track.add(noteEvent);
    }*/

    public void addNoteToTrack(int note,int startTick,int endTick)throws InvalidMidiDataException{
        ShortMessage shortMessage=new ShortMessage();
        shortMessage.setMessage(144, 1, note, 100);
        MidiEvent noteOn=new MidiEvent(shortMessage,startTick);
        track.add(noteOn);

        ShortMessage shortMessage1=new ShortMessage();
        shortMessage1.setMessage(128,1,note,100);
        MidiEvent noteOff=new MidiEvent(shortMessage1,endTick);
        track.add(noteOff);
    }

    //need to replace the method by a higher efficient method with lower memory cost
    public static void playGlobal(int note,int instrument)throws NoSuchMethodException{
        throw new NoSuchMethodException();
    }

    public void savedSetting() throws InvalidMidiDataException{
            sequencer.setSequence(sequence);
    }

    public void play(){
        sequencer.start();
    }


}
