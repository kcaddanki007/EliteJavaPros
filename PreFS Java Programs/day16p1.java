/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.
*/


import java.util.*;
import java.lang.*;
class day16p1{

        static int find_set(int[] parent,int v) {
            if (v == parent[v])
                  return v;
            return parent[v] = find_set(parent, parent[v]);
        }

        static void union_sets(int[] parent,int a, int b) {
            int pa = find_set(parent, a);
            int pb = find_set(parent, b);
                if (pa < pb)
                      parent[pb] = pa;
                else if(pa > pb)     
                      parent[pa] = pb;
            }

        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          
          int n = sc.nextInt();
		  int m = sc.nextInt();
		  int[] parent = new int[n];
		  Set<Integer> set = new HashSet<>();
		  
		  for(int i=0;i<n;i++){
			parent[i]=i;
	      }	 
		  
		  for(int j=0;j<m;j++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			union_sets(parent,a,b);
          }      
		  
		  for(int i=0;i<n;i++){
			set.add(find_set(parent, i));
		  }
		  
		  System.out.println(set.size());

		}
}

