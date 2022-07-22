/*There are numerous possible combinations of HTML colour codes, and each one is 
given a specific identification number. Each codes[i] in the list, codes[], 
is an HTML colour code that was chosen by the web designer. The list may 
contain duplicate codes.

The web designer's customer made the decision to eliminate P number of 
consecutive codes from the list. However, the web designer wants to preserve as 
many distinctive colour codes as he can. Find out how many unique colour codes 
the web designer can preserve, and print the count of unique color codes.


Input Format:
-------------
Line-1: Comma separated integers, codes[], HTML color codes
Line-2: An integer P.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,3,2,6,3,3,7,1
4

Sample Output-1:
----------------
4

Explanation: 
------------
The unique color codes he can preserve are, [2,3,7,1]
by removing [2,6,3,3].


Sample Input-2:
---------------
1,2,1,2,3,3,2,1,2,1
6

Sample Output-2:
----------------
2

Explanation: 
------------
The unique color codes he can preserve are, [2,1,2,1] or [1,2,1,2]
by removing 6 contiguous codes.
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] colors = sc.next().split(",");
        int n = sc.nextInt();
        System.out.println(getMaxColors(colors,n));
    }
    static int getMaxColors(String[] colors,int window){
        if(window>=colors.length) return 0;
        Map<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<colors.length;i++){
            hm.put(colors[i],hm.getOrDefault(colors[i],0)+1);
        }
        
        for(int i=0;i<window;i++){
            int temp = hm.get(colors[i])-1;
            if(temp==0) hm.remove(colors[i]);
            else hm.put(colors[i],temp);
        }
        int max = hm.size();
        for(int i=window;i<colors.length;i++){
            hm.put(colors[i-window],hm.getOrDefault(colors[i-window],0)+1);
            
            int temp = hm.get(colors[i])-1;
            if(temp==0) hm.remove(colors[i]);
            else hm.put(colors[i],temp);
            max = Math.max(max,hm.size());
        
            // System.out.println(hm);
            // System.out.println(max);
        }
        //System.out.println(hm);
        return max;
    }
}