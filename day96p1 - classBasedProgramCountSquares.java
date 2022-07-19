/*Few people are playing Dart Game, where dartboard is square in shape with size,
100*100, bottom left corner is [0,0] and top right corner is [99,99].

The game is played as follows:
There are two operations in this game,
 1- Once the player throws the dart, we will record the hit position as [x,y] 
    in a list.
 2- We will select one check point, and checks the number of ways to choose 
    three points from the recorded list, such that the three points and 
    the check point form a square with positive area

NOTE: A edges of the square are all the same length and are either parallel 
      or perpendicular to the left border and bottom border of the board.

Your task is to implement the following:

create a class "CountSquares", and the methods in it are,
    public void record(int[] hit) : record the dart position on the board.
    public int count(int[] check) : return the number of sqaures possible.


Input Format:
-------------
Line-1: Space separated integers, Operations[], only 1's and 2's.
        1 indiactes record the position, 2 indicates count the squares.
Line-2: Comma separated positions, each postions is two space separated
        integers, Dart position or Check point.

Output Format:
--------------
Print the space separated integers, count of squares for each Operation-2.


Sample Input-1:
---------------
1 1 1 2 2 1 2
3 10,11 2,3 2,11 10,14 8,11 2,11 10

Sample Output-1:
----------------
1 0 2

Explanation: 
------------
Look at the hint for understanding.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] oper = sc.nextLine().split(" ");
        String[] coord = sc.nextLine().split(",");
        CountSquares cs = new CountSquares();
        for(int i=0;i<oper.length;i++){
            int[] coords = new int[2];
            coords[0] = Integer.parseInt(coord[i].split(" ")[0]);
            coords[1] = Integer.parseInt(coord[i].split(" ")[1]);
            if(oper[i].equals("1")){
                cs.record(coords);
            }else{
                System.out.print(cs.count(coords)+" ");
            }
        }
    }
}
class CountSquares{
    Map<String,Integer> positions;
    
    CountSquares(){
        positions = new HashMap<>();
    }
    
    public void record(int[] coords){
        String cord = coords[0]+" "+coords[1];
        positions.put(cord,positions.getOrDefault(cord,0)+1);
    }
    
    public int count(int[] coords){
        int x1 = coords[0];
        int y1 = coords[1];
        int count = 0;
        for(String diag : positions.keySet()){
            int x2 = Integer.parseInt(diag.split(" ")[0]);
            int y2 = Integer.parseInt(diag.split(" ")[1]);
            if(Math.abs(x2-x1)!=Math.abs(y2-y1) || x1==x2 || y2==y1) continue;//not diagonal
            String c1 = x1+" "+y2;
            String c2 = x2+" "+y1;
            if(positions.containsKey(c1) && positions.containsKey(c2)){
                count += positions.get(c1)*positions.get(c2)*positions.get(diag);
            }
        }
        return count;
    }
}
