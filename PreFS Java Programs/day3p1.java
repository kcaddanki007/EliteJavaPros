/*Mr Kamalesh is working with Numbers.
He is given an number N. He wants to check whether N,
obeys following conditions or not:
	- Initialize P=0, extract each digit 'd' from N, add them to P=> P = P + d^2.
	- Add reset N value to P as N=P.
	- and repeat the process until the N equals 1 or 
	if N loops endlessly in a cycle without having 1. 
	
Your task is to check whether N becomes 1 or Not.
If yes, print "true", otherwise print "false".

Note: A^B indicates A to power of B.

Input Format:
-------------
An integer N

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
19

Sample Output-1:
----------------
true

Explanation:
------------
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1


Sample Input-2:
---------------
20

Sample Output-2:
----------------
false
*/

//Should have used set but then did some magic
import java.util.*;
class day3p1{
    
        static int newdigitmaker(int n){
            int input = n;
            int P=0;
            while(input!=0){
              int d = input%10;
              P += (int)(Math.pow(d,2));
              input = input/10;
            }
            return P;
        }
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int inp = sc.nextInt();
          int nv=0;
          int pnv;
          int count=0;

          while(true){
                if(nv==1){
                System.out.println("true");
                System.exit(0);
              }
              else if(count>=50){
                  System.out.println("false");
                  System.exit(0);
              }
               else{
                   nv = inp;
                   pnv=nv;
                   nv = newdigitmaker(nv);
                   inp = nv;
              }
              count++;
          
          }
          
    }
}        