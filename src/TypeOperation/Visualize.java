package TypeOperation;


import com.sun.istack.internal.NotNull;

public class Visualize {

    @NotNull
    public static String formatHexString(String hex){
        StringBuilder returnString=new StringBuilder("");
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
