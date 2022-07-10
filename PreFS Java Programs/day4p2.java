/*Suman is given two words W1 and W2. 
His task is to derive W2 from W1, with the following operations:
	- Replace all the occurrences of a letter in W1 with any other letter.
	- Repeat the above step to derive  W2 from W1.
	
Your task is to check whether W2 can be derived from W1 or not.
If yes, print 'true', Otherwise print 'false'.

NOTE: You may assume both W1 and W2 have the same length.

Sample Input-1:
-------------------
paper 
title

Sample Output-1:
---------------------
true

Explanation:
----------------
'p' is replaced with 't', 'a' is with 'i', 'e' is with 'l', and 'r' with 'e'.


Sample Input-2:
-------------------
memo 
demo

Sample Output-2:
---------------------
false
*/

//should have used 2 maps but did something else

import java.util.*;
class day4p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String s1 = sc.next();
          String s2 = sc.next();
          
          int n1 = s1.length();
          int n2 = s2.length();
          
          int[] arr1 = new int[n1];
          int[] arr2 = new int[n2];
          
          
          if(n1!=n2){
              System.out.println("false");
          }
          
          
          
          else{
              for(int i=0;i<n1;i++){
              
              char s = s1.charAt(i);
              int count = 0;
              for(int j=0;j<n1;j++){
                  if(s==s1.charAt(j)){
                      count++;
                  }
              arr1[i] = count-1;
              }
          }
          
          for(int i=0;i<n2;i++){
              
              char s = s2.charAt(i);
              int count = 0;
              
              for(int j=0;j<n1;j++){
                  if(s==s2.charAt(j)){
                      count++;
                  }
              arr2[i] = count-1;
              }
          }
          
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    
    
    int count3=0;
    for(int i=0;i<n1;i++){
        if(arr1[i]==arr2[i]){
        count3++;
        }
    }
    
    
    if(count3==n1){
        System.out.println("true");
    }
    else{
        System.out.println("false");
    }
          }
          
    }
}        