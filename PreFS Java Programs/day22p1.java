/*
Sharath is playing a game where there are N levels. Inorder to win the game he 
has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4



*/
import java.util.*;
class Solution {
    //static Map<Integer, Integer> nums = new HashMap<>();
    public int crossLevel(int n) {
        //Implement Your Code here
         if(n<=2){
            return n;
        }
         int[] arr = new int[n+1];
         arr[0] = 1;
         arr[1] = 1;
         int key=n;
         for(int i=2;i<=n;i++){
             arr[i]=arr[i-1]+arr[i-2];
         }
         return arr[n];
		
        //return crossLevel(n-1)+crossLevel(n-2);
        
        /*if(!nums.containsKey(n)){
            nums.put(n,crossLevel(n-1)+crossLevel(n-2));
        }
        return nums.get(n);*/
    }
}