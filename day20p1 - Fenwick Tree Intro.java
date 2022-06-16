/*Mallika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the sum of numbers between indices S1 and S2 (S1<=S2),
both S1 and S2 inclusive.

There are P Students in the class, numbered from 1 to P. Each student is
given set of indices and that student has to find the sum of the numbers 
between the indices and print the result.

And return the answer in the same order of

Input Format:
-------------
Line-1: Two integers N and P, N is length of set of numbers.
		where 1<= N <= 1000
Line-2: N space separated integers, array set[]
Next P lines: Two integers S1 and S2, index positions 
		where 0 <= S1 <= S2 < N
		and 1<= set[i] <= 100000

Output Format:
--------------
Print the sum of numbers between indices(s1, s2) given to each student.


Sample Input-1:
---------------
8 2
115053 59099 681359 526248 123844 612168 920784 591204
2 6
1 5

Sample Output-1:
----------------
2864403
2002718
*/
import java.util.*;
import java.lang.*;
class day20p1{
        
        static int[] FT;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int p = sc.nextInt();
		  int[] arr = new int[n];
		  int[] ans = new int[p];
		  FT = new int[n+1];
		  
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  
		  buildFT(arr,n);
		  
		  for(int i=0;i<p;i++){
		      int l = sc.nextInt();
		      int r = sc.nextInt();
		      ans[i] = sum(r)-sum(l-1);
		  }
		  System.out.println(Arrays.toString(ans));
		}
		

		static void buildFT(int arr[], int n){
            for(int i = 0; i < n; i++)
                updateFT(n, i, arr[i]);
        }
        
        static void updateFT(int n, int ind, int val){
            ind = ind + 1;
            
            while(ind <= n){
            FT[ind] += val;
            ind += ind & (-ind);
            }
            
        }
        
        static int sum(int ind){
            int sum = 0; 
            ind = ind + 1;
            while(ind>0){
                sum += FT[ind];
                ind -= ind & (-ind);
            }
            return sum;
        }
}        