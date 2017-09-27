package Midi;
//http://blog.csdn.net/shao941122/article/details/46124865
import javax.sound.midi.*;

public class MidiOperation {

    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    private int defaultTicks;  //tick - the time-stamp for the event, in MIDI ticks

    public MidiOperation(int instrument)throws MidiUnavailableException,InvalidMidiDataException{
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence=new Sequence(Sequence.PPQ,4);//24 frames per second (resolution is expressed in ticks per frame).

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

    public void savedSetting() throws InvalidMidiDataException{
            sequencer.setSequence(sequence);
    }

    public void play(){
        sequencer.start();
    }
}
