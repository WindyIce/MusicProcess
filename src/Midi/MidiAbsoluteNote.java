package Midi;

import java.util.HashMap;

public class MidiAbsoluteNote {
    private static final HashMap<String,Short>absoluteNote=new HashMap<String,Short>(){{
        put("A0",(short)21);put("AS0",(short)22);put("BF0",(short)22);put("B0",(short)23);

        put("C1",(short)24);put("CS1",(short)25);put("DF1",(short)25);put("D1",(short)26);put("DS1",(short)27);put("EF1",(short)27);put("E1",(short)28);put("F1",(short)29);put("FS1",(short)30);put("GF1",(short)30);put("G1",(short)31);put("GS1",(short)32);put("AF1",(short)32);put("A1",(short)33);put("AS1",(short)34);put("BF1",(short)34);put("B1",(short)35);

        put("C2",(short)36);put("CS2",(short)37);put("DF2",(short)37);put("D2",(short)38);put("DS2",(short)39);put("EF2",(short)39);put("E2",(short)40);put("F2",(short)41);put("FS2",(short)42);put("GF2",(short)42);put("G2",(short)43);put("GS2",(short)44);put("AF2",(short)44);put("A2",(short)45);put("AS2",(short)46);put("BF2",(short)46);put("B2",(short)47);

        put("C3",(short)48);put("CS3",(short)49);put("DF3",(short)49);put("D3",(short)50);put("DS3",(short)51);put("EF3",(short)51);put("E3",(short)52);put("F3",(short)53);put("FS3",(short)54);put("GF3",(short)54);put("G3",(short)55);put("GS3",(short)56);put("AF3",(short)56);put("A3",(short)57);put("AS3",(short)58);put("BF3",(short)58);put("B3",(short)59);

        put("C4",(short)60);put("CS4",(short)61);put("DF4",(short)61);put("D4",(short)62);put("DS4",(short)63);put("EF4",(short)63);put("E4",(short)64);put("F4",(short)65);put("FS4",(short)66);put("GF4",(short)66);put("G4",(short)67);put("GS4",(short)68);put("AF4",(short)68);put("A4",(short)69);put("AS4",(short)70);put("BF4",(short)70);put("B4",(short)71);

        put("C5",(short)72);put("CS5",(short)73);put("DF5",(short)73);put("D5",(short)74);put("DS5",(short)75);put("EF5",(short)75);put("E5",(short)76);put("F5",(short)77);put("FS5",(short)78);put("GF5",(short)78);put("G5",(short)79);put("GS5",(short)80);put("AF5",(short)80);put("A5",(short)81);put("AS5",(short)82);put("BF5",(short)82);put("B5",(short)83);

        put("C6",(short)84);put("CS6",(short)85);put("DF6",(short)85);put("D6",(short)86);put("DS6",(short)87);put("EF6",(short)87);put("E6",(short)88);put("F6",(short)89);put("FS6",(short)90);put("GF6",(short)90);put("G6",(short)91);put("GS6",(short)92);put("AF6",(short)92);put("A6",(short)93);put("AS6",(short)94);put("BF6",(short)94);put("B6",(short)95);

        put("C7",(short)96);put("CS7",(short)97);put("DF7",(short)97);put("D7",(short)98);put("DS7",(short)99);put("EF7",(short)99);put("E7",(short)100);put("F7",(short)101);put("FS7",(short)102);put("GF7",(short)102);put("G7",(short)103);put("GS7",(short)104);put("AF7",(short)104);put("A7",(short)105);put("AS7",(short)106);put("BF7",(short)106);put("B7",(short)107);

        put("C8",(short)108);
    }};

    public static int getNote(String note){
        return absoluteNote.get(note).intValue();
    }

}
