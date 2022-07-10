/*There are N cities in a state.
The cities are connected with two types of roadways:
1) concrete roadway 2) asphalt roadway.
The roadways may be parallel.

You are given the lists of concrete roadways and asphalt roadways
between the cities. All roadways are unidirectional.
Concrete_Roadway[i,j] indiactes: a concrete road from city-i to city-j. Similarly,
Asphalt[i,j] indiactes: an asphalt road from city-i to city-j. Similarly,

Your task is to find and return the list of lengths of the shortest paths from 
city-0 to city-P, where P start from 0 to N-1. And the path should contains 
alternative roadways like as follows: concrete - asphalt - concrete -asphalt --etc
or vice versa. If there is no such shortest path exist print -1.

Input Format:
-------------
Line-1: 3 space separated integers N, C & A, Number of cities, routes between the cities.
		number of concrete roads and number of asphalt roads
Next C lines: Two space separated integers, concrete road between city-i to city-j.		
Next A lines: Two space separated integers, asphalt road between city-i to city-j.		

Output Format:
--------------
Print the list of lengths, the shortest paths.


Sample Input-1:
---------------
4 2 1
0 1
2 3
1 2

Sample Output-1:
----------------
0 1 2 3

Sample Input-2:
---------------
4 2 1
1 0
2 3
1 2

Sample Output-2:
----------------
0 -1 -1 -1


Sample Input-3:
---------------
4 3 2
1 0
1 2
2 3
0 1
1 2

Sample Output-3:
----------------
0 1 2 -1
*/
import java.util.*;
import javafx.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int a = sc.nextInt();
        int[][] cr = new int[c][2];
        int[][] ar = new int[a][2];
        for(int i=0;i<c;i++){
            cr[i][0] = sc.nextInt();
            cr[i][1] = sc.nextInt();
        }
        for(int i=0;i<a;i++){
            ar[i][0] = sc.nextInt();
            ar[i][1] = sc.nextInt();
        }
        int[] res = getShortestPath(n,c,a,cr,ar);
        for(int i : res)
          System.out.println((i==Integer.MAX_VALUE? -1:i)+" ");
    }
    static int[] getShortestPath(int n,int c,int a,int[][] cr,int[][] ar){
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        Map<Integer,List<Integer>> crmap = new HashMap<>();
        Map<Integer,List<Integer>> armap = new HashMap<>();
        
        for(int i=0;i<n;i++){
            crmap.put(i,new ArrayList<>());
            armap.put(i,new ArrayList<>());
        }
        
        for(int[] i : cr)
           crmap.get(i[0]).add(i[1]);
        for(int[] i : ar)
           armap.get(i[0]).add(i[1]);
           
        ArrayDeque<Pair<Integer,Integer>> adq = new ArrayDeque<>();
        adq.offer(new Pair(0,0));
        adq.offer(new Pair(0,1));
        Set<Pair<Integer,Integer>> vis = new HashSet<>();
        int count = 0;
        while(!adq.isEmpty()){
            int size = adq.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> p = adq.poll();
                vis.add(p);
                int node = p.getKey();
                int roadType = p.getValue();
                res[node] = Math.min(res[node],count);
                
                if(roadType==0){
                    for(int neighbor : crmap.get(node)){
                        Pair<Integer,Integer> temp= new Pair(neighbor,1);
                        if(!vis.contains(temp)) 
                           adq.offer(temp);
                    }
                }else{
                    for(int neighbor : armap.get(node)){
                        Pair<Integer,Integer> temp = new Pair(neighbor,0);
                        if(!vis.contains(temp))
                           adq.offer(temp);
                    }
                }
            }
            count++;
        }
        return res;
    }
}