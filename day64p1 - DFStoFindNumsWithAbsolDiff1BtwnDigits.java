/*Mr Febin is working with numbers.
He wants to find all the AD Numbers,
An AD Number is defined as follows:
	- All the adjacent digits in the given number N 
	should have an absolute difference of 1 only. 

You will be given two integers, start and end,
Your task is to find all the AD Numbers in ascending order
in the range of [start, end], where both are inclusive.

Constarint:
----------
0 <= start < end <2*10^9.

Input Format:
-------------
Two space separated intergers,  start and end.

Output Format:
--------------
Print a list of integers.


Sample Input-1:
---------------
0 15

Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]


Sample Input-2:
---------------
25 65

Sample Output-2:
----------------
[32, 34, 43, 45, 54, 56, 65]
*/
import java.util.*;
class Solution{
    static TreeSet<Integer> res = new TreeSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        getADs(start,end);
        System.out.println(res);
    }
    static void getADs(int start,int end){
        for(int i=0;i<10;i++){
            DFS(i,start,end);
        }
    }
    static void DFS(int ele,int start,int end){
        if(ele>end) return;
        if(ele<start){
            if(ele%10==0){
                DFS(ele*10+1,start,end);
                return;
            }
            else if(ele%10==9){
                DFS(ele*10+8,start,end);
                return;
            }
            DFS(ele*10 + (ele%10-1),start,end);
            DFS(ele*10 + (ele%10+1),start,end);
            return;
        }
        res.add(ele);
        if(ele%10==0){
                DFS(ele*10+1,start,end);
                return;
            }
            else if(ele%10==9){
                DFS(ele*10+8,start,end);
                return;
            }
            DFS(ele*10 + (ele%10-1),start,end);
            DFS(ele*10 + (ele%10+1),start,end);
            return;
    }
    
}