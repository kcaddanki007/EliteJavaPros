/*
You are given a set of positive numbers s[].
A variable 'count' stores the count of maximum repeated number/numbers in the 
set s[]. 

Your task is to find all continuous subsets of numbers from the given set which
should have same 'count' value as original set and print the size of the subset
which is minimum.

Input Format:
-------------
Line-1: An integer N represents size of the set s[].
Line-2: N space separated positive integers.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= N <= 50000
 0<= s[i] <= 49999

 
Sample Input-1:
---------------
5
3 2 3 4 5

 
Sample Output-1:
----------------
3

Explanation:
------------
Maximum repeated number is 3  and the count=2.
The continuous subsets with the same count are [3 2 3 4 5],[3 2 3 4], [3 2 3].
the least size is 3 with subset[3 2 3].
 
Sample Input-2:
---------------
5
5 6 6 7 5

Sample Output-2:
----------------
2

Explanation:
------------
Maximum repeated numbers are 5 and 6  and the count=2.
The continuous subsets with the same count are [5 6 6 7 5],
[5 6 6 7], [6 6 7 5],[5 6 6] [6 6 7] [6 6].
The least size is 2 with subset[6 6].
 
*/
import java.util.*;
import java.lang.*;
class day25p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  int[] arr = new int[n];
		  for(int i=0;i<n;i++){
		      arr[i] = sc.nextInt();
		  }
		  System.out.println(getsslen(arr,n));
	}


	    static int getsslen(int[] arr,int n){
			Map<Integer, Integer> counter = new HashMap<>();
			HashMap<Integer,ArrayList<Integer>> ind=new HashMap<Integer,ArrayList<Integer>>();    
          for(int i=0;i<n;i++){
              int p = arr[i];
              int count=1;
              if(!counter.containsKey(p)){
                  counter.put(p,count);
              }
              else{
                  count = counter.get(p);
                  count++;
                  counter.put(p,count);
              }
          }
		  
		  int max=0;
		  
		  //System.out.println("Counter Map");
		  //for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
    //               System.out.println(e);
				//   }
				  
				  
		  for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
                  if(e.getValue()>max){
					   max=e.getValue();
				  }
		  }
		  //System.out.println(max);
          int min=Integer.MAX_VALUE;		
		  for (Map.Entry<Integer, Integer> e: counter.entrySet()) {
                  if(e.getValue()==max){
					   int temp = e.getKey();
					   ArrayList<Integer> list = new ArrayList<>();
					   for(int i=0;i<n;i++){
						   if (temp==arr[i])
							   list.add(i);
					   }
					   ind.put(temp,list);
				  }				  
		    }
		   
		  // for (Map.Entry<Integer,ArrayList<Integer>> e: ind.entrySet())
		  //    System.out.println(e);
		   
			
         for (Map.Entry<Integer,ArrayList<Integer>> e: ind.entrySet()){
			 ArrayList<Integer> index = e.getValue();
			 int size = index.size();
				 if(index.get(size-1)-index.get(0) < min)
					 min = index.get(size-1)-index.get(0);
			 
		 }
		
	return min+1;
    }	
}     