/*Mr Malhotra is given a word W consisting of lowercase alhpabest,and an integer I.
A substring S of W is said to be an ECS string, if S obeys the following rule:
    - each distinct alphabet in S, appears exactly I times in S.

Your task is to help Mr Malhotra to return the number of ECS strings in W.

Input Format:
-------------
Line-1: A String W
Line-2: An integer I

Output Format:
--------------
Print an integer result


Sample Input-1:
---------------
abbabbaba
2

Sample Output-1:
----------------
5

Explanation: 
------------
The ECS strings are 'abba' for 2 times, 'bb' for 2 times and 'baba' for 1 time


Sample Input-2:
---------------
pqrs
1

Sample Output-2:
----------------
10
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        System.out.println(getCountOfECSstrings(s,n));
    }
    static int getCountOfECSstrings(String s,int n){
        int len = s.length();
        int resultCount=0;
        for(int size=n;size<=len;size+=n){
            int[] carr = new int[26];
            //window initialisation
            for(int j=0;j<size;j++)
                carr[s.charAt(j)-'a']++;
            //System.out.println(s.substring(0,size));
            if(isECS(carr,n)) 
                resultCount++;
            //rest
            for(int j=size;j<len;j++){
                carr[s.charAt(j-size)-'a']--;
                carr[s.charAt(j)-'a']++;
                //System.out.println(s.substring(j-size,j+1));
                if(isECS(carr,n)) resultCount++;
            }
        }
        return resultCount;
    }
    static boolean isECS(int[] carr,int n){
        for(int i=0;i<26;i++){
            if(!(carr[i]==n || carr[i]==0)) return false;
        }
        return true;
    }
}