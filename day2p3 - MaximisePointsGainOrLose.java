/*
You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. You need to play the game with the following rules:
 - Initially your score is  '0' points.
	- Suppose the box has p points in it.
	  if p>0 you will gain p points, if p<0 you will loose p points.
	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
   	
You are given the points in the N boxes as points[]. 
Your target is to maximize your score by droping atmost one box in the set of 
consecutive boxes, and return the highest score possible. 

Note : The score should be considered for atleast 1 box even after droping a box.
 
Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].
  
Output Format:
--------------
An integer, print the highest score.
    
Sample Input-1:
---------------
9
-3 1 -2 4 -2
2 3 -5 4
 
Sample Output-1:
----------------
 11
   
Explanation:
------------
By selecting consecutive boxes [4,-2,2,3,-5,4] and dropping -5 , has the highest
score is 11.
   
 
Sample Input-2:
---------------
 2
 1 -2
  
Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 1.

*/
import java.lang.*;
import java.util.*;

class day2p3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int f[] = new int[n];
        int b[] = new int[n];
        int maxele=-9999;
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
            maxele=Math.max(a[i],maxele);
        }
            f[0]=a[0];
            b[n-1] = a[n-1];
        for(int i=1;i<n;i++)
            f[i]=Math.max(a[i],a[i]+f[i-1]);
        for(int i=n-2;i>=0;i--)
            b[i]=Math.max(a[i],a[i]+b[i+1]);
        //System.out.println(Arrays.toString(f));
        //System.out.println(Arrays.toString(b));
        int max=-9999;
        for(int i=1;i<n-1;i++)
            max=Math.max(f[i-1]+b[i+1],max);
        System.out.println(max==-9999?maxele:max);
        
    }
}