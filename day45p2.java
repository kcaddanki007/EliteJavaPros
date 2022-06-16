/*Shakuni playing 'Paramapadasopanam' game with Dharamaraja.
Shakuni wants to win everytime. He has a boon that whenever he used to 
roll the dice, the dice roll to show his desired number. 

Rules
--------
The game is played with a cubic dice of 6 faces numbered 1 to 6.
And Paramapadasopanam of size N*N.
- Starting from square X = 1, reach the square N*N with some rolls of the dice 
- Once Shakuni roll the dice, he will land on one of the followin squares only
  X+1, X+2, X+3, X+4, X+5, X+6.
- If current value at position X is not equal to -1, then there is a ladder 
  or snake.
- If the position of X is at the base of a ladder, the player must climb 
  the ladder. Ladders go up only.
- If the position of X is at the mouth of a snake, the player must go down 
  the snake and come out through the tail. Snakes go down only.

You have to findout, what would be the least number of rolls required 
for shakuni to win.

Note:
Shakuni can only take a snake or ladder at most once per move: 
if the tail of a snake or ladder is the start of another snake or ladder, 
you do not continue moving.


Input Format:
-------------
Line-1: An integer n , size of Paramapadasopanam.
Next N lines: N space separated integers, either -1 or 
              an integer between 1 to n*n. 

Output Format:
--------------
Print an integer, least number of rolls required for shakuni to win.


Sample Input-1:
---------------
6
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 35 -1 -1 13 -1
-1 -1 -1 -1 -1 -1
-1 15 -1 -1 -1 -1

Sample Output-1:
----------------
4

Explanation: 
------------
At the beginning, you start at square 1.
Roll the dice to land at square 2, and must take the ladder to square 15.
Roll the dice to land at square 17, and must take the snake to square 13.
Roll the dice to land at square 14, and must take the ladder to square 35.
Roll the dice to land at square 36, Shakuni Won.
Total number of rolls are 4.
*/
import java.util.*;
import java.lang.*;
class day45p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int[] arr = new int[n*n];
		  for(int i=n-1;i>=0;i--){
		      for(int j=0;j<n;j++){
		          if(i%2==1){
		              arr[i*n+n-j-1] = sc.nextInt();
		          }else{
		              arr[i*n+j] = sc.nextInt();
		          }
		      }
		  }
		  System.out.println(BFS(arr,n*n));
		}
		static int BFS(int[] arr,int n){
		    ArrayDeque<Integer> adq = new ArrayDeque<>();
		    HashSet<Integer> set = new HashSet<>();
		    adq.add(0);
		    int count=0;
		    while(!adq.isEmpty()){
		        count++;
		        int adqsize = adq.size();
		        for(int i=0;i<adqsize;i++){
		            int ele = adq.pollFirst();
		            for(int j=1;j<=6;j++){
		                if(ele+j==n-1) return count;
		                if(set.contains(ele+j)) continue;
		                if(arr[ele+j]==-1){ 
		                    set.add(ele+j);
		                    adq.offerLast(ele+j);
		                }
		                else{
		                    set.add(arr[ele+j]-1);
		                    adq.offerLast(arr[ele+j]-1);
		                } 
		            }
		        }
		    }
		    return count;
		}
}     
 