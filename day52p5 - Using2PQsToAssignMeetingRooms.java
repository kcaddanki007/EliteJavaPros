/*A company ABC has scheduled online interviews for N candidates, candidates are
indexed from 0 to N-1. The interview panel has set up infinity meeting links
to conduct the interviews, each meeting link is numbered from 0 to infinity. 
The panel has scheduled interviews for candidates as follows, 
the ith-candidate's interview is scheduled at schedule[i]=[start, end], 
where 'start' is the start time and 'end' is the end time of the interview. 
The start times of interviews are unique.

When a candidate tries to attend the interview, then the candidate 
will be assigned an available meeting link with the lowest number 
to join the interview. For example, if meeting link-0, meeting link-1, 
meeting link-4, and meeting link-5 are busy, then the meeting link-2 will 
be assigned to the next candidate who attends the interview. 
Once the interview is completed, then that meeting link is free 
and can be assigned to the next candidate who attends the interview 
at the same time or later.

You are given the schedule of the interviews of N candidates, schedule[N][2], 
and the candidate number C. Your task is to return the lowest meeting link 
number that the candidate-C can attend.

Input Format:
-------------
Line-1: Two space separated integers N and C, number of candidates 
        and candidate number.
Next N lines: Two space separated integers start and end, the schedule of 
              each candidate's interview.

Output Format:
--------------
Return an integer output.

Sample Input-1:
---------------
3 1 // N and C
2 5	// Schedule
3 4
5 7

Sample Output-1:
----------------
1

Explanation: 
------------
- Candidate-0's interview starts at time 2 and attends using meeting link-0.
- Candidate-1's interview starts at time 3 and attends using meeting link-1.
- Candidate-1's interview ends at time 4 and meeting link-1 is free.
- Candidate-0's interview ends at time 5 and meeting link-0 is free.
- Candidate-2's interview starts at time 5 and attends using meeting link-0.
Since Candidate-1 attended the interview using meeting link-1, return 1.


Sample Input-2:
---------------
3 1 // N and C
2 9	// Schedule
0 4
1 5

Sample Output-2:
----------------
0

Explanation: 
------------
- Candidate-1's interview starts at time 0 and attends using meeting link-0.
- Candidate-2's interview starts at time 1 and attends using meeting link-1.
- Candidate-0's interview starts at time 2 and attends using meeting link-2.
- Candidate-1's interview ends at time 4 and meeting link-0 is free.
- Candidate-2's interview ends at time 5 and meeting link-1 is free.
- Candidate-0's interview ends at time 9 and meeting link-2 is free.
Since Candidate-1 attended the interview using meeting link-0, return 0.
*/
import java.util.*;
class day52p5{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int c = sc.nextInt();
		  int[][] schedule = new int[n][2];
		  for(int i=0;i<n;i++){
		      schedule[i][0] = sc.nextInt();
		      schedule[i][1] = sc.nextInt();
		  }
		  System.out.println(getLink(schedule,n,c));
        }
        static int getLink(int[][] schedule,int n,int c){
            Queue<int[]> start = new PriorityQueue<>((a,b)->a[0]-b[0]);
            Queue<int[]> link = new PriorityQueue<>((a,b)->a[0]-b[0]);
            
            for(int i=0;i<n;i++) start.offer(schedule[i]);
            
            //System.out.println(Arrays.toString(start.peek()));
            int count=0;
            while(!start.isEmpty() && start.peek()[0]!=schedule[c][0]){
                int bef[] = start.poll();
                if(!link.isEmpty() && link.peek()[0]<=bef[0]){
                    int[] remove = link.poll();
                    link.offer(new int[]{bef[1],remove[1]});
                }else{
                    link.offer(new int[]{bef[1],count});
                    count++;
                }
            }
            int bef[] = start.poll();
                if(!link.isEmpty() && link.peek()[0]<=bef[0]){
                    int[] remove = link.poll();
                    return remove[1];
                }else{
                    return count;
                }
        }
}     