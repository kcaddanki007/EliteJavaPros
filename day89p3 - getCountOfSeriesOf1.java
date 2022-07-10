/*There are a series of bulbs in which some bulbs are turned on(indicated by 1) 
    2 and others are off(indicated by 0).
    3 
    4 Return the count of sub-series of bulbs which are turned on.
    5 
    6 for example:
    7 1101 -> sub-series are 1,1,1(subseries of length-1),11(sub-series of length-2).
    8 Total=4
    9 Since the answer may be too large, return it modulo 10^9 + 7.
   10 
   11 Note: input is given as a string.
   12  
   13 Input Format:
   14 -------------
   15 Line-1: A string represents the status of series of bulbs.
   16 
   17 Output Format:
   18 --------------
   19 return an integer
   20 
   21 Sample Input-1:
   22 ---------------
   23 11101
   24 
   25 Sample Output-1:
   26 ----------------
   27 7
   28 
   29 Explanation:
   30 ------------
   31 subseries are 1,1,1,1,11,11,111.
   32 
   33 Sample Input-2:
   34 ---------------
   35 101
   36 
   37 Sample Output-2:
   38 ----------------
   39 2
   40 
   41 Explanation:
   42 -------------
   43 sub-series are: 1,1.*/
   
   
   1 import java.util.*;
    2 class Solution{
    3     public static void main(String[] args){
    4         Scanner sc = new Scanner(System.in);
    5         String s = sc.next();
    6         System.out.println(getSeriesCount(s));
    7     }
    8     static long getSeriesCount(String s){
    9         long[] memo = new long[s.length()];
   10         memo[0] = (s.charAt(0)=='0')? 0 : 1;
   11         int n = s.length();
   12         long res = 0;
   13         res += memo[0];
   14         for(int i=1;i<n;i++){
   15             if(s.charAt(i)=='0'){
   16                 memo[i] = 0;
   17             }else{
   18                 memo[i] = 1+memo[i-1];
   19                 res += memo[i];
   20             }
   21         }
   22         return res%1000000007;
   23     }
   24 }