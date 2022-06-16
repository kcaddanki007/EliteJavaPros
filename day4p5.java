/*Mr Sudhakar is given a checkerboard of size 400*400, where the indices starts 
from (-200,-200) and ends at (199,199). In one step, he can move the box from 
position (p,q) to one of the following positions in L shape like as follows: 
	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

Initially the box is at (0,0) position, and need to move the box to position (m,n).
You will be given two integers m and n indicates the position(m,n).

Now your task is to help by Mr Sudhakar to find the minimum number of steps 
required to move the box from (0,0) to (m,n).

Note: It is allowed to move out of the board also.

Input Format:
-----------------
Two space separated integers, m and n, position.

Output Format:
------------------
Print an integer, minimum number of steps to reach (m,n).


Sample Input-1:
---------------
2 4

Sample Output-1:
----------------
2

Explanation:
-------------
Initially, you are at (0,0) position, you can reach (2,4) as follows:
(0,0) -> (1, 2) -> (2, 4) 


Sample Input-2:
---------------
4 7

Sample Output-2:
----------------
5

Explanation:
------------
Initially, you are at (0,0) position, you can reach (4,7) as follows:
(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)
*/

import java.util.*;
import java.lang.*;
//BFS
class day4p5{
     
     static HashMap<String,Integer> memo = new HashMap<>();
     
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		 
		 System.out.println(dfs(m,n));
		 
        }
		static int dfs(int x,int y){
		    x=Math.abs(x);
		    y=Math.abs(y);
		    
		    String key = x+","+y;
		    
		    if(memo.containsKey(key))
		       return memo.get(key);
		    else if(x+y == 0)
		        return 0;
		    else if(x+y == 2)
		        return 2;
		    else{
		        Integer ret = Math.min(dfs(x-1,y-2),dfs(x-2,y-1))+1;
		        memo.put(key,ret);
		        return ret;
		}
		
		}
}        

