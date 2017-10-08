package TypeOperation;

import org.jetbrains.annotations.NotNull;

public class Visuallize {
    @NotNull
    public static String formatHexString(String hex){
        StringBuffer returnString=new StringBuffer("");
        int count=hex.length();
        int counter=1;
        while(count>0){
            if(counter!=0&&counter%3==0){
                returnString.append(" ");
            }
            else{
                returnString.append(hex.charAt(hex.length()-count));
                --count;
            }
            ++counter;
        }
        return returnString.toString();
    }
}
