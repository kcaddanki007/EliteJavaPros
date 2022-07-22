/*Mr. Dhanush has provided the string NUM, which solely contains digits.
He is looking for substrings that are numbers and have an equal number of 
distinct digits in each of them. It follows the rule if the number is 123123, 
but not if the number is 12312.

Your task is to assist Mr. Dhanush in determining the number of distinct 
substrings (numbers) of NUM that adhere to the mentioned rule.


Input Format:
-------------
A string NUM, consist of diits [0-9]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6767

Sample Output-1:
----------------
5

Explanation: 
------------
The list of words are: 6,7,67,76,6767


Sample Input-2:
---------------
2345432

Sample Output-2:
----------------
16

Explnation:
-----------
The list of words are: 2,3,4,5,23,34,45,54,43,32,234,345,543,432,2345,5432

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getCount(s));
    }
    static int getCount(String s){
        int count=0,n=s.length();
        Set<String> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String temp = s.substring(i,j);
                if(!hs.contains(temp)){
                   if(countSame(temp)) count++;
                   hs.add(temp);
                }
            }
        }
        return count;
    }
    static boolean countSame(String s){
        int[] freq = new int[10];
        for(char c : s.toCharArray()){
            freq[c-'0']++;
        }
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<10;i++) hs.add(freq[i]);
        if(hs.contains(0)) hs.remove(0);
        return (hs.size()==1);
    }
}