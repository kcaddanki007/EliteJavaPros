/*
Naveen purchased two boxes (Box1,Box2) of unique weights 
of gold coins, where first box weights are subset of second box gold weights.
    
Now design a method for Naveen to find all the next largest weights of Box1 
gold coins in the corresponding locations of box2 , 
if doesn’t exist return -1.
   
The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
to its right side weight in Box2.
   
NOTE: Unique weights means, no two coins will have same weight.
   
Input Format:
 -------------
 Line-1: Two integers represents size of box1 and size of box2.
Line-2:space separated integers, weihts of gold coins in the first box.
 Line-3: space separated integers, weihts of gold coins in the second box.
   
Output Format:
--------------
Print a list of integers, next largest weights
    
Sample Input-1:
---------------
3 4
4 3 2
1 3 4 2
   
Sample Output-1:
----------------
 [-1, 4, -1]
   
Sample Input-2:
---------------
4 8 
5 6 3 4
1 5 3 7 8 6 4 2
   
Sample Output-2:
----------------
[7, -1, 7, -1]
*/
import java.util.*;
import java.lang.*;
class day18p3{
	

        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n1 = sc.nextInt();
          int n2 = sc.nextInt();
          int[] arr1 = new int[n1];
          int[] arr2 = new int[n2];
          int[] finalArr = new int[n1];
          Map<Integer,Integer> nums = new HashMap<>();
          ArrayDeque<Integer> adq = new ArrayDeque<>();
          
          for(int i=0;i<n1;i++){
              arr1[i]=sc.nextInt();
          }
          
          for(int i=0;i<n2;i++){
              arr2[i]=sc.nextInt();
          }
          
          for(int i=0;i<n2;i++){
              int ele=arr2[i];
              int gEle;
              for(int j=i+1;j<n2;j++){
                  
                  if(arr2[j]>ele){
                      gEle=arr2[j];
                      nums.put(arr2[i],gEle);
                      break;
                  }
                  
              }
          }
          
          for(int i=0;i<n1;i++){
              if(!nums.containsKey(arr1[i])){
                  finalArr[i]=-1;
              }
              else{
                  finalArr[i]=nums.get(arr1[i]);
              }
          }
		  
		  System.out.println(Arrays.toString(finalArr));
	}	 
}        