/*In recent times, lot of people are effecting with Covid, the need of oxygen
cylinders is high. There is a need, of K oxygen cylinders. The need of oxygen 
by the coivd patient may vary from patient to patient.

There are 'N' number of patients with the given need of oxygen as need[], 
where 'i'th patient need is need[i].
and each Oxygen cylinder can handle maximum need 'S'. 
Each cylinder can serve at most two covid patients at same time, the sum
of needs of those patients should be <= 'S'.

Find out the minimum number of cylinders 'K' required to serve all 
the covid effected patients.

Note: It is guaranteed that an oxygen cylinder can serve one covid patient
of any amount of need of oxygen.

Input Format:
-------------
Line-1 -> Two Integers, N and S
Line-2 -> N space separated integers, need[]

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 3
3 2 2 1

Sample Output-1:
----------------
3

Explanation: 
------------
3 cylinders required (1, 2), (2) and (3).


Sample Input-2:
---------------
4 5
3 5 3 3

Sample Output-2:
----------------
4

Explanation: 
------------
4 cylinders required (3), (3), (4), (5)

*/
import java.util.*;
class day61p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(getReq(n,s,arr));
    }
    static int getReq(int n,int s,int[] arr){
        int res = 0;
        Arrays.sort(arr);
        int i=0,j=n-1;
        while(i<=j){
            if(arr[i]+arr[j]>s){
                res++;
                j--;
            }else{
                i++;
                j--;
                res++;
            }
        }
        return res;
    }
}