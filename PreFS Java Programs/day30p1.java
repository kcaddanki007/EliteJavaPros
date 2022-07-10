/*
 Mr.Suresh asked Mr.Ramesh to create a grid with set of words in such a way that 
 the length of each word is same.

Mr. Ramesh created the grid accordingly.

Now Mr.Suresh asked Mr.Ramesh to check whether all columns in the grid are in 
lexographically non-decreasing order or not.If not he can remove the respective
columns.
   
Return the number of columns removed by Mr.Ramesh to satisfy the constraints
given by Mr.Suresh. 
  
    
Input Format:
-------------
Line-1 -> an integer N, number of words
Line-2 -> N space separated words of same length
   
Output Format:
--------------
Print a an integer result.

Constraints:
-------------
1<= N <= 100
1<= word[i].length<=1000
word[i] consist all lower case letters.
   
Sample Input-1:
---------------
4
kmec kmit ngit univ
  
Sample Output-1:
---------------
1
   
Explanation:
-------------
Given grid looks as follows:
k m e c
k m i t
n g i t
u n i v
Column-2 is the only one which is not in non-decreasing order.

    
    
Sample Input-2:
---------------
5
abcde ijklm jklmn pqrst vwxyz
  
Sample Output-2:
----------------
0

Explanation:
-------------
All columns are in non-decreasing order.

*/
import java.util.*;
import java.lang.*;
class day30p1{
	  
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  char[][] arr = new char[n][];
		  int len=0;
		  for(int i=0;i<n;i++){
		      String temp = sc.next();
		      len=temp.length();
		      arr[i] = temp.toCharArray();
		  }
		  
		 int count=0;
		 for(int j=0;j<len;j++){
		    for(int i=1;i<n;i++){  //rows
		        if(arr[i][j]<arr[i-1][j]){
		          count++;
		          break;
		        }
		    }
		    
		    
		 }
		 
		  System.out.println(count);
		}
}        