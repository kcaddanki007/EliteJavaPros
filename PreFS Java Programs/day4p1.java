/*Subrahmanyam is working with numbers
He is given a list of numbers, his task is to find the priority number. 
The priority number is the number that occured more than 'list.length/2' times.

You may assume that the list is non-empty 
and the priority number always exist in the list.

Input Format:
-------------
line-1: an integer N, list size.
line-2: N space separated integers, numbers in the list[].

Output Format:
--------------
An integer, the priority number of the set.


Sample Input-1:
---------------
2
3 2 3

Sample Output-1:
----------------
3


Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2
*/

//dominant number can be done using ^ but only applies if it occurs > n/2 times
//done using adding and subtracting the dominant number counts, and having the idea that 
//other number's presence is a decrement to the dominant number

import java.util.*;
class day4p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int dominant=sc.nextInt();
          int count=1;
          for(int i=1;i<n;i++){
              int temp=sc.nextInt();
              if(dominant==temp){
                  count++;
              }
              else if(dominant!=temp && count!=0){
                  count--;
              }
              else if(dominant!=temp && count==0){
                  dominant=temp;
                  count=1;
              }
          }
         System.out.println(dominant);
          
          
    }
}