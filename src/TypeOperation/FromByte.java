package TypeOperation;

import com.sun.istack.internal.NotNull;

public class FromByte {
    private static char[] hexCode={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

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

    @NotNull
    public static String toHexString(byte b){
        StringBuffer buffer=new StringBuffer();
        buffer.append(hexCode[(b>>>4)&0x0f]);
        buffer.append(hexCode[b&0x0f]);
        return buffer.toString();
    }

    @NotNull
    public static String toHexStringArray(byte[] bytes){
        StringBuffer output=new StringBuffer("");
        for(byte a:bytes){
            output.append(toHexString(a));

        }
        return output.toString();
    }


}
