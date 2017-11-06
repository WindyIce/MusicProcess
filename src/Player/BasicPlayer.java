package Player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BasicPlayer {
    private AudioInputStream audioInputStream;
    private AudioFormat audioFormat;
    //private Clip clip;
    private SourceDataLine sourceDataLine;
    private File file;

    public BasicPlayer(String fileName){
        file=new File(fileName);
    }

    public void play()throws UnsupportedAudioFileException,
    IOException,
    LineUnavailableException{
        audioInputStream=AudioSystem.getAudioInputStream(file);
        audioFormat=audioInputStream.getFormat();
        if(audioFormat.getEncoding()!=AudioFormat.Encoding.PCM_SIGNED) {
            audioFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    audioFormat.getSampleRate(),
                    16,
                    audioFormat.getChannels(),
                    audioFormat.getChannels() * 2,
                    audioFormat.getSampleRate(),
                    false
            );//bigEndian
            audioInputStream=AudioSystem.getAudioInputStream(audioFormat,audioInputStream);
        }
        DataLine.Info info=new DataLine.Info(SourceDataLine.class,audioInputStream.getFormat(),
                AudioSystem.NOT_SPECIFIED);
        sourceDataLine=(SourceDataLine) AudioSystem.getLine(info);
        sourceDataLine.open(audioInputStream.getFormat(),sourceDataLine.getBufferSize());
        sourceDataLine.start();
        int numRead=0;
        byte[] buffer=new byte[sourceDataLine.getBufferSize()];
        while((numRead=audioInputStream.read(buffer,0,buffer.length))>=0){
            int offset=0;
            while(offset<numRead){
                offset+=sourceDataLine.write(buffer,offset,numRead-offset);
            }
        }
        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
        audioInputStream.close();
    }

}
