package Midi;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

public class MidiProcessInput {
    private final int baseNote=64;//0x3c
    private int firstToneNote;
    private final HashMap<String,Integer>toneMap  = new HashMap<String,Integer>(){{
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
    private final HashMap<Character, Integer>inputMap=new HashMap<Character, Integer>(){{
        put('1',12);put('2',14);put('3',16);put('4',17);put('5',19);put('6',21);put('7',23);put('8',24);put('9',26);put('0',28);put('-',29);put('=',31);

        // note that \\ means 33     6up
        put('q',0);put('w',2);put('e',4);put('r',5);put('t',7);put('y',9);put('u',11);put('i',12);put('o',14);put('p',16);put('[',17);put(']',19);put('\\',33);

        put('a',-12);put('s',-10);put('d',-8);put('f',-7);put('g',-5);put('h',-3);put('j',-1);put('k',0);put('l',2);put(';',4);put('\'',5);
    }};

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
}
