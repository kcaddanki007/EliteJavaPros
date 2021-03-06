/*
Tribhuvan das checking his luck in diamonds.There are N boxes in a row and each
box has a number of diamonds in it. box[i] is the number of diamonds in ith
box(0-indexed).
Tribhuvan das can select the boxes to get the diamonds. But there is a condition 
that he cannot choose the boxes which are adjacent.
Help Tribhuvan das to get maximum diamonds.

Input Format:
-------------
Line-1: An Integer N represents number of boxes.
Line-2: N space separated integers represents diamonds in each box.
  
Output Format:
--------------
Print an integer.

Constraints:

    1 <= N <= 100
    0 <= box[i] <= 400

   
 Sample Input-1:
 ---------------
4
5 10 25 21
  
Sample Output-1:
----------------
31

Explanation:
------------
He can select either 5+25 or 10+21 or 5+21.
The maximum is 31.
   
Sample Input-2:
---------------
3
20 30 40

  
 Sample Output-2:
 ----------------
60

Explanation:
------------
He can select either 20+40 or 30.
The maximum is 60.


*/
class Test{
    int maxDiamonds(int boxes[]){
        //Implement Your code here
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
}