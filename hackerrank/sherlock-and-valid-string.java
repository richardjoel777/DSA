import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    static String isValid(String s) {
    final String GOOD = "YES";
    final String BAD = "NO";

    if(s.isEmpty()) return BAD;
    if(s.length() <= 3) return GOOD;

    int[] letters = new int[26];
    for(int i = 0; i < s.length(); i++){
        letters[s.charAt(i) - 'a']++;
    }
    Arrays.sort(letters);
    int i=0;
    while(letters[i]==0){
        i++;
    }
    //System.out.println(Arrays.toString(letters));
    int min = letters[i];   //the smallest frequency of some letter
    int max = letters[25]; // the largest frequency of some letter
    String ret = BAD;
    if(min == max) ret = GOOD;
    else{
        // remove one letter at higher frequency or the lower frequency 
        if(((max - min == 1) && (max > letters[24])) ||
            (min == 1) && (letters[i+1] == max))
            ret = GOOD;
    }
    return ret;
}

}