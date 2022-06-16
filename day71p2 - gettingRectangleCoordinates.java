/*Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in 
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate 
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of 
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1
 
Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1
 
Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        
        for(int i=0;i<m;i++)
          for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
          
        getCoordinatesOfRect(arr,m,n);
    }
    static void getCoordinatesOfRect(int[][] arr,int m,int n){
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]>0){
                    List<Integer> val = new ArrayList<>();
                    val.add(i); val.add(j);
                    int ti=i,tj=j;
                    
                    while(ti<m && arr[ti][j]==1) ++ti;
                    
                    --ti;
                    
                    while(tj<n && arr[i][tj]==1) ++tj;
                    
                    --tj;
                    
                    val.add(ti);val.add(tj);
                    for(int x=i;x<=ti;x++) Arrays.fill(arr[x],j,tj+1,0);
                    //for(int x=0;x<m;x++) System.out.println(Arrays.toString(arr[x]));
                    //System.out.println();
                    res.add(val);
                }
            }
        }
        
        for(List<Integer> l : res){
            System.out.print(l);
        }
    }
}