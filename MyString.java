/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        // System.out.println(countChar(hello, 'h'));
        // System.out.println(countChar(hello, 'l'));
        // System.out.println(countChar(hello, 'z'));
        // System.out.println(subsetOf("sap","space"));
        System.out.println(spacedString(""));
        System.out.println("silent -> \"" + MyString.spacedString("silent") + "\" (expected: s i l e n t)");
        System.out.println("a -> \"" + MyString.spacedString("a") + "\" (expected: a)");
        System.out.println("empty string -> \"" + MyString.spacedString("") + "\" (expected: )");
        System.out.println("hi -> \"" + MyString.spacedString("hi") + "\" (expected: h i)");
        // System.out.println(randomStringOfLetters(3));
        // System.out.println(insertRandomly('s',"cat"));
        // System.out.println(remove("meet","committee"));
        System.out.println(remove("hello", ""));
        // System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int countChar = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
               countChar++; 
            }
        }
        return countChar;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String processedStr2 = str2;
        int str2Index;
        int i = 0;
        //the problem is when we find the char in the 0 index
        while ( i < str1.length()) {
            str2Index = processedStr2.indexOf(str1.charAt(i));
            if ( str2Index!= -1) {
                if (str2Index == 0) {
                  processedStr2 =  processedStr2.substring(str2Index+1);
                } else {
                 processedStr2 = processedStr2.substring(0, str2Index) + processedStr2.substring(str2Index+1);               
                }
            }
            else {
                break;
            }
            i++;
        }
        
        if (i==str1.length()) {
            return true;
        } 
        else {
            return false;
        }
        
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String spacedString = "";
        if (str.equals("")) 
            return "";
        
        if (str.length() == 1)
            return str;
        
        for (int i = 0; i < str.length(); i++) {
            spacedString = spacedString + str.charAt(i);
            if (i < str.length() - 1) { // Add a space only if it's not the last character
                spacedString += " ";
        }
            
        }
        
        return spacedString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        char randomLetter;
        String randomString = "";
        for (int i = 0; i < n; i++) {
        randomLetter = (char) ((int) (Math.random() * (122 - 97 + 1)) + 97);  
        randomString = randomString + randomLetter;
    }
    return randomString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if (str1.length() == str2.length()) {
            return "";
        }
        String processed = str1;
        char currentCharStr2;
        int indexToRemove;
        for (int i = 0; i < str2.length(); i++) {
            currentCharStr2 = str2.charAt(i);
            indexToRemove = processed.indexOf(currentCharStr2);
            if (processed.indexOf(currentCharStr2) == 0) {
                  processed =  processed.substring(currentCharStr2+1);
                } else {
            processed = processed.substring(0, indexToRemove) + processed.substring(indexToRemove+1);               
        }
        }
        return processed;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
