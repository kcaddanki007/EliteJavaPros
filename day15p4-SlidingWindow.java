/*There are N players, played a game.
You are given the scores of the N players as scores[] array,
where i-th player score is score[i].
You are given P chances to modify the score of the players.

In each chance you can modify the score of i-th player as follows:
	- You are allowed increment the score of i-th player by 1.
You have to perform these increments, in order to maximize the occurences of any score.

Your task is to maximize occurences of a score, after utlizing atmost P chances.

Input Format:
-------------
Line-1: Two space separated integers N and P, Players count, and number of chances.
Line-2: N space separated integers, scores of N players scores[].

Output Format:
--------------
Print an integer, maximum occurences of a score!


Sample Input-1:
---------------
5 3
2 3 5 6 9

Sample Output-1:
----------------
2


Sample Input-2
---------------
6 5
2 3 4 6 8 9

Sample Output-2:
----------------
3
*/
import java.util.*;
import java.lang.*;
class day15p4{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int p = sc.nextInt();
		  int[] arr = new int[n];
		  
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  
		  System.out.println(getMaxOccurence(arr,n,p));
		}
		
		static int getMaxOccurence(int[] arr, int n, int p){
		    if(n<=1) return n;
		    int window = p;
		    Arrays.sort(arr);
		    int sum=0;
		    int ans=0;
		    int start=0,end;
		    
		    for(end=0;end<n;end++){
		        sum+=arr[end];
		        while((end-start+1)*arr[end] - sum > p){
		            sum -= arr[start];
		            start++;
		        }
		        ans = Math.max(ans,end-start+1);
		    }
		    return ans;
		}
}        

/*while(window>1){
		        int sum = 0;
		        System.out.println("Window size = "+window);
		        for(int i=0;i+window-1<n;i++){
		            int min = Integer.MAX_VALUE;
		            for(int j=i;j<i+window;j++) min = Math.min(min,arr[j]);
		            
		            for(int j=i;j<i+window;j++) sum = sum + (arr[j]-min);
		            System.out.println("Sum"+sum);
		        if(sum<=p) return window;
		        sum = 0;
		        }
		    window--;
		        
		    }
		    return 1;*/