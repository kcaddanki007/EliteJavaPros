/*
Find the character that is appearing only once in the array and find its index
Sample Output-1:
----------------
2

Explanation:
------------
Both 'v' and 'e' are appeared only once.
The first appeared character is 'v' at position-2.


Sample Input-2:
---------------
vikatakavi

Sample Output-2:
----------------
4


Sample Input-3:
---------------
noon

Sample Output-3:
----------------
-1
*/

//Should have used frequency histogram i think


import java.util.*;
import java.lang.*;
class day6p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String word = sc.nextLine();
          
          int[] count = new int[word.length()];
          
          Arrays.fill(count,0);
          
          for(int i=0;i<word.length();i++){
              for(int j=0;j<word.length();j++){
                  if(word.charAt(i)==word.charAt(j)){
                      count[i]++;
                  }
              }
          }
          
          
          for(int i=0;i<word.length();i++){
              if(count[i]==1){
                  System.out.println(i);
                  break;
              }
              else if(i==word.length()-1){
                  System.out.println(-1);
              }
          }
		  
        }
}       