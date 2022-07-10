/*
Mr. James professor at MIT, as a part of assignment he created a
problem statement related to words.
He gave a word w and asked them to design a method to 
return the longest substring w1 in word w ,where w1 in reverse is also equal to w1.

NOTE: Alphabets are case sensitive ('A' and 'a' are not same).


Input Format:
-------------
A string S, consist of lowercase/uppercase letters or/and digits

Output Format:
--------------
Print a string.


Sample Input-1:
---------------
abbbabbcbbacdb

Sample Output-1:
----------------
abbcbba


Sample Input-2:
---------------
thedivideriswide

Sample Output-2:
----------------
edivide


*/
import java.util.*;
import java.lang.*;
class day23p3{
        static Map<String,Integer> checkpd = new HashMap<>();
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String S = sc.next();
          char[] Sarr = S.toCharArray();
		  int n=Sarr.length;
		  
		  boolean b = findpd(Sarr,0,n-1);
		  
		  int max=-1,startOfp=0,endOfp=0;
		  
		  for (Map.Entry<String, Integer> e: checkpd.entrySet()) {
		      String[] strArr = e.getKey().split("-");
              int start=Integer.parseInt(strArr[0]);
              int end=Integer.parseInt(strArr[1]);
              
          if((end-start)>max){
              max=end-start;
              startOfp=start;
              endOfp=end;
              
          }
       }
       System.out.println(S.substring(startOfp,endOfp+1));
		  
		  
	}	 
	
	 static boolean findpd(char[] arr,int i,int j){
	       String key = i+"-"+j;
	        System.out.println(key);
	       if(j>=i){
	           if(i==j){
	           System.out.println("Entered Equals");
	           return true;
	       }
	       
	       boolean right = findpd(arr,i+1,j);
	       boolean left =findpd(arr,i,j-1);
	       if(checkpd.containsKey(key)){
	           System.out.println("Entered hashcheck");
	           return true;
	       }else if((arr[i]==arr[j]) && findpd(arr,i+1,j-1)){
	           System.out.println("Entered and block");
	           checkpd.put(key,j-i);
	           System.out.println("key placed:"+key);
	           return true;
	        }else if( right || left ){
	            System.out.println("Entered or block");
	            return true;
	        }
	       }
	       
	        return false;
		  }
}        