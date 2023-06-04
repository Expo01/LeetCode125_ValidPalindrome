/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
 */

import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String testString = "hannaH.";
        System.out.println(new Solution().isPalindrome(testString));
    }
}

//my idea: take a String, convert to lower case and then convert to char array. create a conditional where if a charactes
// alphanumeric, then add the character to both a stack and a queue. when removing an item frmo each collection, the head
// of the queue and top of the stack should yield the same char. the problem is how to specify alphanumeric characteers

//        Queue<Character> = new Queue<>(); //can't instantiate a Queue like I can a Stack? why not....?
//        Stack<Character> stack = new Stack<>();


//MY SOLUTION
//class Solution {
//    public boolean isPalindrome(String s) {
//        boolean solution = true; // forced to assign value here.
//        s = s.toLowerCase();
//        s = s.replaceAll("[^a-z0-9]", ""); // removes all non-number and non-letter characters
//        if (s.length() <=1) { // captures edge cases where string is a single letter/number or "" which is crazy dumb that
//            // an empty string counts as being the same reverse
//            return true;
//        }
//        char[] converted = s.toCharArray();
//        for (int i = 0; i < converted.length/2; i++) { // cut in half so no redundancy of checking
//            if (converted[i] != converted[converted.length - 1 - i]) { // checks first index with back index and works in
//                return false;
//            }
//        }
//        return solution;
//    }
//}

//AND OF COURSE THE ONE THAT'S BETTER THAN  MINE
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}


