/*In the world, some places are part of some other places like
Hyderabad is part of Telangana, Telangana is part of India, etc.
 
You are given the list of N such combination of places.
Where each combination includes places like X-Y-Z
Where Y is part of X and Z is part of Y. So, X is bigger than Y
and Y is bigger than Z. So Z is also part of X and X is part of itself.

If you given the places like X1, X2, X3, such that X3 is part of X1,  
It is guaranteed there is no X2 such that X3 is part of X2.

You are also given another two places P1 and P2, Your task is to 
find the smallest common place that conatains both P1 and P2 as part of it.

NOTE:
It is guaranteed that always a solution exists.

Input Format:
-------------
Line-1: An integer N.
Next N lines: '-' separated strings, one combination of places.

Output Format:
--------------
Print a string, the smallest common place.


Sample Input-1:
---------------
4
Bharath-Telangana-Hyderabad-Dilshukhnagar
Telangana-Rangareddy-Lbnagar
Hyderabad-Dilshukhnagar-Gaddiannaram
Rangareddy-Lbnagar-Saroornagar
Gaddiannaram
Saroornagar

Sample Output-1:
----------------
Bharath


Sample Input-2:
---------------
4
India-Telangana-Hyderabad
Telangana-Rangareddy-Lbnagar
Telangana-Dilshukhnagar-Gaddiannaram
Rangareddy-Lbnagar-Saroornagar
Gaddiannaram
Saroornagar

Sample Output-2:
----------------
Telangana
*/

import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String a[] = new String[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextLine();
        String p1 = sc.nextLine();
        String p2 = sc.nextLine();
        System.out.println(getMinSubset(a,p1,p2,n));
    }
    public static String getMinSubset(String a[],String p1,String p2,int n)
    {
        Set<String> set = new LinkedHashSet<>();
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String x[] = a[i].split("-");
            for(int j=1;j<x.length;j++)
            {
                hm.put(x[j],x[0]);
            }
        }
        List<String> par1 = new ArrayList<>();
        List<String> par2 = new ArrayList<>();
        while(hm.containsKey(p1))
        {
            p1 = hm.get(p1);
            par1.add(p1);
        }
        while(hm.containsKey(p2))
        {
            p2 = hm.get(p2);
            par2.add(p2);
        }
        int x = par1.size()-1,y = par2.size()-1;
        while(x>=0 && y>=0 && par1.get(x).equals(par2.get(y)))
        {
            x--;
            y--;
        }
        return par1.get(x+1);
    }
}