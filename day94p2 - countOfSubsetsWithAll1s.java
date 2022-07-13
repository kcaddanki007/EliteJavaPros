/*There are a series of balloons, wehre few balloons are colored blue(indicated by 1) 
and others are colored white(indicated by 0).

Return the count of sub-series of balloon which are colored blue.

for example:
1101 -> sub-series are 1,1,1(subseries of length-1),11(sub-series of length-2).
Total=4

Since the answer may be too large, return it modulo 10^9 + 7.

Note: input is given as a string.
 
Input Format:
-------------
A string represents the status of series of balloons.

Output Format:
--------------
Print an integer

Sample Input-1:
---------------
11101

Sample Output-1:
----------------
7

Explanation:
------------
subseries are 1,1,1,1,11,11,111.


Sample Input-2:
---------------
101

Sample Output-2:
----------------
2

Explanation:
-------------
sub-series are: 1,1.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(getCountOfSubset(str));
    }
    static int getCountOfSubset(String str){
        int n = str.length();
        int curr = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1'){
                curr++;
            }else{
                curr = 0;
            }
            sum += curr;
        }
        return sum;
    }
}