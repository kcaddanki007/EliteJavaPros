/*
There are two different colored balls in a box, either 'red' or 'blue' in color.
Red color balls are indicated with 1 and Blue color balls are indiacted with 2.
 
All the balls are placed in a row in random order, 
Your task is to find the largest consecutive set of blue colored balls
in the row and print the length of it.
 
 
 Input Format:
 -------------
 Line-1: An integer N represents the number of balls.
 Line-2: N Space seperated integers, only 1's and 2's
   
 Output Format:
 --------------
 Print an integer result.
  
   
 Sample Input-1:
 ---------------
8
2 2 2 1 2 2 1 1
   
 Sample Output-1:
 ----------------
3
   
   
 Sample Input-2:
 ---------------
10
1 2 2 1 2 1 2 2 1 2
   
 Sample Output-2:
 ----------------
 2
*/

import java.util.*;
import java.lang.*;
class day14p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int maxCount=0;
          int sequenceCount=0;
          
		  for(int i=0;i<n;i++){
		      int temp=sc.nextInt();
		      if(temp==1){
		          sequenceCount=0;
		      }
		      else{
		          sequenceCount++;
		          if(sequenceCount>maxCount){
		              maxCount=sequenceCount;
		          }
		      }
		  }
		  System.out.println(maxCount);
	}	 
}        