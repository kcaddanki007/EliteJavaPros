/*You are given a square box with square cubes in it.
Each cube of size 1*1*1, and colored with either yellow or blue.
yellow cube represented by 1 and blue cube represented by 0.

In one operation, You can choose any two adjacent horizontal lines of cubes in 
the box and swap them. The box is said to be diagonal box, if all the square 
cubes above the main diagonal are blue colored.

Your task is to find the the minimum number of operations needed to arrange 
the box as diagonal box , if it is not possible to arrange return  -1.

The main diagonal of a box is the diagonal that starts at cube (0, 0) and
ends at cube (n-1, n-1) .

Input Format:
-------------
Line-1: An integer, N size of the box.
Next N lines: N space separated integers, colors of the cubes in the box.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3
0 1 0     1
1 0 1     0
1 0 0     2

Sample Output-1:
----------------
2

Explanation:
------------
Please do look at the Hint.


Sample Input-2:
---------------
4
1 1 0 0
1 0 1 0
0 1 0 0
1 0 1 0

0 1 2 3
  1 1 
Sample Output-2:
----------------
-1
*/
import java.lang.*;
import java.util.*;

class day42p2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                a[i][j] = sc.nextInt();
        }
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=n-1;j>=0;j--)
            {
                if(a[i][j]==1)
                {
                    arr[i]=count;
                    break;
                }
                count++;
                if(j==0)
                    arr[i] = count;
            }
        }
        System.out.println(getSwaps(arr));
    }
    public static int getSwaps(int[] arr)
    {
        int swap=0,n=arr.length;
        for(int i=0;i<n;i++)
        {
            int min = n-i-1;
            if(arr[i] >= min)
                continue;
            boolean flag = false;
            int j = i+1;
            for(;j<n;j++)
            {
                if(arr[j]>=min)
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                while(j>i)
                {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swap++;
                    j--;
                }
            }
            else
                return -1;
        }
        return swap;
    }
}
}
}
}
}