/*Babylonians invented multiplication of numbers.

You will be given two strings consist of digits only.
You have to perform the multiplication of these two strings using 
Babylonians approach, and return the result of multiplication of two strings.


Input Format:
-------------
Two space separated strings, num1 and num2.

Output Format:
--------------
Print the product of two strings num1 and num2.


Sample Input-1:
---------------
5 4 

Sample Output-1:
----------------
20


Sample Input-2:
---------------
121 432 

Sample Output-2:
----------------
52272

Note:
-----
	- Input should contain digits only, and should not contain leading 0's 
	  except number 0.
	- Output will be in the range of integer only.
	- There will be no leading minus '-' symbol also.
	- Should not use built-in BigInteger library.
	- Should not convert the given strings into integers.
*/

import java.util.*;
import java.lang.*;
class day40p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  String s1 = sc.next();
		  String s2 = sc.next();
		  System.out.println(babylonianMul(s1,s2));
		}
		static String babylonianMul(String s1,String s2){
		    
		    if(s1.equals("0") || s2.equals("0")) return "0";
		    
		    StringBuilder sb1 = new StringBuilder(s1);
            StringBuilder sb2 = new StringBuilder(s2);
            sb1.reverse();
            sb2.reverse();
            //System.out.println(sb1);
            //System.out.println(sb2);
            int[] arr = new int[s1.length()+s2.length()];
            
            for(int i=0;i<s1.length();i++)
                for(int j=0;j<s2.length();j++)
                    arr[i+j] += (sb1.charAt(i)-'0')*(sb2.charAt(j)-'0');
                
            StringBuilder sb3 = new StringBuilder();
            for(int i=0;i<arr.length-1;i++){
                //System.out.println("arr "+i+" "+arr[i]);
                arr[i+1] += arr[i]/10;
                sb3.append(arr[i]%10);
                //System.out.println(sb3);
            }
            if(arr[arr.length-1]==0) return sb3.reverse().toString();
            else{
                sb3.append(arr[arr.length-1]);
                return sb3.reverse().toString();
            }
		}
} 