import java.util.HashMap;
import java.util.Map;

public class Codec {
    private int offset;
    private char offsetChar;
    private Map<Integer, Character> intToChar = new HashMap<>();
    private Map<Character, Integer> charToInt = new HashMap<>();

    public Codec(char c){
        //init reference table
        for (int i=0;i<44;i++){
            if(i<26){
                intToChar.put(i,(char) (i+65));
                charToInt.put((char) (i+65),i);
            } else if(i<36){
                intToChar.put(i,(char) (i+22));
                charToInt.put((char) (i+22),i);
            } else {
                intToChar.put(i, (char) (i+4));
                charToInt.put((char) (i+4),i);
            }
        }
        //set offset char
        offsetChar = c;
        //check if encoding char is valid
        if((int) c <40 || (int) c >90) {
            offset = 0;
        } else {
            offset = charToInt.get(c);
        }
    }

    public int getOffset(){
        return offset;
    }

    public String encode(String plainText){
        String result = Character.toString(offsetChar);
        for(int i=0;i<plainText.length();i++){
             char unencodedChar = plainText.charAt(i);
             if(unencodedChar==' '){
                 result+=unencodedChar;
             } else {
                 int idx = charToInt.get(unencodedChar);
                 result += intToChar.get((idx-this.offset)%44);
             }
        }
        return result;
    }

    public String decode(String encodedText){
        char decodeOffsetChar = encodedText.charAt(0);
        int decodeOffset = charToInt.get(decodeOffsetChar);
        String result = "";
        for(int i=1;i<encodedText.length();i++){
            char encodedChar = encodedText.charAt(i);
            if(encodedChar==' '){
                result+=encodedChar;
            } else {
                int idx = charToInt.get(encodedChar);
                result+=intToChar.get((idx+decodeOffset)%44);
            }
        }
        return result;
    }
}
