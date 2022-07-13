/*There are a series of boxes and each box is labelled with a number.
Your task is to find the subsets of boxes such that addition of all 
the numbers written on each box makes an odd number.

Return only the number of such subsets exist.
Since the answer can be very large, return it modulo 10^9 + 7.

Input Format:
-------------
Line-1: an integer n represents the number of boxes
Line-2: n space seperated integers represents the numbers on the boxes.

Output Format:
--------------
return an integer represents number of subsets.

Sample Input-1:
---------------
3
1 5 7

Sample Output-1:
----------------
4

Explanation:
------------
subsets with odd sum are [1],[5],[7],[1,5,7].

Sample Input-2:
---------------
4
2 3 4 5

Sample Output-2:
----------------
6

Explanation:
-------------
subsets with odd sum are [3],[5],[2,3],[3,4],[4,5],[2,3,4].

*/import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
           if(arr[i]%2==1) count++;
        }
        for(int i=2;i<=n;i++)
           count+=getCount(arr,i);
        System.out.println(count);
    }
    static int getCount(int [] arr,int size){
        int count=0,sum=0;
        for(int i=0;i<size;i++)
          sum+=arr[i];
        for(int i=size;i<arr.length;i++){
            if(sum%2==1)
              count++;
            sum -= arr[i-size];
            sum+= arr[i];
        }
        if(sum%2==1) count++;
        return count;
    }
}

