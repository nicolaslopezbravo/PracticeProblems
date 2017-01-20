import java.io.*;
public class converter{
    public static void main(String [] args){
        converter("code");
    }
    public static void converter(String word){
        char [] letter = word.toCharArray();
        int xCoordinate = 0;

        for(int i = 0; i < word.length(); i++){      
            //adds up the jacked up alphabet which is on base 26 where a is 1
            //the length changes so we gotta change it to only subtract the word part.
            xCoordinate += (letter[i] - 'a' + 1) * Math.pow(26,(letter.length - 1 - i));
                            
        }
        System.out.println(xCoordinate);
    }
}