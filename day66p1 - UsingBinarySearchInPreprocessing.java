/*There are N employees from 3 different companies in a row, emps[], the employees 
are identified using company IDs as 1,2,3. A Courier Boy need to deliver 
P parcels to these 3 companies. The parcel details are given as parcels[],
where parcel[i]=[Ci,CIDc], i-th parcel, 'Ci' is Courier Boy's current position, 
and  'CIDi' is company's ID, he/she need to deliver parcel[i] from Ci position 
to the nearest employee belongs to companay ID equals to CIDi in the row.

You are given emps[] and parcels[] information,
Your task is to help the courier boy to find the distance between him to 
the nearest employee in that row to deliver the parcel.
If there is no solution found, return -1.

Input Format:
-------------
Line-1: Two space separated integers, N and P
Line-2: N space separated integers, only 1, 2 & 3.
Next C lines: Two space separated integers, position P and Company ID

Output Format:
--------------
Print the space separated integers, distance between boy and the employee for 
all the parcels.


Sample Input-1:
---------------
6 2
1 1 2 2 3 3
1 3
2 2

Sample Output-1:
----------------
3 0 

Sample Input-2:
---------------
5 2
1 2 3 2 1
2 1
1 1

Sample Output-2:
----------------
2 1 
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] emp = new int[n];
        int[][] parcel = new int[p][2];
        
        for(int i=0;i<n;i++)
           emp[i] = sc.nextInt();
           
        for(int i=0;i<p;i++){
            parcel[i][0] = sc.nextInt();
            parcel[i][1] = sc.nextInt();
        }
        
        System.out.println(Arrays.toString(getNearestEmp(n,p,emp,parcel)));
    }
    
    static int[] getNearestEmp(int n,int p,int[] emp,int[][] parcel){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(emp[i])){
                map.get(emp[i]).add(i);
            }else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(emp[i],al);
            }
        }
        //System.out.println(map);
        
        int[] res = new int[p];
        
        for(int i=0;i<p;i++){
            int pos = parcel[i][0];
            int destid = parcel[i][1];
            if(!map.containsKey(destid)) res[i]=-1;
            else{
                ArrayList<Integer> a = map.get(destid);
                int low=0,high=a.size()-1;
                while(low<high-1){
                    int mid = (low+high)/2;
                    
                    if(a.get(mid)>=pos) high=mid;
                    
                    else low=mid;
                }
                res[i] = Math.min(Math.abs(a.get(high)-pos),Math.abs(a.get(low)-pos));
            }
        }
        return res;
        
    }
}