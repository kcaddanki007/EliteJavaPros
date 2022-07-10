
/*
 Chinmay playing a game. Game has a display of N numbers in a row, nums[].
 Chinmay has to pick the numbers one after the other.
  
Once Chinmay picks a number num[i], she will score num[i] points and 
the number will be disappared on the board, simultaneously all the numbers having 
the value 'num[i]+1' or 'num[i]-1' also disappears. 
 
Chinmay has to select the numbers on the board, 
such that no more numbers will be left over on the board.
 
Chinmay wants to score maximum number of points.
  
Initially chinmay has 0 points with her.
Can you help Chinmay to score maximum number of points.

 Input Format:
 -------------
Line-1 -> an integers N, number of numbers on the game board.
Line-2 -> N space separated integers, numbers on the game board nums[].
    
 Output Format:
--------------
Print an integer as result, maximum score she can get.
 
Sample Input-1:
---------------
3
4 5 3

Sample Output-1:
----------------
 8
 
 Explanation: 
 ------------
 Delete 5 to earn 5 points, consequently 4 is also deleted.
  Then, delete 3 to earn 3 points.
  Totally 8 is the score.
    
 Sample Input-2:
 ---------------
 6
 4 4 5 5 5 6
 
Sample Output-2:
----------------
15
 
Explanation: 
-------------
Delete 5 to earn 5 points, deleting both 4's and the 6.
Then, delete 5 again to earn 5 points, and 5 again to earn 5 points.
Totally 15 is the score.

*/
import java.util.*;
import java.lang.*;
class day23p2{
    static Set<Integer> set = new TreeSet<>();
    static Map<Integer, Integer> counter = new HashMap<>();
    
    static int findmax(int arr[]){
        int dp[] = new int[arr.length];
        return md(dp,arr,0,arr.length-1);
    }
    
    public static int md(int[] dp,int[] arr,int start,int n)
    {
        if(start<=n)
        {
            if(dp[start]!=0)
                return dp[start];
            else
                dp[start] = Math.max((arr[start]*counter.get(arr[start]) + md(dp,arr,start+2,n)) , (md(dp,arr,start+1,n)) );
            return dp[start];
        } 
        return 0;
    }

        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          for(int i=0;i<n;i++){
              int p = sc.nextInt();
              set.add(p);
              int count=1;
              if(!counter.containsKey(p)){
                  counter.put(p,count);
              }
              else{
                  count = counter.get(p);
                  count++;
                  counter.put(p,count);
              }
          }
          //new array 
          int ns = set.size();
          int[] arr = new int[ns];
          int j=0;
          for(int each : set){
              arr[j]=each;
              j++;
          }
          System.out.println(findmax(arr));
	}	 
}        

