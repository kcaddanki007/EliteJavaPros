/*Cards Castle is a structure created by stacking cards on top of each other.

You are given a set of N cards, using them you have to build a Card Castle, by 
the following ruleset:
 - A Card Castle made up of cards arranged in rows of '/\'(triangle shape)
   and placing the cards horizontally on the triangles.
 - A '/\' shape can be achieved by leaning two cards against each other.
 - A card must be placed horizontally, between all adjacent triangles in a row.
 - Any triangle on a row higher than the first must be placed on a 
   horizontal card from the previous row.
 - Each triangle is placed in the leftmost available spot in the row.

Your taskis to find the number of unique Card Castles you can build using all N 
cards. 

NOTE: Two Card Castles are considered unique, if there exists a row 
where the two castles contain a different number of cards.


Input Format:
-------------
An integer N, number of cards

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7

Sample Output-1:
----------------
1


Sample Input-2:
---------------
19

Sample Output-2:
----------------
3


Sample Input-3:
---------------
6

Sample Output-3:
----------------
0


Look hint for the explanation of the sample testcases.
*/
import java.util.*;
class Solution{
    static int count=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getCntOfUniqCardCastles(0,n);
        System.out.println(count);
    }
    static void getCntOfUniqCardCastles(int prev,int n){
        int temp = (prev==0)?-1:prev;
        
        if(n%3 == 2 && n > prev){
            //System.out.println("res " +prev+" "+n);
            count++;
        } 
        while(temp < n){
            temp = temp+3;
            int next = n-temp;
            if(next<temp) break;
           // System.out.println("temp "+temp+" "+next);
            getCntOfUniqCardCastles(temp,next);
            
        }
    }
}
