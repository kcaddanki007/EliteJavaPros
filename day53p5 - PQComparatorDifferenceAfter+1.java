/*Yamaha Pvt Ltd has N number of stores in Hyderabad, each showroom has 
allotted few vehicles. The sales of each showroom are given as an array, 
sales[], where sales[i]={S, T} indiactes, i-th showroom sold S number of 
vehicles out of T vehicles allotted to that showroom.

Yamaha introduced a new vehicle in the market and the sales of that 
vehicle are at peak(i.e., these vehicles will definitely sold ). Now, 
Yamaha Pvt Ltd, decided to send P vehicles to Hyderabad. Now, each of 
the P vehicles have to be alloted to a showroom in a way that increases 
the avarage sales ratio across all the showrooms. 
The sales ratio of a showroom is calaculated as the number of vehicles 
sold divided by the total number of vehicles given to that showroom.

Your task is to return the maximum possible average sales ratio 
after P number of new vehicles allotted.

Input Format:
-------------
Line-1: Two space separated integers N and P, no.of showrooms, no.of new vehicles
Next N lines: Two space separated integers S and T, sold count, allotted count.

Output Format:
--------------
Print a double result (rounded to 5 decimals), 
Max avg sales ratio of all showrooms.


Sample Input-1:
---------------
4 3
3 5
4 9
6 8
3 10

Sample Output-1:
----------------
0.57008


Sample Input-2:
---------------
6 4
4 8
3 5
7 9
2 7
3 11
4 13

Sample Output-2:
----------------
0.50499
*/
import java.util.*;
class day53p5{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int n = sc.nextInt();
		  int p = sc.nextInt();
		  double[][] arr = new double[n][2];
		  for(int i=0;i<n;i++){
		      arr[i][0] = sc.nextDouble();
		      arr[i][1] = sc.nextDouble();
		  }
		  System.out.printf("%.5f",getHighestAverage(arr,n,p));
		}
		static double getHighestAverage(double[][] arr,int n,int p){
		    Queue<double[]> pq = new PriorityQueue<double[]>((a,b)->{
		        double d1 = (b[0]+1)/(b[1]+1)-b[0]/b[1];
		        double d2 = (a[0]+1)/(a[1]+1)-a[0]/a[1];
		        return Double.compare(d1,d2);
		        });
		        
		   for(int i=0;i<n;i++) pq.offer(arr[i]);

		    for(int i=0;i<p;i++){
		        double[] temp = pq.poll();
		        temp[0]++;
		        temp[1]++;
		        pq.offer(temp);
		    }
		    double ans=0;
		    while(!pq.isEmpty()){
		        double[] temp = pq.poll();
		        ans += temp[0]/temp[1];
		        
		    }
		    return ans/n;
		}
}     
 