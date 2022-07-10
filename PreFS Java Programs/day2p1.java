/*Ms Teena is a Data Entry Operator. She is facing a problem with the keyboard.
Whenever she press the spacebar for one time, it is typing one or more spaces.

You will be given line of words as a string W, typed by Ms Teena.
Your task is to find the lenth of the word which is at the end of the W.

A word is a non empty string consist of no spaces.

Input Format:
-------------
A String W, consist of spaces and alphabets.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
"Welcome to Finishing School"

Sample Output-1:
----------------
6


Sample Input-2:
---------------
"  try  to solve   this   program   "

Sample Output-2:
----------------
7


NOTE: In the input, the quotes " " for your understanding.
*/


//WORKING WITH STRINGS

import java.util.*;
class day2p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String s = sc.nextLine();
          String trims = s.trim();
          String[] splits = trims.split(" ");
          int n = splits.length;
          String f = splits[n-1];
          System.out.println(f.length());
    }
}
