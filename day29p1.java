/*
FLIPKART online grocery zone offering best prices, and combo offers on a variety
of items. The store has N items which are been sold with a certian price per unit.

There are also combo offers, and each combo offer consists of one or more 
variety of items with a price tag. Each combo offer is represented in the form 
of a list, the last number represents the amount you need to pay for this combo 
offer, other values represents how many specific items you could get if you buy 
this offer. 

Customer can avail the combo offers as many times as they wanted.

Now you are been given pricelist of N items, K number of combo offers, and 
the number of items of each variety need to buy. 

Now it's your turn to find the lowest price you have to pay for to buy exactly 
certain items as given, where you could make optimal use of the combo offers.


Input Format:
-------------
Line-1: Two integers N and K, number of varieties, and number of Combo offers 
Line-2: N space seprated inteegrs, prices of N varieties.
Next K lines: 'N+1' space separated inteegrs, number of items of each variety and
              and last number is cost to buy all these variety of items.
Last Line: N space separated integers, number of items of each variety to buy.

Output Format:
--------------
Print an integer, lowest price to pay for items to buy.


Sample Input-1:
---------------
2 2
3 6
3 1 12
2 3 17
6 6

Sample Output-1:
----------------
40

Explanation:
------------
There are two variety of items, X and Y. Their prices are Rs.3 and Rs. 6 respectively.
In combo offer-1, you can pay Rs.12 for 3X and 1Y
In combo offer-2, you can pay Rs.17 for 2A and 3B.
You need to buy 6A and 6B, so you may pay Rs.34 for 4X and 6Y (combo offer-2), 
and Rs.6 for 2X. So Total of Rs.40


Sample Input-2:
---------------
3 2
1 2 3
1 2 0 4
2 1 2 8
3 4 2

Sample Output-2:
----------------
14
*/
import java.util.*;
import java.lang.*;
import java.util.TreeSet;

class day29p1{
        static TreeSet<Integer> set = new TreeSet<>();
        
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int k = sc.nextInt();
		  int[] itemcost = new int[n];
		  int[] need = new int[n];
		  
		  for(int i=0;i<n;i++) itemcost[i] = sc.nextInt();
		
		  int[][] offers = new int[k][n+1];
		  
		  for(int i=0;i<k;i++)
		    for(int j=0;j<n+1;j++) offers[i][j]=sc.nextInt();
		  
		  for(int i=0;i<n;i++) need[i] = sc.nextInt();
		 getMin(n,k,itemcost,offers,need,0);
		 
		 System.out.println(set.first());
		 
		}
		
		static void getMin(int n,int k,int[] itemcost,int[][] offers,int[] need,int cost){
		    
		      if(isNeedSatisfied(need)){
		          set.add(cost);
		          //System.out.println("Entering first block");
		          return;
		      } 
		      
		      boolean flagOffer=true;
		      
		      for(int i=0;i<k;i++){
		          
		            int[] newneed = new int[n];
		            //System.out.println("Entering second block");
		            if(isOfferPossible(need,offers[i],n)){
		              flagOffer=false;
		              
		              for(int j=0;j<n;j++)
		                newneed[j] = need[j]-offers[i][j];
		                
		             getMin(n,k,itemcost,offers,newneed,cost+offers[i][n]);
		            }
		      }
		            
		            if(flagOffer){
		                int newCost = cost;
		                for(int i=0;i<n;i++)
		                    newCost += need[i]*itemcost[i];
		                //System.out.println("Entering final block");
		                set.add(newCost);
		            }
		}
		
		
		
		static boolean isNeedSatisfied(int[] need){
		    for(int each : need)
		        if(each!=0) return false;
		    
		    return true;
		}
		
		
		static boolean isOfferPossible(int[] need, int[] offer,int n){
		    for(int i=0;i<n;i++)
		        if(need[i]-offer[i]<0) return false;
		    
		    return true;
		}
	
}    