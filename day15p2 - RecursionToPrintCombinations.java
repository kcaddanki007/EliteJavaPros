/*Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
		   abc	   def
		 
	4		5		6
   ghi     jkl     mno
  
	7		8		9
  pqrs     tuv    wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]
*/
import java.util.*;
import java.lang.*;
class day15p2{
        static HashMap<Integer,String> map = new HashMap<>();
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String str = sc.nextLine();
		  
		  map.put(2,"abc");
		  map.put(3,"def");
		  map.put(4,"ghi");
		  map.put(5,"jkl");
		  map.put(6,"mno");
		  map.put(7,"pqrs");
		  map.put(8,"tuv");
		  map.put(9,"wxyz");
		  
		  System.out.println(getComb(str,0,str.length()));
		}
		static ArrayList<String> getComb(String str,int i,int n){
		    if(i==n-1){
		        String temp = map.get(Integer.parseInt(str.substring(i,n)));
		        ArrayList<String> ans = new ArrayList<>();
		        for(int j=0;j<temp.length();j++) ans.add(temp.substring(j,j+1));
		        return ans;
		    }
		    else{
		        String temp = map.get(Integer.parseInt(str.substring(i,i+1)));
		        ArrayList<String> ans = new ArrayList<>();
		        ArrayList<String> val = getComb(str,i+1,n);
		        for(int j=0;j<temp.length();j++){
		            for(String each : val){
		                ans.add(temp.substring(j,j+1)+each);
		            }
		        }
		      return ans;
		    }
		}
}        

