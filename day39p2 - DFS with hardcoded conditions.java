/*A device is secured with a digital screen, 
The digital screen is made up of a 3*3 grid like below:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |

The code is generated by connecting the keys in a valid way using the grid.

Rules to create the valid codes are as follows:
	- Each code must consist of atleast m keys and atmost n keys.
	- All the keys must be distinct.
	- If the line connecting two consecutive keys 'A','B' in the code passes 
	  through any other key C, then 'C' must have already connected priorly, 
	  as a part of the code. No jumps through a key which is not part of 
	  the code are allowed.
	- The order of keys used matters.
 
You will be given two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
Your task is to count the total number of valid codes can be created to 
sefeguard the device, which consist of minimum of m keys and maximum n keys. 

Examples of valid and invalid codes:
	Invalid code: 1 - 2 - 7 - 9
	Line 7 - 9, passes through key 8 which has not been part of the code.
	i.e., 1 - 2 - 7 - 9 - 8 is also an invalid code.

	Invalid code: 1 - 8 - 3 - 7
	Line 3 - 7 passes through key 5 which has not been part of the code.

	Valid code: 5 - 7 - 4 - 6 - 9   
	Line 4 - 6 is valid because it passes through key 5, which has been part 
	of the code

	Valid code: 4 - 5 - 6 - 3 - 7 - 2
	Line 3 - 7 is valid because it passes through key 5, which has been part 
	of the code

Input Format:
-------------
Two space separated integers M and N.

Output Format:
--------------
Print an integer, number of valid codes created using the digital screen.


Sample Input-1:
---------------
1 1

Sample Output-1:
----------------
9


Sample Input-2:
---------------
1 2

Sample Output-2:
----------------
65
*/
import java.util.*;
import java.lang.*;
class day39p2{
        static int[][] skips = new int[10][10];
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int m = sc.nextInt();
		  int n = sc.nextInt();
		  skips[1][3] = skips[3][1] = 2;
		  skips[1][7] = skips[7][1] = 4;
		  skips[3][9] = skips[9][3] = 6;
		  skips[7][9] = skips[9][7] = 8;
		  skips[1][9] = skips[9][1] = skips[2][8] = skips[8][2] = skips[3][7] = skips[7][3] = skips[4][6] = skips[6][4] = 5;
		  boolean[] vis = new boolean[10];
		  int ans=0;
		  for(int i=m;i<=n;i++){
		      ans += DFS(skips,vis,1,i-1)*4;
		      ans += DFS(skips,vis,2,i-1)*4;
		      ans += DFS(skips,vis,5,i-1);
		  }
		  System.out.println(ans);
		}
		static int DFS(int[][] skips,boolean[] vis,int cur,int rem){
		    if(rem==0) return 1;
		    vis[cur] = true;
		    int res=0;
		    for(int i=1;i<=9;i++){
		        if(!vis[i] && (skips[cur][i]==0 || vis[skips[cur][i]])){
		            res+= DFS(skips,vis,i,rem-1);
		        }
		    }
		    vis[cur] = false;
		    return res;
		}
} 