/*
 A Magic box has cells with p rows and r columns.Each cell is initially empty
 (represented by 0).
You are given a 'c' set of cells cell[][] and the box should be filled with 
gold coins as follows.
	-For each given cell (i,j) , Add 1 gold coin for each cell starting 
	from (0,0) to 	 (i-1,j-1).

Your task is to return the number of cells with maximum number of gold coins 
after performing 'c' operations.

Input Format:
-------------
Line-1: Two space seperated integers represents p,r.
Line-2: An integer represents 'c'.
Next c Lines: Two-space separated integers representa cell.
  
Output Format:
--------------
 Print an integer value.
   
 Sample Input-1:
 ---------------
4 4
3
4 3
1 3
1 2
  
Sample Output-1:
----------------
2

Explanation:
------------
Look Hint for explanation.
   
Sample Input-2:
---------------
2 2
1
1 2
  
Sample Output-2:
----------------
2


*/
import java.util.*;
import java.lang.*;
class day29p3{
	    
		static int getmaxcount(int[][] arr,int c){
		    int minr=Integer.MAX_VALUE;
		    int minc=Integer.MAX_VALUE;
		    for(int i=0;i<c;i++){
		        if(arr[i][0]<minr) minr=arr[i][0];
		        if(arr[i][1]<minc) minc=arr[i][1];
		    }
		    return minr*minc;
		}
		    
		    
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int p = sc.nextInt();
		  int r = sc.nextInt();
		  
		  int c = sc.nextInt();
		  int[][] arr = new int[c][2];
		  for(int i=0;i<c;i++){
		      arr[i][0]=sc.nextInt();
		      arr[i][1]=sc.nextInt();
		  }
		  System.out.println(getmaxcount(arr,c));
		}
}        