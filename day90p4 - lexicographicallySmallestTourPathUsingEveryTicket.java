/*Gopal would like to go on Tour, and planned a schedule.
Airport authority has created a new way of issuing tickets.
Gopal purchased a set of airline tickets, 
each ticket contains the 'departure from' and 'arrival to'.

Redesign the Gopal's tour schedule in an order.
Gopal intially must begin his tour from BZA.
Hence the tour schedule's start point should begin with BZA. 

You are given a list of flight tickets which Gopal has purchased.
Your task is to find out and return the tour schedule that has the least 
lexical order. Gopal must use all the tickets once and only once.

Note:
------
If there are multiple valid schedules, you should return the schedule 
that has the smallest lexical order when read as a single string. 
For example, the schedule ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid schedule.

Input Format:
-------------
Single Line of tickets separated by comma, and each ticket separated by space, 
Gopal's flight tickets.

Output Format:
--------------
Print the schedule, which is smallest lexical order of tour schedule.


Sample Input-1:
----------------
DEL HYD,BZA DEL,BLR MAA,HYD BLR

Sample Output-1:
--------------------
[BZA, DEL, HYD, BLR, MAA]


Sample Input-2:
------------------
BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

Sample Output-2:
------------------
[BZA, BLR, CCU, BZA, CCU, BLR]
*/
import java.util.*;
class Solution{
    static Map<String,List<String>> adjlist = new HashMap<>();
    static List<String> res = new ArrayList<>();
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] tickets = sc.nextLine().split(",");
        n = tickets.length;
        getSmallestTrip(tickets);
    }
    static void getSmallestTrip(String[] tickets){
        for(int i=0;i<tickets.length;i++){
            String[] ticket = tickets[i].split(" ");
        
            if(!adjlist.containsKey(ticket[0])) 
                adjlist.put(ticket[0],new ArrayList<>());
            adjlist.get(ticket[0]).add(ticket[1]);
        }
        
        for(Map.Entry<String,List<String>> e : adjlist.entrySet()){
            Collections.sort(e.getValue());
        }
        //System.out.println(adjlist);
        backtrack("BZA",0);
    }
    static void backtrack(String src,int level){
        //System.out.println(res);
        int currsize = res.size();
        if(currsize==level) res.add(src);
        else{
            res.set(level,src);
            // for(int i=currsize-1;i>=level;i--)
            // res.remove(i);
    
            // res.add(src);
        } 
        
        if(level==n){ 
            System.out.println(res);
            System.exit(0);
        }
        
        if(!adjlist.containsKey(src)) return;
        int size = adjlist.get(src).size();
        if(size==1){
            String dest = adjlist.get(src).remove(0);
            adjlist.remove(src);
            backtrack(dest,level+1);
            adjlist.put(src,new ArrayList<>());
            adjlist.get(src).add(dest);
        }else{
            for(int i=0;i<size;i++){
                String dest = adjlist.get(src).remove(i);
                backtrack(dest,level+1);
                adjlist.get(src).add(i,dest);
            }
        }
        
    }
}