/*
Task is to ensure that the people can be put in 2 teams
First two digits contain number of people and number of pairs
The pairs are people who want to be put in opposite sets
5 4 
1 2 
1 3
4 2
3 5
Output:
True
*/

//Should be done with dysjoint set union
import java.util.*;
import java.lang.*;
class day12p3{

    static int find_set(int v) {
       if (v == parent[v])
              return v;
        return parent[v] = find_set(parent[v]);
    }

    static void make_set(int v) {
         parent[v] = v;
    }
    
    static void union_sets(int a, int b, int c,int d) {
        a = find_set(a);
        b = find_set(b);
        c = find_set(c);
        d = find_set(d);
            if(a==c){
                
            }
            
    }
        
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
          
        int npeople = sc.nextInt();
        int npairs = sc.nextInt();
          
        int[] parent = new int[npeople];
        
        for(int i=0;i<npeople;i++){
            makeset(i);
        }
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=1;i<npairs;i++){
            int k = sc.nextInt();
            int l = sc.nextInt();
            union_sets(a,b,k,l);
        }
        
	}	 
}        
          
	}	 
}        