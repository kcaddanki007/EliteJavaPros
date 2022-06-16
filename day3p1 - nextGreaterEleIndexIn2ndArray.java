/*
Kiran Rao purchased two boxes (Box1,Box2) of unique weights 
of gold coins, where first box weights are subset of second box gold weights.

 Now design a method for Gumadi Baleshwar Rao to find all the next largest weights 
of Box1 gold coins in the corresponding locations of box2 , 
if doesn’t exist return -1.

The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
 to its right side weight in Box2.

NOTE: Unique weights means, no two coins will have same weight.

 Input Format:
 -------------
Line-1: space separated integers, weihts of gold coins in the first box.
Line-2: space separated integers, weihts of gold coins in the second box.

Output Format:
--------------
 Print a list of integers, next largest weights

Sample Input-1:
---------------
 4 3 2
 1 3 4 2

Sample Output-1:
 ----------------
 [-1, 4, -1]


 Sample Input-2:
 ---------------
5 6 3 4
1 5 3 7 8 6 4 2

 Sample Output-2:
 ----------------
[7, -1, 7, -1]

*/

//Push the first element of the list2 on the top of the stack
//traverse the list2 until 
import java.util.*;
import java.lang.*;
class day3p1{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          
          String str = sc.nextLine();
          String[] s1 = str.split(" ");
          String str2 = sc.nextLine();
          String[] s2 = str2.split(" ");
          
		  int[] a1 = new int[s1.length];
		  int[] a2 = new int[s2.length];
		  int[] ans = new int[a1.length];
		  	 
		  for(int i=0;i<s1.length;i++) a1[i] = Integer.parseInt(s1[i]);
		  for(int i=0;i<s2.length;i++) a2[i] = Integer.parseInt(s2[i]);

          HashMap<Integer,Integer> hm = new HashMap<>();
          Stack<Integer> stack = new Stack<>();
          stack.push(a2[0]);
		  //1 5 3 7 8 6 4 2
		  for(int i=1;i<a2.length;i++){
		      while(!stack.isEmpty() && stack.peek() < a2[i]){
		         int key = stack.pop();
		         hm.put(key,a2[i]);
				 
		      }
		     stack.push(a2[i]);
		  }
		
		
		for(int i=0;i<a1.length;i++){
		    if(hm.containsKey(a1[i])) ans[i]=hm.get(a1[i]);
		    else ans[i] = -1;
		}
		
		System.out.println(Arrays.toString(ans));
        }
}        

