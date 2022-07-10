/*
List of strings are given
If the list of strings in the vertical and horizontal direction are the same
for a given row number and column number
then print true

input 

abcde bcde cde de e 

Output:
true 

Consider
a b c d e
b c d e
c d e
d e 
e 

Print true


*/

import java.util.*;
import java.lang.*;
class day20p3{
	
	    static boolean checker(String[] strarr,int n){
	     for(int i=0;i<strarr.length;i++)
        {
            StringBuilder str = new StringBuilder();
            for(int j=0;j<strarr.length;j++)
            {
                if(i<strarr[j].length())
                    str.append(strarr[j].charAt(i));
            }
            if(str.toString().length()!=strarr[i].length())
                return false;
            
            if(!(str.toString().equals(strarr[i])))
                return false;
        }
        return true;
			
		}
		
        public static void main(String args[]){
          
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          String[] strarr = new String[n];
          
          for(int i=0;i<n;i++){
               strarr[i]=sc.next();
          }
        
        System.out.println(checker(strarr,n));
	}	 
}        