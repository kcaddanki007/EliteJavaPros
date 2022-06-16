/*Somayajaulu working with strings.
He is given a string S, string S contains repeated characters.
Somayajulu decided to delete all the repeated characters, 
such that each character in S should appears once and only once.
He is deleting the characters from S in such a way that, 
the final string should be the smallest string among all possibilities

You are given the string S.
Your task is to help Somayajulu to find the smallest string possible 
after deleting the repeated characters from S.

Input Format:
-------------
A string S.

Output Format:
--------------
Print a string, smallest string after deleting repeated characters.


Sample Input-1:
---------------
attitude

Sample Output-1:
----------------
aitude


Sample Input-2:
---------------
cbabacbabca

Sample Output-2:
----------------
abc
*/
import java.util.*;
class day48p6{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
 int l[]=new int[26];
        for(int i=0;i<s.length();i++){
            l[s.charAt(i)-'a']=i;
        }
        Stack<Integer> st=new Stack();
        boolean se[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(se[c]) continue;
            while(!st.isEmpty()&&st.peek()>c&&i<l[st.peek()]){
                se[st.pop()]=false;;
            }
            st.push(c);
            se[c]=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        System.out.println(sb.reverse().toString());

    }
}