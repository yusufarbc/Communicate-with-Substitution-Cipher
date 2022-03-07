
package substitution;

import java.util.*;

public class Encryption extends Thread{
    private ArrayList<Character> list; 
    private char[] key;
    private char[] letters;
    char character;

    public Encryption(String key, String message) {
        this.key = key.toCharArray();
        this.letters = message.toCharArray();
        character = ' ';
        list = new ArrayList();
        list.clear();
        for(int i=32;i<127;++i){
            list.add(Character.valueOf(character));
            System.out.print(character);
            character++;
        }
    }

    public char[] encrypt(){
       
        for(int i =0;i<letters.length;i++){
            for(int j = 0;j<list.size();j++){
                if(letters[i]==list.get(j)){
                    letters[i] = key[j];
                    break;
                }
            }
        }
        System.out.println("");
        return letters;
    }
}
