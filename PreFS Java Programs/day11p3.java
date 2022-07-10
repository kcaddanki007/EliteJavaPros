/*
Ganesh's lucky number is 3.
He works as an accountant in a company.
He likes to know the third highest salary among all the employees.
 
You will be given an array of salaries salary[].
You need to help Ganesh to find the third highest salary (distinct).
 
NOTE: Salary is in lakhs per annum.
 
 Input Format:
 -------------
 Line-1:An integer N represents no.of salaries.
 Line-2: N space separated integers represents the salaries.
  
 Output Format:
 --------------
 Print an integer, third highest salary.
  
  
 Sample Input-1:
 ---------------
  5
  3 5 2 7 6
  
  Sample Output-1:
  ----------------
  5
   
   
  Sample Input-2:
  ---------------
   5
   5 5 4 7 7
   
  Sample Output-2:
  ----------------
   4
   
*/
import java.util.*;
import java.lang.*;
class day11p3{
        public static void main(String args[]){
            
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  Set<Integer> set = new TreeSet<>();
		  
		  for(int i=0;i<n;i++){
		     set.add(sc.nextInt());
		  }
		  
		  int ssize = set.size();
		  int[] arr = new int[ssize]; 
    
          int i = 0; 
          for (int ele : set){
             arr[i++] = ele; 
          }

		  if(ssize<3){
		  System.out.println(arr[ssize-1]);
		  }
		  else{
		   System.out.println(arr[ssize-3]);
		  }
		  
          
	}	 
}        