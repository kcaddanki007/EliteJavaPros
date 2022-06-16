/*Indus Infra Ltd purchased a land of size L * W acres, for their upcoming venture.
The land is divided into rectangular plots, using fences. They have kept some 
H horizontal fences as hfences[] and V vertical fences as vfences[] on the land,
where hfence[i] is the distance from the top of the land to the i-th horizontal
fence and, vfence[j] is the distance from the top of the land to the j-th 
vertical fence. Each 1*1 cell is one acre plot.

Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
Your task is to help Mr.RGV to find the biggest plot vailable after the fences 
are setup in the venture.
NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

Input Format:
-------------
Line-1: 4 space separated integers, L,W,H and V
Line-2: H space separated integers, hfence[] in the range [0, L]
Line-3: V space sepaarted integers, vfence[] in the range [0, W]

Output Format:
--------------
Print an integer result, the area of biggest plot.


Sample Input-1:
---------------
5 6 2 2

2 3
2 5

Sample Output-1:
----------------
6


Sample Input-2:
---------------
5 6 1 1
3
4

Sample Output-2:
----------------
12
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();
        int[] arrl = new int[h];
        int[] arrw = new int[v];
        for(int i=0;i<h;i++) arrl[i] = sc.nextInt();
        for(int i=0;i<v;i++) arrw[i] = sc.nextInt();
        System.out.println(getMaxArea(l,w,h,v,arrl,arrw));
    }
    static int getMaxArea(int l,int w,int h,int v,int[] arrl,int[] arrw){
        Arrays.sort(arrl);
        Arrays.sort(arrw);
        double maxldiff = Math.max(arrl[0]-0,l-arrl[h-1]);
        double maxwdiff = Math.max(arrw[0]-0,w-arrw[v-1]);
        
        for(int i=1;i<h;i++) maxldiff = Math.max(arrl[i]-arrl[i-1],maxldiff);
        
        for(int i=1;i<v;i++) maxwdiff = Math.max(arrw[i]-arrw[i-1],maxwdiff);
        
        double ans = maxldiff*maxwdiff;
        ans = ans%1000000007;
        
        return (int)ans;
    }
}