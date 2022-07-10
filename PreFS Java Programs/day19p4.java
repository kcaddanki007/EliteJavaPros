/*
Krishna is working on strings, He is trying to modify the string which has to 
be first in lexicographic order.
You can modify the string using following operations:
 	- Interchnage the characters at the given pair of indices.
 	- You can perform the interchange of the pair any number of times.
 	- You will be given I number of pairs
 
Example: 
--------
If pair is ->[i,j], you can interchange the characters at i-th and j-th indices
with each other.
  
Krishna is given a String S, an integer I and I pairs of indices.
Can you help Krishna to find the string that can be formed 
after performing interchange operations, which has to be first in the
lexicographical order.
 
Note: String contains only lowercase letters.


Input Format:
-------------
Line-1: A string S
Line-2: An integer I, number of interchanges.
Next I lines: Two space separated integers, interchange pair.
 
Output Format:
--------------
A string, lexicographic smallest string after the interchanges
  
Sample Input-1:
---------------
cba
2
0 1
1 2
   
Sample Output-1:
----------------
abc
 
Explaination: 
-------------
Interchange s[0] and s[1], s = "bca"
Interchange s[1] and s[2], s = "bac"
Interchange s[0] and s[1], s = "abc"
  
Sample Input-2:
---------------
dcab
2
0 3
1 2
   
Sample Output-2:
----------------
bacd
   
Explaination: 
-------------
Interchange s[0] and s[3], s = "bcad"
Interchange s[1] and s[2], s = "bacd"
   
Sample Input-3:
---------------
dcab
3
0 3
1 2
0 2
  
Sample Output-3:
----------------
abcd
   
Explaination: 
-------------
Interchange s[0] and s[3], s = "bcad"
Interchange s[0] and s[2], s = "acbd"
Interchange s[1] and s[2], s = "abcd"
*/

import java.lang.*;
import java.util.*;

class day19p4{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = sc.nextInt();
        
        char[] arrofa = a.toCharArray();
        
        int[] parent = new int[a.length()];
        
        for(int i=0;i<a.length();i++)
            parent[i] = i;
            
        for(int i=0;i<n;i++){
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            union(t1,t2,parent);
        }        
    
        List<Integer> listofi= new ArrayList<>();
        List<Character> listofc = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
          
          for(int i=0;i<arrofa.length;i++){
              set.add(find(i,parent));
              
          }
          
          for (int key: set){
              for(int i=0;i<arrofa.length;i++){
                  if(find(i,parent)==key){
                      listofi.add(i);
                      listofc.add(arrofa[i]);
                  }
              }
              Collections.sort(listofc);
              
              for(int j=0;j<listofi.size();j++){
                  arrofa[listofi.get(j)]=listofc.get(j);
              }
              listofi.clear();
              listofc.clear();
        }
        
        for(int i=0;i<arrofa.length;i++){
            System.out.print(arrofa[i]);
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

