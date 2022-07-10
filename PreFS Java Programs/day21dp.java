import java.util.*;
import java.lang.*;
class day21dp{
	    static Map<Integer, Integer> pairs = new HashMap<>();
	    static int checktable(n){
			 
			
		}
		static int fib(int n){
			   if(n<=1){
				   return n;
			   }
			   else{
				   return checktable(n-1) + checktable(n-2);
			   }
		   
		   } 
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  int[] arr = fib(n);
		  for(int i=0;i<n;i++){
			  System.out.print(arr[i]+" ");
		  }
	}	 
}        

/*
import java.util.*;
import java.lang.*;
class day20dp{
	
	    static int[] fib(int n){
			int[] arr = new int[n];
			arr[0]=0;
			arr[1]=1;
		for(int i=2;i<n;i++){
			arr[i] = arr[i-1]+arr[i-2];
		   }
		   return arr;
		}
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
		  int[] arr = fib(n);
		  for(int i=0;i<n;i++){
			  System.out.print(arr[i]+" ");
		  }
	}	 
}        
*/