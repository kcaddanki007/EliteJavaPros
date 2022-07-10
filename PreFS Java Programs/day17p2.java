/*
You are given a list of integers List[].
Your can choose any integers in List[] of size exactly 3 , such that the product
of the integers should be highest.
And print the highest value.
    
Input Format:
-------------
Line-1: An integer N represents size of the list.
Line-2: N space separated integers, List[]
   
Output Format:
---------------
Print an integer value
  
Constraints:

    3 <= N <= 10^4
    -1000 <= list[i] <= 1000

  
Sample Input-1:
---------------
5
1 2 -3 -4 5
   
Sample Output-1:
----------------
60
  
Explanation:
------------
The integers are -3,-4,5.
  
Sample Input-2:
---------------
6
-6 2 4 1 2 3
   
Sample Output-2:
----------------
24

Explanation:
------------
The integers are 4,3,2.
    
*/
import java.util.*;
import java.lang.*;
class day17p2{
	
	    static int maxProduct(int[] arr){
	        Arrays.sort(arr);
	        int n=arr.length;
	        int negMax = arr[0]*arr[1]*arr[n-1];
	        int posMax = arr[n-1]*arr[n-2]*arr[n-3];
	        if(negMax>posMax)
	            return negMax;
	        else
	           return posMax;
			
		}
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  int[] arr = new int[n];
		  
		  for(int i=0;i<n;i++){
		      arr[i] = sc.nextInt();
		  }
		  
		  int mp = maxProduct(arr);
		  
		 System.out.println(mp);
	}	 
}       