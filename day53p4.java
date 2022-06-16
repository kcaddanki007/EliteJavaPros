/*There are S counters[] in a Restaurant and T orders[] made by customers,
counters[i] is the capacity of the i-th counter, 
and orders[k] is the time required to prepare the k-th order, in minutes.
Both the counters[] and orders[] are 0-indexed arrays.

Orders are assigned to the counters using an order queue. 
Initially, all counters are available, and the queue is empty.

At k-th minute, the k-th order is entered into the queue
(starting with the 0th order being entered at 0th minute). 

As long as the counters are available and the queue is not empty, 
the first order in the queue will be assigned to an available counter 
with the smallest capacity, and in case of a tie, it is assigned to
an available counter with the smallest index.

If there are no counters available and the queue is not empty, 
wait until a counter becomes available and immediately assign the next order.
If multiple counters become available at the same time, then multiple orders
from the queue will be assigned in order of entrance, following the capacity 
and index priorities above.

A counter that is assigned an order k at minute M will be free again 
at (M + orers[k]) minute.

Your Order is to build an array result[] of length T, where result[k] is
the index of the counter the k-th order will be assigned to, and print it.


Input Format:
-------------
Line-1: Two space separated integers, values of S and T.
Line-2: S space separated integers, 
Line-3: T space separated integers, 

Output Format:
--------------
Print T space separated integers, the final result.


Sample Input-1:
---------------
3 7
8 8 6
1 2 2 3 2 1 2

Sample Output-1:
----------------
2 2 0 2 0 1 2

Explanation: Events in chronological order go as follows:
- At minute-0, order-0 is entered and prepared using counter-2 until minute-1.

- At minute-1, counter-2 becomes available. order-1 is entered and prepared
  using counter-2 until minute-3.

- At minute-2, order-2 is entered and prepared using counter-0 until minute-4.

- At minute-3, counter-2 becomes available. order-3 is entered and prepared 
  using counter-2 until minute-6.

- At minute-4, counter-0 becomes available. order-4 is entered and prepared
  using counter-0 until minute-6.

- At minute-5, order-5 is entered and prepared using counter-1 until minute-6.

- At minute-6, all counters are available. order-6 is entered and prepared 
  using counter-2 until minute-8.

Sample Input-2:
---------------
4 8
8 2 6 4
1 2 3 4 5 6 7 8

Sample Output-2:
----------------
1 1 3 1 2 3 0 1
*/
import java.lang.*;
import java.util.*;

class day53p4{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int counters[] = new int[s];
        int orders[] = new int[t];
        for(int i=0;i<s;i++) counters[i] = sc.nextInt();
        for(int i=0;i<t;i++) orders[i] = sc.nextInt();    
        System.out.println(Arrays.toString(getResult(counters,orders)));
    }
    public static int[] getResult(int[] c, int[] o)
    {
        PriorityQueue<int[]> counter = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        PriorityQueue<int[]> order = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        
        int[] res = new int[o.length];
        
        for(int i=0;i<c.length;i++) counter.offer(new int[]{c[i],i});
        int t=0;
        for(int i=0;i<o.length;i++)
        {
            if(order.isEmpty() || order.peek()[0]>t)
            {
                if(!counter.isEmpty())
                {
                    int x[] = counter.poll();
                    res[i] = x[1];
                    order.offer(new int[]{t+o[i],x[1]});
                }
                else
                {
                    while(order.peek()[0]>t)
                        t++;
                    while(!order.isEmpty() && order.peek()[0]<=t)
                    {
                        int x[] = order.poll();
                        counter.offer(new int[]{c[x[1]],x[1]});
                    }
                    int[] x = counter.poll();
                    res[i] = x[1];
                    order.offer(new int[]{t+o[i],x[1]});
                }
            }
            else
            {
                while(!order.isEmpty() && order.peek()[0]<=t)
                {
                    int x[] = order.poll();
                    counter.offer(new int[]{c[x[1]],x[1]});
                }
                int[] x = counter.poll();
                res[i] = x[1];
                order.offer(new int[]{t+o[i],x[1]});
            }
            t++;
        }
        return res;
    }
}