
package substitution;

import java.util.*;


public class Decryption extends Thread{
    private ArrayList<Character> list; 
    private char[] key;
    private char[] letters;
    char character;

    public Decryption(String key, String cipher) {
        this.key = key.toCharArray();
        this.letters = cipher.toCharArray();
        character = ' ';
        list = new ArrayList();
        list.clear();
        for(int i=32;i<127;++i){
            list.add(Character.valueOf(character));
            character++;
        }
    }

    public char[] decrypt(){
       
        for(int i =0;i<letters.length;i++){
            for(int j = 0;j<key.length;j++){
                if(letters[i]==key[j]){
                    letters[i] = list.get(j);
                    break;
                }
            }
        }
        return letters;
    }
}

