/*Babylonians began to measure the time in hours, minutes.
They are given the time in a diital clock as string T, the format is 'HH:MM'
They want to find the time which appears sooner after given time T in the same 
clock, consists the digits of the given time T.

Your task is to help them to find the time accordingly.

The valid timings are as follows, "02:45", "11:09" 
The invalid timings are as follows, "2:45", "11:9".


Input Format:
-------------
A String time, the range is between 00:00 to 23:59, must be HH:MM format.

Output Format:
--------------
Print the valid time, appears after T


Sample Input-1:
---------------
13:45
1 3 4 5
Sample Output-1:
----------------
13:51

Explanation:
------------
The time appears sooner after 13:45 is 13:51, which occurs 6 minutes later.
It is not 13:44, because this occurs 23 hours and 59 minutes later.


Sample Input-2:
---------------
19:49

Sample Output-2:
----------------
11:11
*/


		FOR EFFICIENT SOLUTION : https://aaronice.gitbook.io/lintcode/string/next-closest-time#:~:text=Given%20a%20time%20represented%20in,%3A09%22%20are%20all%20valid.

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String t = sc.next();
        System.out.println(getNearestTime(t));
    }
    static String getNearestTime(String t){
        HashSet<Integer> digits = new HashSet<>();
        String[] valStrs = t.split(":");
        int[] vals = {Integer.parseInt(valStrs[0]),Integer.parseInt(valStrs[1])};
        for(int i=0;i<2;i++){
            int val = vals[i];
            digits.add(val/10);
            digits.add(val%10);
        }
        int val = vals[0]*60 + vals[1];
        int limit = 24*60;
        int i=0;
        for(i=0;i<limit;i++){
            ++val;
            int hr = (val/60)/24 + (val/60)%24;
            int min = val%60;
            if(digits.contains(hr%10) && digits.contains(hr/10) && digits.contains(min/10) && digits.contains(min%10)) break;
        }
        int hr = (val/60)/24 + (val/60)%24;
        int min = val%60;
        
        String shr = "" + ((hr/10==0) ? "0":"") + hr;
        String smin = "" + ((min/10==0) ? "0":"") + min;
        return shr+":"+smin;
    }
    
}


import java.util.*;
import java.time.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<t.length();i++)
            set.add(t.charAt(i));
        LocalTime time = LocalTime.of(Integer.parseInt(t.substring(0,2)),Integer.parseInt(t.substring(3)));
        while(true)
        {
            time = time.plusMinutes(1);
            String newTime = time.toString();
            boolean flag = true;
            for(int i=0;i<newTime.length();i++)
            {
                if(!set.contains(newTime.charAt(i)))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println(newTime);
                break;
            }
        }
    }
}