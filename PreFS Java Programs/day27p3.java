/*
Varun and Srujan are playing a word game. Srujan has given a word of length N 
and a character(ch) which exist in the word.
Now Varun's task is to find the smallest distance of the given character in the
word for each position in the word.

Help Varun to return an array result[] where result.length==N and result[i] is 
the smallest distance from the given character to index i in the word.

The distance between two indices i and j is abs(i - j) , where abs is the 
absolute value function.

Input Format:
-------------
Line-1: A string represents a word
Line-2: a character ch which exist in the word.
 
Output Format:
--------------
Print an array of N values
 
Constraints:
 1 <= word.length <= 10^4
word[i] and ch are lowercase English letters.
It is guaranteed that 'ch' occurs at least once in word .

 
Sample Input-1:
---------------
conclude
c
 
Sample Output-1:
----------------
0 1 1 0 1 2 3 4

 
Sample Input-2:
---------------
kmitngit
i

Sample Output-2:
----------------
2 1 0 1 2 1 0 1 

 
*/
import java.util.*;
import java.lang.*;
class day27p3{
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String S = sc.nextLine();
		  char c = sc.next().charAt(0);
		  System.out.println(Arrays.toString(getRelPosArr(S,c)));
		}
		static int[] getRelPosArr(String S, char c){
		    int[] arr = new int[S.length()];
		    ArrayList<Integer> list = new ArrayList<>();
		    
		    for(int i=0;i<S.length();i++){
			  if(S.charAt(i)==c)
			     list.add(i);
		  }
		  for(int i=0;i<S.length();i++){
		      int min = Integer.MAX_VALUE;
		      for(Integer e : list){
		          min = Math.min(min,Math.abs(i-e));
		      }
		      arr[i]=min;
		  }
		  return arr;
		  /*int occ=Integer.MIN_VALUE();
		  for(int i=0;i<n;i++){
		      if(S.charAt(i)==c){
		          occ1=i;
		          break;
		      }
		  }
		  
		  for(int i=0;i<S.length();i++){
		      int occ1=0;
		      int occ2=0;
		      if(S.charAt(i)==c){
		          occ1=occ2;
		          occ2=i;
		      }
		  }*/
		  
		}
}        