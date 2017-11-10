package TypeOperation;

import org.jetbrains.annotations.NotNull;

public class ToByte {

    @NotNull
    public static byte[] hexToBytes(String hexString){
        hexString=hexString.toUpperCase();
        int length=hexString.length()/2;
        char[] hexChars=hexString.toCharArray();
        byte[] d=new byte[length];
        for(int i=0;i<length;++i){
            int pos=i*2;
            d[i]=new Integer(charToByte(hexChars[pos])<<4|charToByte(hexChars[pos+1])).byteValue();
        }
        return d;
    }

    private static byte charToByte(char c){
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}

