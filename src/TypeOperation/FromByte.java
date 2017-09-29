package TypeOperation;

public class FromByte {
    public static short getShort(byte buffer1,byte buffer2){
        short r=0;
        r|=(buffer1&0x00ff);
        r<<=8;
        r|=(buffer2&0x00ff);
        return r;
    }

    public static int getInt(byte buffer1,byte buffer2,byte buffer3,byte buffer4){
        int r=0;
        r|=(buffer1&0x000000ff);
        r<<=8;
        r|=(buffer2&0x000000ff);
        r<<=8;
        r|=(buffer3&0x000000ff);
        r<<=8;
        r|=(buffer4&0x000000ff);
        return r;
    }
}
