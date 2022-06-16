/*Vimal and Kamal are pals. They're attempting to play a word game.
The following are the game's rules:
- There will be two terms in the game: w1 and w2.
- One of the words must be chosen by Kamal.
- If Kamal picks w1, w1[i] should be greater than w2[i], for every 'i' 
  in 0 <= i < w1.length OR vice versa, for some shuffle of w1 and w2.
- Kamal is the winner if the preceding step is true; else, Kamal is the loser.

Your task is to assist Kamal in selecting the winning word.
If feasible, print 'winner,' if not, 'loser.'

Input Format:
-------------
Two space separated strings, two words w1 and w2.

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
break class

Sample Output-1:
----------------
winner

Explanation:
------------
Kamal chooses w2="class", and the shuffle of w1 is "beark", 
so that Kamal wins the word game. 


Sample Input-2:
---------------
kmit ngit

Sample Output-2:
----------------
loser
*/
import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        char[] w1 = sc.next().toCharArray();
        char[] w2 = sc.next().toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        System.out.println(WinsOrNot(w1,w2));
    }
    public static String WinsOrNot(char w1[],char w2[])
    {
        char[] t1=null,t2=null;
        int n = w1.length;
        for(int i=0;i<n;i++)
        {
            if(w1[i]!=w2[i])
            {
                if(t1==null && t2==null)
                {
                    if(w1[i]>w2[i])
                    {
                        t1=w1;
                        t2=w2;
                    }
                    else
                    {
                        t1=w2;
                        t2=w1;
                    }
                }
                else
                {
                    if(t1[i]<t2[i])
                        return "loser";
                }
            }
        }
        return "winner";
    }
}