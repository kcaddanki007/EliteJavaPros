/*Given a sorted list of integers E[], and two integers  L and U
Where L <= E[i]  <= U.

Your task is to find the ranges, which are not present in the given list
and print all the ranges

For example:
Given list is [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95 ] and L=1 U=100: 
The ranges which are not present are [3, 5->50, 54->91, 96->100]

Note: List E contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of ranges.


Sample Input-1:
---------------
0 1 2 3 4 5 8 9 10
0 20

Sample Output-1:
----------------
[6->7, 11->20]


Sample Input-2:
---------------
1 2 4 51 52 53 92 93 94 95
1 100

Sample Output-2:
----------------
[3, 5->50, 54->91, 96->100]
 
*/
import java.util.*;
import java.lang.*;
class day50p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String[] stringnums = sc.nextLine().split(" ");
          int n = stringnums.length;
          int[] arr = new int[n+2];
          for(int i=1;i<n+1;i++) arr[i] = Integer.parseInt(stringnums[i-1]);
          int l=sc.nextInt();
          int u=sc.nextInt();
          arr[0] = l-1;
          arr[n+1] = u+1;
          //System.out.println(Arrays.toString(arr));
          System.out.println(getRanges(arr,n));
		}
		static ArrayList<String> getRanges(int[] arr,int n){
		    ArrayList<String> al = new ArrayList<>();
		    for(int i=1;i<n+2;i++){
		            if(arr[i]-arr[i-1]==2) al.add(Integer.toString(arr[i-1]+1));
		            else if(arr[i]-arr[i-1]>2) al.add((arr[i-1]+1)+"->"+(arr[i]-1));
		    }
		    return al;
		}
}     
 