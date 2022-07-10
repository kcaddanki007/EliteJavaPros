/*
You have given N bricks.
You need to construct a staircase as follows:
1. =
2. ==
3. ===
4. ====
Where = indicates one brick.
 
Another condition is row-1 should have 1 brick, row-2 should have 2 bricks and
so on.
i.e., i-th row should have 'i' bricks.
 
Your task is to findout total number of staircases can be formed with the given
condition.
 
Input Format:
-------------
 An integer N

Output Format:
--------------
Print an integers, number of staircases
 
 
Sample Input-1:
---------------
 5
 
Sample Output-1:
----------------
2

Explanation:
------------
row-1:	=
row-2:	==
row-3:	==
Only 2 rows satisfies the condition.
 
 
Sample Input-2:
---------------
 8
 
Sample Output-2:
----------------
3
 
Explanation:
------------
row-1:	=
row-2:	==
row-3:	===
row-4:	==
 
Only 3 rows satisfies the condition.
*/

//Use binary search 
import java.util.*;
import java.lang.*;
class day12p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int i =0;
          while(n>0){
              i++;
              n=n-i;
          }
          System.out.println(i-1);
	}	 
}        