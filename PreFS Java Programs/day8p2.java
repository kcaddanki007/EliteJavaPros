/*You are given a string S, consist of both lowercase and uppercase alphabets.

Your task is to find out the length of the longest word W with the 
following properties:
	- The word W should be the longest.
	- The word W can be formed with letters of S of your choice.
	- The word W should be equal to the reverse of it, in order to achieve this
	  you can shuffle the letters of W as your need. You cannot use the letters 
	  more than their occurence count as in S.
	
NOTE: Alphabets are case sensitive
"Aa" is  not equal to "aA". The letters 'a' and 'A' are not same

Input Format:
-------------
A string S, consist of lower/uppercase letters

Output Format:
--------------
Print an integer, length of longest word W.


Sample Input-1:
---------------
pqrrrrss

Sample Output-1:
----------------
7

Explanation:
------------
One of the longest word can be formed is "srrqrrs", with length 7.


Sample Input-2:
---------------
AIbohPhObia

Sample Output-2:
----------------
5

Explanation:
------------
One of the longest word can be formed is "bhPhb", with length 5.
*/

//why counting and doing things on paper is super important

import java.util.*;
import java.lang.*;
class day8p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String word = sc.next();
		  
          Map<Character, Integer> counter = new HashMap<>();
		  
		  //frequency Histogram
		  
          for(int i=0;i<word.length();i++){
              int count=1;
              if(!counter.containsKey(word.charAt(i))){
                  counter.put(word.charAt(i),count);
              }
              else if(counter.containsKey(word.charAt(i))){
                  count = counter.get(word.charAt(i));
                  count++;
                  counter.put(word.charAt(i),count);
              }
          }
		  
		  
          int sum=0;
          for(Integer value: counter.values()) {
            if(value%2==0){
                sum+=value;
            }
            else{
                sum+=(value-1);
            }
            
        }
        sum++;
        System.out.println(sum);
          
          
          
        }
}    