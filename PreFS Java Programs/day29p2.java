/*
Ram and Shiva work in the same office but in different departments. Ram needs to
share a password protected file with Shiva.Ram encrypted the password message and
sent to Shiva.

 The Password is a single word w[] of length 'N' which consists only 2 types of 
 characters 'A' and 'D'.
 Now Shiva has to decrypt the message in terms of an integer array ar[] with the 
 following rules.
  -w[i]='A' if ar[i]<ar[i+1]
  -w[i]='D' if ar[i]>ar[i+1]
  -He has to use the numbers from 0 to N only.

Return the decrypted array which consists of N+1 elements (0 to N).

Constraints:
 1 <= N <= 10^5
 w[i] is either 'A' or 'D' .


Input Format:
-------------
Line-1: A string represents a word.
 
Output Format:
--------------
Print an integer array.

 
Sample Input-1:
---------------
ADAD
 
Sample Output-1:
----------------
0 4 1 3 2  

Explanation:
------------
0 to 4 --> Ascending(A)
4 to 1 --> Descending(D)
1 to 3 --> Ascending(A)
3 to 2 --> Descending(D)
So the sequence is ADAD.
Sample Input-2:
---------------
AAAA

Sample Output-2:
----------------
0 1 2 3 4

Explanation:
------------
0 to 1 --> Ascending(A)
1 to 2 --> Ascending(A)
2 to 3 --> Ascending(A)
3 to 4 --> Ascending(A)
So the sequence is AAAA.

   
*/
import java.util.*;
import java.lang.*;
class day29p2{
	    static int[] getpw(String S){
			int n = S.length();
			int low=0,high=n;
			int[] arr = new int[n+1];
			
		    for(int i=0;i<n;i++){
				if(S.charAt(i)=='A'){
				    arr[i]=low;
				    low++;
				}else{
				    arr[i]=high;
				    high--;
				}
			}
			if(S.charAt(n-1)=='A') arr[n]=low;
			else arr[n]=high;
			return arr;
		}
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String S = sc.next();
	      System.out.println(Arrays.toString(getpw(S)));		  
		}
}        