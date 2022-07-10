/*You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6

 
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inps = sc.nextLine().split(" ");
        System.out.println(getLatest(inps));
    }
    static String getLatest(String[] inps){
        String max = inps[0];
        for(int i=1;i<inps.length;i++){
            if(isS2greater(max,inps[i]))
              max = inps[i];
        }
        return max;
    }
    static boolean isS2greater(String s1,String s2){
        String[] s1arr = s1.split("-");
        String[] s2arr = s2.split("-");
        int len = Math.min(s1arr.length,s2arr.length);
        int i;
        for(i=0;i<len;i++){
            int s1i = Integer.parseInt(s1arr[i]);
            int s2i = Integer.parseInt(s2arr[i]);
            if(s1i<s2i) return true;
            if(s1i>s2i) return false;
        }
        
        if(s1arr.length==s2arr.length) return false;
        if(s1arr.length>s2arr.length){
            for(int j=i;j<s1arr.length;j++){
                if(!s1arr[j].equals("0")) return false;
            }
            return true;
        }else{
            for(int j=i;j<s2arr.length;j++){
                if(!s2arr[j].equals("0")) return true;
            }
            return false;
        }
        
    }
}

