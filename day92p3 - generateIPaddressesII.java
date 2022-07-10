/*Pramod is planning to design a program, which helps to create 
the IP addresses posssible from a given string S, 
where each IP address should be valid.

It is guaranteed that S contains only digits.

Can you help pramod in designing such program, which returns all possible IP addresses.
Print the answer in lexicographic order.

NOTE:
-----

- A valid IP address consists of exactly four integers, 
each integer is between 0 and 255, separated by single dots 
and cannot have leading zeros
- IP Addresses are said to be valid if it falls in the range 
from 0.0.0.0 to 255.255.255.255

- IP addresses like [123.012.234.255 , 123.234.345.34] are invalid.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]
*/
import java.util.*;
class Solution{
    static Set<String> set = new TreeSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        generate(s,0,s.length()-1,1,"");
        System.out.println(set);
    }
    static void generate(String s,int i,int j,int n,String str){
        if(i==(j+1) && n==5){
            set.add(str.substring(1));
        }
        for(int k=i;k<i+3 && k<=j;k++){
            String temp = s.substring(i,k+1);
            if((s.charAt(i)=='0' && temp.length()>1) || Integer.valueOf(temp)>255)
               return;
            generate(s,k+1,j,n+1,str+"."+temp);
        }
    }
}