/*
Ganesh has a habit of writing the words in backward order,
and writes the sentence without spaces.
 
Ganesh is given a sentence S (without spaces) and an integer C
His way of backward writing the sentence is as follows:
   - Break the sentence into 2C length words from begining to end.
   - Write the first C letters in backward direction of every 2C length word.
   - if there is a leftover word at the end of S with lenth lessthan 2C, then 
   - if length is lessthan C, write all the letters in backward direction.
   - if length is greater than or equal to C, write the first C letters
          in backward direction and keep the rest as it is.
           
 And return the sentence S after writing is completed.
 
Example of backward writing: 
Given sentence, S= "hellokmit" and C=2
Break the sentence into words: hell, okmi, t
Now apply backward writing on each word: ehll, komi, t
So, the final sentence is "ehllkomit"
 
 
Input Format:
-------------
Space separated string and integer, the word and C value
 
Output Format:
--------------
Print a string as result
 
 
Sample Input-1:
---------------
abcdefghijk 3

Sample Output-1:
----------------
cbadefihgjk
 

Sample Input-2:
---------------
appropriate 4
 
Sample Output-2:
----------------
rppaoprieta

*/

import java.util.*;
import java.lang.*;
class day15p2{
        static void reverser(char[] arr, int i, int c){
            char[] rev = new char[c];
            int itr=1;
            for(int j=i;j<i+c;j++){
                rev[c-itr]=arr[j];
                itr++;
            }
            itr = 0;
            for(int j=i;j<i+c;j++){
                arr[j]=rev[itr];
                itr++;
            }
        }
    
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          
          String S = sc.next();
          int c = sc.nextInt();
          
          char[] carr = S.toCharArray();
          int n=carr.length;
          int cdiv = n/(2*c);
          int crem = n%(2*c);
          int start=0;
          for(int a=0;a<cdiv;a++){
              reverser(carr,start,c);
              start+=2*c;
          }
          
          if(crem>=c){
              reverser(carr,start,c);
          }
          else{
              reverser(carr,start,crem);
          }
          
          
          for(int a=0;a<n;a++){
              System.out.print(carr[a]);
          }
	}	 
}        