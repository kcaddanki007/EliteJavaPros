/*
We will be given a range of numbers, both start and end included
The numbers in the range are to be converted to binary and
If we have prime number of 1's in the binary version
Then we consider that as a special number
Print the count of special numbers
*/
import java.util.*;
import java.lang.*;
class day20p2{
		
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int start = sc.nextInt();
          int end = sc.nextInt();
		  System.out.println(countofprimes(start,end));
        }
        
	static int countofprimes(int start, int end){
	    int cofprimes=0;
	    
	    for(int i=start;i<=end;i++){
	        
	        String S = Integer.toBinaryString(i);
	        char[] arrS = S.toCharArray();
	        
	        int countof1 = 0;
	        for(int j=0;j<S.length();j++){
	            if(arrS[j]=='1')
	                countof1++;
	        }
	        
	        if(isPrime(countof1)==true)
	            cofprimes++;
	    }
	    return cofprimes;
	}
	
	static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
 
        else if (n == 2)
            return true;
 
        else if (n % 2 == 0)
            return false;
 
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}        