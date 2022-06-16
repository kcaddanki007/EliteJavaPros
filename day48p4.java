/*In a game, There are N boxes in a Queue.
Each box conatins few gold coins in it.

Yash and Dutt are playing the game.

Game rules are as follows:
	- Initially, Yash picks one of the box from either end of the Queue.
	- Then, Dutt picks one of the box from either end of the Queue.
	- Repeat the first and second steps until the Queue become empty. 
The person with the maximum amount of gold coins is the winner.

You are given N boxes of gold coins, coins[].
Your task is to find the name of the winner either Yash or Dutt. 

Input Format:
-------------
Line-1: An integer N
Line-2: N space separated integers coins[].

Output Format:
--------------
Print the name of the winner, Yash / Dutt


Sample Input-1:
---------------
3
2 6 3

Sample Output-1:
----------------
Dutt

Explanation: 
------------
Initially, Yash can choose between 2 and 3.
If he chooses 3 (or 2), then Dutt can choose from 2 (or 3) and 5. If player 2 chooses 5, then
Yash will be left with 2 (or 3).
So, final score of Yash is 3 + 2 = 5, and Dutt is 6.
Hence, Dutt is the winner.

Sample Input-2:
---------------
4
2 6 50 7

Sample Output-2:
----------------
Yash
*/
import java.util.*;

class day48p4{
    static HashMap<String,Integer> hm;
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        hm = new HashMap<>();
        for(int i=0;i<n;i++) nums[i] = s.nextInt();
        String Winner = "";
        Winner = (yashWins(nums,n))?("Yash"):("Dutt");
        System.out.println(Winner);
    }
    
    public static boolean yashWins(int[] nums,int n){
        int sum=0;
        for(int i=0;i<n;i++) sum += nums[i];
        int ans = maxScore(nums,0,n-1);
        return (sum-ans>=ans)?(false):(true);
    }
    
    public static int maxScore(int[] nums,int i,int j){
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(hm.containsKey(i+"|"+j)) return hm.get(i+"|"+j);
        else{
            int choice1 = nums[i] + Math.min(maxScore(nums,i+1,j-1),maxScore(nums,i+2,j));
            int choice2 = nums[j] + Math.min(maxScore(nums,i+1,j-1),maxScore(nums,i,j-2));
            hm.put(i+"|"+j,Math.max(choice1,choice2));
        }
        return hm.get(i+"|"+j);
    }
}