/*Jason Statham is a well known transporter.
He transports goods from one place to other place using his container.
The container is divided into M*N slots, you can place M*N items in it.
In the container few slots are closed, you can't use them.
No other item can move from it.

When the items are loaded the container looks like an M*N grid, 
but to unload the items from the container it is turned 90-derees clockwise.
So, the Items in the container moves through the empty slots and set one on one.
If there is an closed slot, the items will be fall on the closed slot.

You will be given a matrix of size M*N, consists of 3 letters [I,O,S]
Where I indicates item, O indicates closed slot, S indicates empty slot.

Your task is to help Jason Stathamto know the positions of items, empty slots and 
closed slots after turning the container 90-degree clockwise.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the container
Next M lines: A string of length N, consists only 3 characters [I, O, S]

Output Format:
--------------
Print a charcter matrix of size N*M as described in sample.


Sample Input-1:
---------------
2 3
ISI
ISO

Sample Output-1:
----------------
SS
II
OI

Explanation:
------------
Look at hint for explanation.


Sample Input-2:
---------------
3 6
IIOSOS
IIIOSS
IIISIS

Sample Output-2:
----------------
SII
SII
IIO
IOS
ISO
ISS

Explanation:
------------
Look at hint for explanation.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] sdims = sc.nextLine().split(" ");
        int r = Integer.parseInt(sdims[0]);
        int c = Integer.parseInt(sdims[1]);
        char[][] inp = new char[r][c];
        for(int i=0;i<r;i++)
          inp[i] = sc.nextLine().toCharArray();
        truckFlip(inp,r,c);
    }
    static void truckFlip(char[][] inp,int r,int c){
        for(int i=0;i<r;i++){
            int lb = -1;
            while(true){
            int rb=lb+1;
            int countofi=0;
            while(rb<c && inp[i][rb]!='O'){
                if(inp[i][rb]=='I') countofi++;
                rb++;
            }
            int j=rb-1;
            while(countofi!=0){
                inp[i][j]='I';
                countofi--;
                j--;
            }
            while(j!=lb){
                inp[i][j] = 'S';
                j--;
            }
            lb=rb;
            if(rb==c) break;
            //System.out.println("infinite");
            }
            //System.out.println(Arrays.toString(inp[i]));
        }
        TransposeAndPrint(inp,r,c);
    }
    static void TransposeAndPrint(char[][] inp,int r,int c){
        char[][] transpose = new char[c][r];
        for(int i=0;i<r;i++)
         for(int j=0;j<c;j++) transpose[j][i] = inp[i][j];
        //System.out.println("entered");
        for(int i=0;i<c;i++){
            for(int j=r-1;j>=0;j--)
              System.out.print(transpose[i][j]);
            System.out.println();
        }
     }
}

