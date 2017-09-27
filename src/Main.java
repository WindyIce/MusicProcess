import Midi.MidiOperation;

public class Main {
    public static void main(String[] args){
        try {
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
        }

    }
}
