/*
You are given a list of positive integers List[], and an integer S.
Your task is find a subList[] in List[] of length S, such that
the avarage sum of subList[] should be highest.
And print the avarage value.
    
Input Format:
-------------
Line-1: An integer N represents size of the list.
Line-2: N space separated integers, List[]
Line-3: An integer S, length of subList[]
   
Output Format:
---------------
Print a double value.
  
  
Sample Input-1:
---------------
6
4 14 -8 -2 27 12
4

Explanation:
------------
Sublist is [14 -8 -2 27]
    
Sample Output-1:
----------------
7.75
  
  
Sample Input-2:
---------------
7
-3 -5 7 8 12 -10 -12
4
   
Sample Output-2:
----------------
5.5

Explanation:
------------
Sublist is [-5 7 8 12]
    
*/
import java.util.*;
import java.lang.*;
class day14p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int sequencesum=0;
          float maxsum = 0;
          int[] arr = new int[n];
          
          for(int i=0;i<n;i++){
              arr[i]=sc.nextInt();
          }
          
          int m=sc.nextInt();
          
          for(int i=0;i<m;i++){
              sequencesum+=arr[i];
          }
          
          maxsum=sequencesum;
          
          for(int i=m;i<n;i++){
              sequencesum-=arr[i-m];
              sequencesum+=arr[i];
              if(sequencesum>maxsum){
                  maxsum=sequencesum;
              }
          }
          
          System.out.println(maxsum/m);
          
		  
	}	 
}        