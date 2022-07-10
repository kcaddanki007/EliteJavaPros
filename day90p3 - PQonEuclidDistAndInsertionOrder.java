/*Mr Ashoka planted N trees in a land around the Flag Post which is at the center 
of the land, i.e., (0,0) position. You will be given the positions of N trees
as trees[], where tree[i]=[Xi,Yi], where Xi, Yi are the positions of i-th tree
with respect to X-axis and Y-axis. And you are also an integer C.

The distance between any two trees on the land plane is the Euclidean distance 
(i.e., sqrt((x1 - x2)^2 + (y1 - y2)^2).

Your task is to return positions of the C trees Nearest to the Flag post. 
The answer is supposed to be sorted based on distance, if the distances 
are same keep the original order of the trees[].


Input Format:
-------------
Line-1: Two space separate integers, N and C
Next N Lines: Two space separated integers, x,y

Output Format:
--------------
Print the positionf of C Nearest Trees.

Sample Input-1:
---------------
4 4
-3 -3
3 -3
3 3
-3 3

Sample Output-1:
----------------
[-3, -3] [3, -3] [3, 3] [-3, 3]


Sample Input-2:
---------------
4 3
2 -1
1 2
2 4
3 2

Sample Output-2:
----------------
[2, -1] [1, 2] [3, 2]
*/
import java.util.*;
class day90p3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] points = new int[n][3];
        for(int i=0;i<n;i++){
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            points[i][2] = i;
        }
        getKNearestPoints(points,n,k);
    }
    static void getKNearestPoints(int[][] points,int n,int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            double dista = Math.pow(a[0],2) + Math.pow(a[1],2);
            double distb = Math.pow(b[0],2) + Math.pow(b[1],2);
            if(dista==distb)
              return a[2]-b[2];
            else return (int)(dista-distb);
            });
            
        for(int i=0;i<n;i++)
            pq.offer(points[i]);
        
        for(int i=0;i<k;i++){
            int[] temp = pq.poll();
            int[] res = {temp[0],temp[1]};
            System.out.print(Arrays.toString(res)+" ");
        }
          
    }
}