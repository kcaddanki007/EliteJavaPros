/*There are M*N buckets of milk, all the buckets are equal in size (in ltrs).
The buckets are initially filled with different amounts of milk in liters.

You are given the amount of milk in the buckets as a grid of size M x N, 
buckets[][]. You need to make that all the buckets have same quantity of Milk.
You are allowed to perform one operation either adding M liters of Milk
or take away M liters of Milk from the bucket in one step.

Your task is to return the minimum number of steps required to make 
all the buckets in the bucket grid contains same amount of Milk. 
If it is not possible, return -1.

Input Format:
-----------------
Line-1: three space sepaarted integers, A, B and M.
Next A lines: B space sepaarted integers, amount of milk in liters.

Ourput Format:
-------------------
Print the integer result.


Sample Input-1:
-----------------
2 3 5
5 10 15
20 25 40

Sample Output-1:
-------------------
11

Explanation: 
------------
We can make every bucket has equal amount of Milk to 20 liters by doing
the following: 
- Add 5ltrs milk to 5ltrs bucket 3 times.
- Add 5ltrs milk to 10ltrs bucket 2 times.
- Add 5ltrs milk to 15ltrs bucket 1 time.
- Takeaway 5ltrs milk from 25ltrs bucket 1 time.
- Takeaway 5ltrs milk from 40ltrs bucket 4 times.
A total of 11 operations required.


Sample Input-2:
-----------------
3 3 3
1 2 3 4
5 6 7 8
9 19 11 12

Sample Output-2:
-------------------
-1

*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[r][c];
        for(int i=0;i<r;i++)
          for(int j=0;j<c;j++) arr[i][j] = sc.nextInt();
        System.out.println(getToSameOp(arr,r,c,m));
    }
    static int getToSameOp(int[][] arr,int r,int c,int m){
        ArrayList<Integer> al = new ArrayList<>();
        int modval = arr[0][0]%m;
        // int low = Integer.MAX_VALUE;
        // int high = Integer.MIN_VALUE;
        for(int i=0;i<r;i++){
          for(int j=0;j<c;j++){ 
             if(arr[i][j]%m != modval) return -1;
            //  low = Math.min(low,arr[i][j]);
            //  high = Math.max(high,arr[i][j]);
            al.add(arr[i][j]);
            }
        }
        Collections.sort(al);
        if(al.size()%2==0){
            int opta = al.get(al.size()/2);
            int optb = al.get(al.size()/2 - 1);
            return Math.min(getCount(arr,r,c,m,opta),getCount(arr,r,c,m,optb));
        }else{
            int opta = al.get(al.size()/2);
            return getCount(arr,r,c,m,opta);
        }
        
        // low = low/m;
        // high = high/m;
        // int ans = Integer.MAX_VALUE;
        // while(low<=high){
        //         int mid= low +(high-low)/2;
        //         int optim = mid*m+modval;
        //         int res = getCount(arr,r,c,m,optim);
        //         if(res<ans){
        //             ans = res;
        //             low = mid+1;
        //         }else 
        //           high = mid-1;
        //     }
        //     return ans;
    }
    static int getCount(int[][] arr,int r,int c,int m,int optim){
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans+= Math.abs((arr[i][j]-optim)/m);
            }
        }
        return ans;
    }
}