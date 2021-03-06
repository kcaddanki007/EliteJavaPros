/*
Mahesh checking his luck in diamonds.There are N boxes and each box has a number 
of diamonds in it. box[i] is the number of diamonds in ith box(0-indexed).

The boxes are arranged in cyclic fashion means box[N-1] is adjacent to box[0].

Mahesh can select the boxes to get the diamonds. But there is a condition that
he cannot choose the boxes which are adjacent.

Help Mahesh to get maximum diamonds.

Input Format:
-------------
Line-1: An Integer N represents number of boxes.
Line-2: N space separated integers represents diamonds in each box.
  
Output Format:
--------------
Print an integer.

Constraints:

    1 <= N <= 100
    0 <= box[i] <= 1000

   
 Sample Input-1:
 ---------------
4
5 10 25 21
  
Sample Output-1:
----------------
31

Explanation:
------------
He can select either 5+25 or 10+21.
The maximum is 31.
   
Sample Input-2:
---------------
3
20 30 40

  
 Sample Output-2:
 ----------------
40

Explanation:
------------
Each box is adjacent to other 2 boxes. so he can choose only one box with maximum value which is 40.

*/
import java.lang.*;
class day23p1{
    int maxDiamonds(int boxes[]){
        
        int dp[] = new int[boxes.length];
        return md(dp,boxes,0,boxes.length-1);
    }
    public static int md(int[] dp,int[] boxes,int start,int n)
    {
        if(start<=n)
        {
            if(dp[start]!=0)
                return dp[start];
            else
                dp[start] = Math.max( (boxes[start] + md(dp,boxes,start+2,n)) , (md(dp,boxes,start+1,n)) );
            return dp[start];
        } 
        return 0;
    }
    
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int[] boxes = new int[n];
          for(int i=0;i<n;i++){
              boxes
          }
		  
	}	 
}        