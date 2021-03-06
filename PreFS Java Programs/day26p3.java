/*
Nani has given a word in which some characters are consecutively repeated. 
He can form Batches for each consecutive repeated character by choosing start
and ending position of the character.

For example, a word like "pqrrrrrsstttu", Batches are [2,6] for 'r',[7,8] for s,
[9,11] for 't'.

 Nani wants to consider only the Batches with count of characters is atleast 3.
Help Nani to return the batches in the ascending order of the positions of each
batch.

Input Format:
-------------
Line-1: A string represents a word.
 
Output Format:
--------------
Print a 2-D array.
 
Constraints:
-----------
1 <= word.length  <= 2*10^4
word consists only lowercase letters.

 
Sample Input-1:
---------------
pqqrrrst
 
Sample Output-1:
----------------
[[3, 5]]

Explanation:
------------
rrr is the only batch with start index 3 and end index 5.
 
Sample Input-2:
---------------
pqqqrrrsssstvvxxyyzz

Sample Output-2:
----------------
[[1, 3], [4, 6], [7, 10]]

*/


import java.util.*;
import java.lang.*;
class day26p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String S = sc.next();
		  
		  ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
          for (int i = 0; i < S.length(); i++) {
            int count = 1;
            while (i + 1 < S.length() && S.charAt(i)== S.charAt(i + 1)) {
                i++;
                count++;
            }
            if(count>=3){
               ArrayList<Integer> list1 = new ArrayList<>();
               list1.add(i-count+1);
               list1.add(i);
               list.add(list1);
            }
        }
        System.out.println(list);
		  
	}
}        