/*There is a series of bulbs in which some bulbs are turned on(indicated by 1) 
 and others are off(indicated by 0). 
 
A contiguous sub-series of bulbs CSB with following rules.
 1. Number of bulbs with status as 'on' and 'off' are same.
 2. Bulbs which are 'on' and 'off' are grouped together.
 You will be given the series as a string of 1's and 0's.
 Your task is to find the count of all the CSBs  exist in the given series.
 
 Input Format:
 -------------
 A string, indicates bulbs series.

 Output Format:
 --------------
 Print an integer result.

 Sample Input-1:
 ---------------
 010011000110
  
 Sample Output-1:
 ----------------
  9
 
 Explanation:
 ------------
 01-3, 10-3, 0011-2, 1100-1 

 Sample Input-2:
 ---------------
 0101010
 
 Sample Output-2:
 ----------------
 6
 
 Explanation:
 ------------
 01-3, 10-3*/
 
 //Adding more characters to the contains string
 
import java.util.*;
import java.lang.*;

class day9p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          
          String word = sc.next();
          int n = word.length();
          char[] carr = word.toCharArray();
          
          int count_of_ones = 0;
          int count_of_zeroes = 0;
          int final_count=0;
          
          for(char c : carr){
              if(c=='0'){
                  count_of_zeroes++;
              }
              else{
                  count_of_ones++;
              }
          }
          
         int min_count = Math.min(count_of_zeroes,count_of_ones);
         
         String p1 = "10";
         String p2 = "01";
         
         while(min_count!=0){
             final_count += (word.split(p1,-1).length - 1);
             final_count += (word.split(p2,-1).length - 1);
             p1 = "1"+p1+"0";
             p2 = "0"+p2+"1";
             min_count--;
         }
          
        System.out.println(final_count);
          
	}	 
}     