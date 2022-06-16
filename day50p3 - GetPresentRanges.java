/*Given a sorted list of integers, 

Your task is to find the continuous range of numbers, make them as groups
and print all the groups as show in the sample testcases.

For example:
Given list is [ 1, 2, 3 ]: 1, 2, 3 is continuous range, grouped as 1->3
Given list is [ 1, 2, 4, 5, 7 ]: 1, 2 is continuous range, grouped as 1->2, 
4,5 grouped as 4->5, 7 is left alone.

Note: List contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of continuous range groups.


Sample Input-1:
---------------
1 2 4 5 7

Sample Output-1:
----------------
[1->2, 4->5, 7]

Explanation: 
------------
1,2 form a continuous range; 4,5 form a continuous range.


Sample Input-2:
---------------
1 2 3 5 6 7 9 10 12

Sample Output-2:
----------------
[1->3, 5->7, 9->10, 12]

Explanation: 
------------
1,2,3 form a continuous range 
5,6,7 form a continuous range
9,10 form a continuous range
*/
import java.util.*;
class day50p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String[] stringnums = sc.nextLine().split(" ");
          int n = stringnums.length;
          int[] arr = new int[n];
          for(int i=0;i<n;i++) arr[i] = Integer.parseInt(stringnums[i]);
          System.out.println(getRanges(arr,n));
		}
		static ArrayList<String> getRanges(int[] arr,int n){
		    ArrayList<String> al = new ArrayList<>();
		    int start = 0;
		    int count=0;
		    for(int i=1;i<n;i++){
		        if(arr[i]-arr[i-1]==1) count++;
		        else{
		           if(count==0) al.add(Integer.toString(arr[start]));
		           else al.add(arr[start]+"->"+arr[i-1]); 
		           start = i;
		           count=0;
		        }
		    }
		    if(count==0) al.add(Integer.toString(arr[start])); 
			else al.add(arr[start]+"->"+arr[n-1]); 
		           
		    return al;
		}
}     