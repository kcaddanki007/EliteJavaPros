/*
nThere are N students stands in a row, where students from ABC school indicated 
with 0's and students from XYZ school indicated with 1's. Trainer asks them 
to stand alternatively according to the school they belongs to. 
[i.e., No two students from same school stands side by side]

You are allowed to perform these operations to arrange them to sit alternatively:
Op-1: Move the first student in the row to the end of the row. 
Op-2: Choose any one student in the row, Shift the student from the current 
      school to other school. 
    [i.e., shift from ABC school to XYZ school or vice-versa]
    
You will be given the initial standing positions of students as a binary string. 
Your task is to find and return the minimum number of Op-2 operations required 
to arrange them to stand alternatively with the above rules.


Input Format:
-------------
A binary string B.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
1100100

Sample Output-1:
----------------
2

Explanation:
------------
Perform Op-1 operation 3 times: The sitting will be 0100110.
Perform Op-2 operation: at 4th and 5th positions in the row.
Finally, sitting is 0101010


Sample Input-2:
---------------
11011

Sample Output-2:
----------------
1
*/
import java.util.*;
class day57p4{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s = sc.next();
		  System.out.println(getFlips(s));
		}
		static int getFlips(String s){
		    int n=s.length();
		    s=s+s;
		    char[] a01 = new char[n+n];
		    char[] a10 = new char[n+n];
		    char[] inp = s.toCharArray();
		    
		    for(int i=0;i<n+n;i++){
		        if(i%2==0){
		            a01[i]='0';
		            a10[i]='1';
		        }else{
		            a01[i]='1';
		            a10[i]='0';
		        }
		    }
		    
		    int c01=0,c10=0,min=Integer.MAX_VALUE;
		    for(int i=0;i<n+n;i++){
		        if(inp[i]!=a01[i]) c01++;
		        if(inp[i]!=a10[i]) c10++;
		        
		        if(i>=n){
		            if(inp[i-n]!=a01[i-n]) c01--;
		            if(inp[i-n]!=a10[i-n]) c10--;
		        }
		        if(i>=n-1){
		            min=Math.min(min,Math.min(c01,c10));
		        }
		    }
		    return min;
		}
}     
 