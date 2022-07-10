/*
Charan is working on photoshop design in which he has to type a set of digits 
from left to right. Each digit(0-9) is defined with different units of space 
required and represented by an array sp[]. 

 For example, sp[0] is the space required for the digit '0', sp[1] is the space
 required for the digit[1], and so on..

Charan is trying to type the given digits in the same order which is given,across
several lines and each line can take atmost 50 units of space.

Given a set of digits as string, return an array ar[] which consists the
following two values.
	1.ar[0] is the number lines required.
	2.ar[1] is the units of space in the last line.

Input Format:
-------------
Line-1: 10 space seperated positive integers.
Line-2: A string str[] represents the set of digits.
 
Output Format:
--------------
Print two space seperated values.
 
Constraints:

    sp.length == 10
    2 <= sp[i] <= 20
    1 <= str.length <= 1000
    str contains only digits from 0 to 9.


 
Sample Input-1:
---------------
3 2 3 4 5 6 7 8 9 10
9345678123
 
Sample Output-1:
----------------
2 9

Explanation:
------------
9345678 can fit in line-1.
123  in line-2:
So 
Number of lines=2
Last line consits 123 with units 2+3+4=9
 
Sample Input-2:
---------------
3 2 3 4 5 6 7 8 9 10
99999267

Sample Output-2:
----------------
2 18

Explanation:
------------
99999 can fit in line-1.
267 in line-2:
So 
Number of lines=2
Last line consits 267 with units 3+7+8=18.
 
 
*/
import java.util.*;
import java.lang.*;
class day27p2{
	
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int[] space = new int[10];
		  for(int i=0;i<10;i++)
		     space[i]=sc.nextInt();
		  
		  String S = sc.next();
		  System.out.println(Arrays.toString(getspace(space,S)));
		}
		
		static int[] getspace(int[] space,String S){
		    int[] arr = new int[2];
		    int sum=0;
		    arr[0]=1;
		    for(int i=0;i<S.length();i++){
		        if(sum+space[S.charAt(i)-'0']>50){
		           arr[0]+=1;
		           sum=space[S.charAt(i)-'0'];
		        }else
		            sum+=space[S.charAt(i)-'0'];
		    }
		    
		    arr[1]=sum;
		    return arr;
		}
}        