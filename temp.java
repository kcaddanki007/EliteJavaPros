import java.util.*;
import java.lang.*;
class day12p3{
        static boolean[] vis;
        static int[] done;
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int p = sc.nextInt();
		  int q = sc.nextInt();
		  int[] arr = new int[n];
		  vis = new boolean[n];
		  done = new int[n];
		  for(int i=0;i<n;i++) arr[i] = sc.nextInt();
		  
		  System.out.println(getTime(n,p,q,arr));
		}
		
		static int getTime(int n,int p,int q,int[] arr){
		    
		    if(p*q < n) return -1;
		    
		    int count=0;
		    int time=0;
		    while(!checkVis(vis,n) && count<p)
		    
		    
		}
		
		static boolean checkVis(boolean[] vis,int n){
		    for(int i=0;i<n;i++)
		        if(vis[i]==false) return false;
		   return true;  
		}
		    
		    
}        

