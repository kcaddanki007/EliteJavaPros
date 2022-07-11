/*A graduate at University of California (UoC) has to follow certain rules.

UoC offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi], 
which specifies you must take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take 
to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[][] conditions = new int[c][2];
        for(int i=0;i<c;i++){
            conditions[i][0] = sc.nextInt();
            conditions[i][1] = sc.nextInt();
        }
        System.out.println(topologicalSort(n,c,conditions));
    }
    static List<Integer> topologicalSort(int n,int c,int[][] conditions){
        int[][] graph = new int[n][n];
        int[] indeg = new int[n];
        Map<Integer,List<Integer>> adjlist = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<c;i++){
            int dest = conditions[i][0];
            int src = conditions[i][1];
            if(!adjlist.containsKey(src))
               adjlist.put(src,new ArrayList<>());
            adjlist.get(src).add(dest);
            indeg[dest]++;
        }
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        
        for(int i=0;i<n;i++)
           if(indeg[i]==0)
              adq.offer(i);
              
        while(!adq.isEmpty()){
            int node = adq.poll();
            res.add(node);
            if(!adjlist.containsKey(node)) continue;
            for(int adj : adjlist.get(node)){
                --indeg[adj];
                if(indeg[adj]==0)
                adq.offer(adj);
            }
        }
        
        if(res.size()==n) return res;
        else return new ArrayList<>();
        
    }
}