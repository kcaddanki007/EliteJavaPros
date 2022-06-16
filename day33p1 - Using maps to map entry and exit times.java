/*In Dubai's Burj Khalifa, there is an elevator moves only in upwards direction, 
the elevator can carry N members.

The people are waiting for the elevator at different floors, made P requests, 
request[i] = [ num_people, enter_floor, exit_floor ], each request indicates, 
number of people to enter into elevator, entering floor number, 
exiting floor number.

Initially the elevator is empty.

Your task is to find and return true, iff it is possible to enter the people
into elevator and exit from elevator of all the requests made by the people.


Input Format:
-------------
Line-1 -> Two integers P and N, number of requests and number of members 
          can be carried by elevator.
Next N Lines -> three space separated integers, num_people, enter_floor, exit_floor.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true



Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false



Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true
*/

import java.util.*;
import java.lang.*;
class day33p1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int n = sc.nextInt();
		int[][] reqs= new int[p][3];
		int max=0;
		for(int i=0;i<p;i++){
		    reqs[i][0] = sc.nextInt();
		    reqs[i][1] = sc.nextInt();
		    reqs[i][2] = sc.nextInt();
		}
		System.out.println(canSend(p,n,reqs));
		}
		
		static boolean canSend(int p, int n, int[][] reqs){
		    Arrays.sort(reqs, (a, b) -> Integer.compare(a[1],b[1]));
		    
		    HashMap<Integer,Integer> map = new HashMap<>();
		    
		    for(int i=0;i<p;i++){
		        map.put(reqs[i][2],map.getOrDefault(reqs[i][2],0)+reqs[i][0]);
		    }
		    
		    //System.out.println(map);
		    
		    int cntinlift=0;
		    for(int i=0;i<p;i++){
		        
		        cntinlift+=reqs[i][0];
		        
		        for(int j= (i==0)? 1:reqs[i-1][1];j<=reqs[i][1];j++){
		            if(map.containsKey(j)){
		                cntinlift-=map.get(j);
		                map.put(j,0);
		            }
		        }
		        
		        //System.out.println(map);
		        if (cntinlift>n) return false;
		    }
		    return true;
		}
}   