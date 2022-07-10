/*
Vihaar is working with strings. 
He is given two strings A and B, and another string T,
 where the length of A and B is same.
 
You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
 	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
 	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.
 
For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string
is "ppq".
 
You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.
 
Input Format:
-------------
Three space separated strings, A , B and T
 
Output Format:
--------------
Print a string, relatively smallest string of T.
 
 
Sample Input-1:
---------------
kmit ngit mgit
 
Sample Output-1:
----------------
 ggit
 
Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"
 
 
Sample Input-2:
---------------
attitude progress apriori
 
Sample Output-2:
----------------
 aaogoog
 
 Explanation: 
 ------------
 The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
 the relatively smallest string of T is "aaogoog"
*/

import java.lang.*;
import java.util.*;

class day19p1{
	
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String t = sc.next();
        
        char[] arra = a.toCharArray();
        char[] arrb = b.toCharArray();
        char[] arrt = t.toCharArray();
        
        int[] parent = new int[26];
        
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        
        for(int i=0;i<arra.length;i++){
            union(arra[i]-97,arrb[i]-97,parent);
        }
        
        for(int i=0;i<arrt.length;i++){
            arrt[i]=(char)(find(arrt[i]-97,parent)+97);
        }
        
        for(int i=0;i<arrt.length;i++){
            System.out.print(arrt[i]);
        }
        

    }
	
    public static int find(int x,int[] a)
    {
        if(a[x] == x)
            return x;
        return find(a[x],a);
    }
	
    public static void union(int x,int y,int parent[])
    {
        if(find(x,parent) < find(y,parent)){
            parent[find(y,parent)]=find(x,parent);
        }
        
        else if(find(x,parent) > find(y,parent)){
            parent[find(x,parent)]=find(y,parent);
        }
    }
}