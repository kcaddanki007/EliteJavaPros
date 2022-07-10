/*Mr Bilahari is working with Binary String BS,
He is given an integer D.
Your task is to find the length of the subsequence of BS whose decimal value is 
less than or equal to D, whihc is maximum in length.

Note: The subsequence can contain leading zeroes


Input Format:
-------------
Line-1: A binary string, bs
Line-2: An integer, D

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
1000110010
5

Sample Output-1:
----------------
7

Explanation: 
------------
The longest binary sub sequence is 0000010 which is 2 less than 5


Sample Input-2:
---------------
1001010
6

Sample Output-2:
----------------
5

Explanation: 
------------
The longest binary sub sequence are 00010, 00100, or 00101 the values are less than 6.
*/
import java.util.*;
class day86p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int val = sc.nextInt();
        System.out.println(getLongestBinString(s,val));
    }
    static int getLongestBinString(String s,int val){
        String strVal = Integer.toBinaryString(val);
        if(strVal.length()>s.length()) return s.length();
        int num=0;
        for(int i=0;i<s.length()-strVal.length();i++)
            if(s.charAt(i)=='0') num++;
        int x=strVal.compareTo(s.substring(s.length()-strVal.length(),s.length()));
        if(x>=0) return num+strVal.length();
        else return num+strVal.length()-1;
    }
}