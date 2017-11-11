package Midi;

import com.sun.istack.internal.NotNull;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MidiProcessInput {
    private static final int baseNote=64;//0x3c
    private int firstToneNote=0;
    private static final HashMap<String,Integer>toneMap  = new HashMap<String,Integer>(){{
        put("Db",-11);
        put("D",-10);
        put("Eb",-9);
        put("E",-8);
        put("F",-7);
        put("Gb",-6);
        put("G",-5);
        put("Ab",-4);
        put("A",-3);
        put("Bb",-2);
        put("B",-1);
        put("C",0);
        put("C#",1);
    }};
    private static final HashMap<Character, Integer>inputMap=new HashMap<Character, Integer>(){{
        put('1',12);put('2',14);put('3',16);put('4',17);put('5',19);put('6',21);put('7',23);put('8',24);put('9',26);put('0',28);put('-',29);put('=',31);
        put('!',12);put('@',14);put('#',16);put('$',17);put('%',19);put('^',21);put('&',23);put('*',24);put('(',26);put(')',28);put('_',29);put('+',31);
        // note that \\ means 33     6up
        put('q',0);put('w',2);put('e',4);put('r',5);put('t',7);put('y',9);put('u',11);put('i',12);put('o',14);put('p',16);put('[',17);put(']',19);put('\\',33);
        put('Q',0);put('W',2);put('E',4);put('R',5);put('T',7);put('Y',9);put('U',11);put('I',12);put('O',14);put('P',16);put('{',17);put('}',19);put('|',33);

        put('a',-12);put('s',-10);put('d',-8);put('f',-7);put('g',-5);put('h',-3);put('j',-1);put('k',0);put('l',2);put(';',4);put('\'',5);
        put('A',-12);put('S',-10);put('D',-8);put('F',-7);put('G',-5);put('H',-3);put('J',-1);put('K',0);put('L',2);put(':',4);put('\"',5);

        put('z',-24);put('x',-22);put('c',-20);put('v',-19);put('b',-17);put('n',-15);put('m',-13);put(',',-12);put('.',-10);put('/',-8);
        put('Z',-24);put('X',-22);put('C',-20);put('V',-19);put('B',-17);put('N',-15);put('M',-13);put('<',-12);put('>',-10);put('?',-8);
    }};

    public static int getOffset(String tone){
        return toneMap.get(tone);
    }

    public MidiProcessInput(){
        firstToneNote=baseNote;
    }

    public MidiProcessInput(String baseTone){
        firstToneNote=baseNote+toneMap.get(baseTone);
    }

    public void firstToneUp(){
        firstToneNote+=12;
    }
    public void firstToneDown(){firstToneNote-=12;}

    public void startStandardInput()throws NullPointerException{
        char i;
        int note;
        while(true){
            try {
                i = (char) System.in.read();
                note = inputMap.get(i) + firstToneNote;
                MidiOperation.playGlobal(note, 1);
            }
            catch (IOException e){e.printStackTrace();}

            catch (NoSuchMethodException e){
                break;
            }
        }
    }
}
