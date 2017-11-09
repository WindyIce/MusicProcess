package Midi;

import TypeOperation.FromByte;
import TypeOperation.Visuallize;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MidiReaderSample {

    public static void MidiToText(String inputFile,String outputFile)throws FileNotFoundException,IOException{
        MidiReader midiReader=new MidiReader(inputFile);
        byte[] b=midiReader.getBuffer();
        String out= FromByte.toHexArray(b);
        out= Visuallize.formatHexString(out);
        FileWriter fileWriter=new FileWriter(outputFile);
        fileWriter.write(out);
    }

}
