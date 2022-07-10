/*Mr.Bean is given a list of N integers as List[], consists of only positive 
integers from 0 to 10^9. 

Mr.Bean has generated all the contiguous sub lists of List[]. On each sublist, 
He perforemd Bitwise OR operation on all the integers in the sublist and stored 
the final answer of that in the list answers[].

Your task is to help Mr.Bean to return the number of unique values in answers[]. 

Input Format:
-------------
Line-1: An integer N
Line-2: N space sepaarted integers, List[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3
2 3 2

Sample Output-1:
----------------
2

Explanation: 
------------
Sublists are [2],[3],[2],[2,3],[3,2],[2,3,2] 
and answers[] after performing bitwise OR: [2,3,2,3,3,3]
The number of unique values in answers[] are 2.


Sample Input-2:
---------------
4
2 3 2 1

Sample Output-2:
----------------
3

Explanation: 
------------
Sublists are [2],[3],[2],[1],[2,3],[3,2],[2,1],[2,3,2],[3,2,1],[2,3,2,1] 
and answers[] after performing bitwise OR: [2,3,2,1,3,3,3,3,3,3]
The number of unique values in answers[] are 3.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
          nums[i] = sc.nextInt();
    System.out.println(getCnt(nums));
    }
    static int getCnt(int[] nums){
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        Set<Integer> cur;
        for(int i : nums){
            cur = new HashSet<>();
            cur.add(i);
            for(int j : prev) cur.add(i|j);
            res.addAll(cur);
            prev = cur;
        }
        return res.size();
    }
}