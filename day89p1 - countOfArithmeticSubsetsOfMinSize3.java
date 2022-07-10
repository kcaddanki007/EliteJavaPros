/*There are n boxes of balls in a row, every i-th box contains balls[i] balls.

A series of boxes is called Arithmetic, if it consists of at least three boxes
and if the difference between the number of balls in any two consecutive boxes is same.

A subset of boxes is called Arithmetic Subset,
if subset[i], subset[i+1], subset[i+2], ..., subset[j] is Arithmetic.

Your task is to findout the number of Arithmetic Subsets in the row of boxes.

Input Format:
-------------
Line-1 : An integer N, number of boxes.
Line-2 : N space separated integers balls[i], i-th box contains balls[i] balls. 

Output Format:
--------------
Print an integer, number of Arithmetic Subsets.


Sample Input:
---------------
4
1 2 3 4

Sample Output:
----------------
3

Explanation:
------------
Arithmetic Subsets are: [1,2,3], [2,3,4], [1,2,3,4].


Sample Input:
---------------
5
1 3 5 7 9

Sample Output:
----------------
6

Explanation:
------------
Arithmetic Subsets are: [1,3,5], [3,5,7], [5,7,9], [1,3,5,7], [3,5,7,9], [1,3,5,7,9].

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getCountOfArithmeticSubset(arr,n));
    }
    static int getCountOfArithmeticSubset(int[] arr,int n){
        int difflen = n-1;
        int[] diff = new int[difflen];
        for(int i=0;i<difflen;i++)
          diff[i] = arr[i+1]-arr[i];
        
        int[] memo = new int[difflen];
        memo[0] = 0;
        int res = 0;
        for(int i=1;i<difflen;i++){
            if(diff[i]==diff[i-1]){
                memo[i] = 1+memo[i-1];
                res+=memo[i];
            }else{
                memo[i]=0;
            }
        }
		return res;
    }
}