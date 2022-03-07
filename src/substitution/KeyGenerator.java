
package substitution;

import java.util.*;

public class KeyGenerator extends Thread{
    private ArrayList<Character> list; 
    private ArrayList<Character> shuffledList; 
    private String cipher;
    private char character;
    public KeyGenerator(){
        character = ' ';
        list = new ArrayList();
        for(int i=32;i<127;++i){
            list.add(Character.valueOf(character));
            character++;
        }  
    }

    public String newKey(){
        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);

        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: shuffledList){
            builder.append(ch);
        }
        return builder.toString();
    }
}

