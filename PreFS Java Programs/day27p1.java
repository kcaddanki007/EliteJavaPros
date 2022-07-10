/*
Amazon is conducting a drive online for eligible candidates. The candidate, who 
scores highest points in online test and his/her points are atleast two times 
greater than all other individual candidate's points, will be shortlisted 
directly to HR round.

Given an array of points  points[], return the index position of the shortlisted
candidate.If no one exist return -1.

Input Format:
-------------
Line-1: An integer n number of candidates.
Line-2: n space separated integers represent the points scored by each candidate.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= n <= 500
 1 <= points[i] <= 100

 
Sample Input-1:
---------------
5
4 8 2 1 3
 
Sample Output-1:
----------------
1

Explanation:
------------
8 is two times greater than all other values.
 
Sample Input-2:
---------------
6
2 4 6 18 18 5

Sample Output-2:
----------------
-1

Explanation:
------------
No candidate selected for HR round.
 
*/
import java.util.*;
import java.lang.*;
class day27p1{
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++)
			  arr[i]=sc.nextInt();
		  
		  System.out.println(getIndexOf2xEle(arr,n));
		}
		static int getIndexOf2xEle(int[] arr,int n){
		    int max=arr[0];
		    int secondmax=Integer.MIN_VALUE;
		    int ind=0;
		    
		    for(int i=1;i<n;i++){
		        if(arr[i]>=max){
		            secondmax=max;
		            max=arr[i];
		            ind = i;
		        }else if (arr[i] > secondmax && arr[i] != max)
                      secondmax = arr[i];
		 }
		    if(secondmax==Integer.MIN_VALUE)
		       return -1;
		    else if(max>=2*secondmax)
		      return ind;
		    else     
		       return -1;
		}
}        