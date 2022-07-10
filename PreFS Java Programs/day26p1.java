/*
An array ar[] is called as closed array when we subtract the largest and smallest 
element in the array,the result is equal to 1.

Your task is to return the length of its greatest closed subsequence among all
its possible subsequences.

A subsequence of array is a sequence that can be taken from the array by removing 
some or no elements without changing the order of the remaining elements.

Input Format:
-------------
Line-1: An integer n number of elements.
Line-2: n space separated integers represent the elements.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= n <= 10^4
 -10^4 <= ar[i] <= 10^4

 
Sample Input-1:
---------------
6
4 3 5 2 6 3
 
Sample Output-1:
----------------
3

Explanation:
------------
Subsequence is [4,3,3]
 
Sample Input-2:
---------------
7
20 19 19 29 37 35 19

Sample Output-2:
----------------
4

Explanation:
------------
Subsequence is [20 19 19 19]
 
*/
import java.util.*;
import java.lang.*;
class day26p1{
	public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++){
		      arr[i] = sc.nextInt();
		  }
		  System.out.println(getsslen(arr,n));
	}
	
	static int getsslen(int[] arr,int n){
	    
			Map<Integer, Integer> counter = new HashMap<>();
			for(int i=0;i<n;i++){
              int p = arr[i];
              int count=1;
              if(!counter.containsKey(p)){
                  counter.put(p,count);
              }
              else{
                  count = counter.get(p);
                  count++;
                  counter.put(p,count);
              }
          }
		  
		  int max=0;
		  
		  for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
		      int key = e.getKey();
		      if(counter.containsKey(key+1)){
		          if(e.getValue()+counter.get(key+1)>max)
		             max = e.getValue()+counter.get(key+1);
		      }
   	    }
		  return max;
    }
}        