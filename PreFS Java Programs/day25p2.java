/*
You are given two words source[] and target[].Your can interchange exactly two 
characters in the source.
For example, interchanging 1 and 3 positions in a word "pqrs" results "psrq".

Return true if you can equal the source to the target after interchange. otherwise false.

Input Format:
-------------
Line-1: Two space separated strings represent words.
 
Output Format:
--------------
Print a boolean value.
 
Constraints:
-----------
1 <= source.length , target.length <= 2*10^4
source and target consist only lowercase letters.

 
Sample Input-1:
---------------
pq qp
 
Sample Output-1:
----------------
true

Explanation:
------------
You can Interchange source[0] = 'p' and source[1] = 'q' to get "qp", which is 
equal to target.
 
Sample Input-2:
---------------
xy xy

Sample Output-2:
----------------
false

Explanation:
------------
The only letters you can Interchange are source[0] = 'x' and source[1] = 'y', 
which results in "yx" != target.

Sample Input-3:
---------------
ppppqr pppprq

Sample Output-3:
----------------
true


xy xy 
false

xyy xy
false

xyyyzz xyyyzz
true 

abc acb
true 

abc apq
false

abcde acbed 
false

*/
import java.util.*;
import java.lang.*;
class day25p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String s1 = sc.next();
		  String s2 = sc.next();
		  System.out.println(singleswap(s1,s2));
		  
	}
	    static boolean singleswap(String s1,String s2){
			int countofdiff=0;
			Map<Character, Integer> countofmatch = new HashMap<>();
			int[] index = new int[2];
			int j=0;
			if(s1.length()!=s2.length()){
			  return false;
		  }
		  for(int i=0;i<s1.length();i++){
		      
			  if(s1.charAt(i)!=s2.charAt(i)){
				  countofdiff++;
				  if(j<2){
				  index[j]=i;
				    j++;
				  } 
				  }
			  else{
			      int c = 1;
		          if(!countofmatch.containsKey(s1.charAt(i)))
		              countofmatch.put(s1.charAt(i),c);
		          else{
		              c = countofmatch.get(s1.charAt(i));
		              c++;
		              countofmatch.put(s1.charAt(i),c);
		          }        
			      
			  }
		  }
		  
		  int same=0;
		  for (Map.Entry<Character, Integer> e: countofmatch.entrySet()) {
            if(e.getValue()>1)
              same++;
       }
		  
		  if(same>0 && countofdiff==0){
			  return true;
		  }else if(countofdiff==2){
		      if(s1.charAt(index[0])==s2.charAt(index[1]) && s2.charAt(index[0])==s1.charAt(index[1]))
			     return true;
			  else
			    return false;
		  }else{
		      return false;
		  }
	    }	  	
}    