/*Ms.Akhila is a famous mathematician in a school, one day she decided to
send her students to Maths Olympiad competetion

To do that MS, Akhila called N number of students and ask them to stand in line.
Each student is having distinct grade according to his/her perfomences based
on the exams she conducted so far.

In order to send the students to Olympiad, Ms. Akhila has to form a team of 
3 students among N students from the line with following conditions:
	-> Pick any 3 students with index(p,q,r) with 
	grade(grade[p],grade[q],grade[r]).
	->A team is consider as valid if: 
	  - ( grade[p] < grade[q] < grade[r] ) or ( grade[p] > grade[q] > grade[r] )
 	    where (0 <= p < q < r < N).                                           
     
You are given grades[], grades of N students in the line.                                    
Your task is to return the number of teams Ms.Akhila can form with 
given conditions (students can be part of multiple teams).

Input Format:
-------------
Line-1: AN integer N, number of students.
Line-2: N space seperated integers, grades[].

Output Format:
--------------
An integer, number of teams can be formed.


Sample Input-1:
---------------
5
3 6 4 5 2

Sample Output-1:
----------------
3

Explanation:
------------
Ms Akhila can form three teams given the conditions. 
(3,4,5), (6,4,2), (6,5,2).


Sample Input-2:
---------------
5
1 2 3 4 5

Sample Output-2:
----------------
10
*/

import java.util.*;
class day55p2{
    static int count=0;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  
		  int[] grades = new int[n];
		  for(int i=0;i<n;i++) grades[i] = sc.nextInt();
		  
		  for(int i=0;i<n;i++){
		      getInc(grades,i+1,grades[i],2);
		      getDec(grades,i+1,grades[i],2);
		  }
		  System.out.println(count);
		}
		static void getInc(int[] grades,int index,int max,int k){
		    if(k==0){ 
		        count+=1;
		        return;
		    }
		    if(index>=grades.length) return;
		    
		    if(grades[index]>max) getInc(grades,index+1,grades[index],k-1);
		    getInc(grades,index+1,max,k);
		}
		static void getDec(int[] grades,int index,int min,int k){
		    if(k==0){
		        count+=1;
		        return;
		    }
		    if(index>=grades.length) return;
		    if(grades[index]<min) getInc(grades,index+1,grades[index],k-1);
		    getInc(grades,index+1,min,k);
		}
}     