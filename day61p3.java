/*There are N boxes in a room, The boxes are numbered from 1 to N.
By mistake few boxes are numbered with duplicates between 1 to N.

You are given the list of numbers printed on boxes as nums[].
Your task is to find the list of numbers in the range of 1 to N, which are not
printed on the boxes.


Input Format:
-------------
Line-1 -> an integer, N number of boxes
Line-2 -> N space separated integers, nums[]

Output Format:
--------------
Print a list of integers as result.


Sample Input-1:
---------------
4
3 2 2 1

Sample Output-1:
----------------
[4]


Sample Input-2:
---------------
7
1 3 5 3 6 6 2

Sample Output-2:
----------------
[4, 7]

*/
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

class day61p3
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<n;i++) al.add(sc.nextInt());
            
         List<Integer> res = IntStream.rangeClosed(1,n)
         .filter(t -> !al.contains(t))
         .boxed()
         .collect(Collectors.toList());
        System.out.println(res);
    }
}