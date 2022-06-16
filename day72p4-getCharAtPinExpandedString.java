/*Anup is interested in Word Play, He invented a new game on words
Anup will give you a string S and index P (1-indexed).
You need apply the rules of the game on that string  
and find out the character at a given index P.

Rules are as follows:
1. You have to read one character at a time and keep appending as a word 
   until you find a digit(d).
2. Once you find a digit, the entire word is repeatedly appended d-1 more 
   times in total.

Input Format:
----------------
Line-1 -> A String S
Line-2 -> An integer P, index value.

Output Format:
------------------
Print the result as a String.


Sample Input-1:
-------------------
kmit2ngit3
12

Sample Output-1:
---------------------
t

Explanation-1:
----------------
The resultant string is "kmitkmitngitkmitkmitngitkmitkmitngit".
The 12th character in the string is "t".

Sample Input-2:
-------------------
ab3c4
9

Sample Output-2:
---------------------
b

Explanation-2:
----------------
The resultant string is "abababcabababcabababcabababc"
The 9th character in the string is "b".
*/
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int p = sc.nextInt();
        System.out.println(getCharacter(s,p-1));
    }
    public static String getCharacter(String s, int p)
    {
        int len=0;
        for(char ch : s.toCharArray())
            len = (Character.isDigit(ch)) ? len * (ch-'0') : ++len;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch) && --len==p)
                return ""+ch;
            else if(Character.isDigit(ch))
            {
                len/=(ch-'0');
                p%=len;
            }
        }
        return null;
    }
}