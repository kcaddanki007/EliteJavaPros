/*
There are N rail compartments and each compartment has an ID printed on it. 
Given an array of compartments where compartment[i] is the ID printed on i-th compartment.

There are 2 hooks for each compartment to connect with other compartment.
You need to form the rails by connecting the compartments with each other.
You can connect two compartments with each other if their IDs are consecutive.
e.g., consecutive numbers: 1,2,3,... or 5,6,7,8.

Your task is to find the length of the longest rail can be formed.

Input Format:
-------------
Line-1: An integer N represents number of compartments.
Line-2: N space separated integers, IDs of compartments.

   
Output Format:
---------------
Print an integer value
  
  
Sample Input-1:
---------------
7
12 6 5 10 11 7 8

Sample Output-2:
----------------
4

Explanation:
------------
The compartments with values 5,6,7,8 can be connected and 
the compartments with values 10,11,12 can be connected. 
So the rail with maximum length is 4.
  
  
Sample Input-2:
---------------
6
1 3 4 5 11 10
   
Sample Output-2:
----------------
3

Explanation:
------------
The compartments with values 3,4,5 can be connected and 
the compartments with values 10,11 can be connected. 
So the rail with maximum length is 3.
    
Constraints:
 0 <= N <= 10^5
 -10^9 <= b[i] <= 10^9

*/

//Using DSU
import java.util.*;
importjava.lang.*;
class day14p3{

    static int find(int a,int parent[]){
        if(parent[a]==a){
            return a;
        }
        else{
           return find(parent[a],parent);
        }
    }
    

    static void union(int no,int no1,int[] parent){
        int small = find(no,parent);
        int smallPlus1 = find(no1,parent);
        if(small!=smallPlus1){
            parent[smallPlus1] = small;
        }
    }


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        Map<Integer, Integer> num_index = new HashMap<>();
        int[] parent = new int[n];
        
        //Entries in Hashet
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            num_index.put(num,i);
        }
        
        //Make parent set
        for (Map.Entry<Integer, Integer> e: num_index.entrySet()) {
           parent[e.getValue()]=e.getValue();
       }
       
       //Unionise
        for (Map.Entry<Integer, Integer> e: num_index.entrySet()) {
           int no=e.getKey();
           if(num_index.containsKey(no+1)){
               union(num_index.get(no),num_index.get(no+1),parent);
           }
       }
       
       //Finding all chain length
       Map<Integer, Integer> counter = new HashMap<>();
          for(int i=0;i<n;i++){
              int count=1;
              if(!counter.containsKey(parent[i])){
                  counter.put(parent[i],count);
              }
              else{
                  count = counter.get(parent[i]);
                  count++;
                  counter.put(parent[i],count);
              }
          }
       
       //Finding max chain length
       int max=0;
       for(Integer value: counter.values()) {
            if(value>max){
                max=value;
            }
        }
        
        System.out.println(max);
		
    }
}