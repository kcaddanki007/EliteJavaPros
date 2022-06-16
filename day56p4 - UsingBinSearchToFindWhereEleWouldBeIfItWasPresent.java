/*
Indian Super League organizing a football match at Eden Gardens.
The teams are Bangalore and Chennai are playing opposite each other.

After Match starts, each team making some goals at certain time, 
for example, goal 'goal[i]' was made by a player at time 'time[i]'.
goal[i]: indicates the team number 0 (Bangalore) or 1 (Chennai).
time[i]: indicates the time of the goal made.

Now, your task is to find out the leading team at given time t[j].

Input Format:
------------------
Line-1: Two integers N and K, no of goals-> goal[i] and no of times-> t[j]
Line-2: N space seperated integers only 0's and 1', goals[i]
Line-3: N space seperated integers, time[i]
Line-4: K space seperated integers , t[i]
 
Output Format:
------------------
Print K space seperated integers as result.


Sample Input-1:
---------------
7 5
0 1 1 0 0 1 0
0 5 10 15 20 25 30
3 12 25 15 24

Sample Output-1:
----------------
0 1 1 0 0

Explanation:
------------
At time 3, the goals are [0], and 0 is leading.
At time 12, the goals are [0,1,1], and 1 is leading.
At time 25, the goals are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent goal)
At time 15, the goals are [0,1,1,0], and 0 is leading (as ties go to the most recent goal)
At time 24, the goals are [0,1,1,0,0], and 0 is leading.
*/
import java.util.*;
class day56p4{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int k = sc.nextInt();
		  int[] goals = new int[n];
		  for(int i=0;i<n;i++) goals[i] = sc.nextInt();
		  int[] times = new int[n];
		  for(int i=0;i<n;i++) times[i] = sc.nextInt();
		  int[] quer = new int[k];
		  for(int i=0;i<k;i++) quer[i] = sc.nextInt();
		  System.out.println(Arrays.toString(getRes(n,k,goals,times,quer)));
		}
		static int[] getRes(int n,int k,int[] goals,int[] times,int[] quer){
		    int[] res = new int[k];
		    int[] lead = new int[n];
		    int t0=0,t1=0;
		    for(int i=0;i<n;i++){
		        if(goals[i]==0) t0++;
		        else t1++;
		        if(t0>t1 || (t0==t1 && goals[i]==0)) lead[i]=0;
		        else lead[i] = 1;
		    }
		    
		    for(int i=0;i<k;i++){
		        int low=0,high=n-1;
		        while(low<high){
		            int mid=(low+high)/2;
		            if(times[mid]>=quer[i]) high=mid;
		            else low = mid+1;
		        }
		        res[i] = (times[low]>quer[i])? lead[low-1]:lead[low];
		    }
		   return res;
		}
}     


 