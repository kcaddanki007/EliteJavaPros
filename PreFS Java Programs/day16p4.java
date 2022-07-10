/*
Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 1 to N.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.
 
Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. If you are not able to find such plan, print -1.
 
Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
  
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.
 
 
Sample Input-1:
---------------
4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5
 
Sample Output-1:
----------------
8
 
Explanation:
------------
The cheapest route plan is as follows:
 1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8
 
 
Sample Input-2:
---------------
4 3
1 2 3
1 3 5
2 3 4
 
Sample Output-2:
----------------
-1
*/

import java.lang.*;
import java.util.*;
class Route //implements Comparator
{
    int a,b,price;
    Route(int a,int b,int price)
    {
        this.a = a;
        this.b = b;
        this.price = price;
    }
}

class Test
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int parent[] = new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i]=i;
        ArrayList<Route> r = new ArrayList<>();
        for(int i=0;i<p;i++)
        {
            r.add(new Route(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        r.sort((Route a,Route b)->a.price-b.price);
    
        int sum=0,i=0,flag=0;
		
        while(i<p)
        {
            int x = find(r.get(i).a,parent);
            int y = find(r.get(i).b,parent);
            int z = r.get(i).price;
          
            if(x!=y)
            {
                union(x,y,parent);
                sum+=z;
            }
            if(count_set(parent)==2)
            {
                flag=1;
                break;
            }
            i++;
        }
        if(flag==1)
            System.out.println(sum);
        else
            System.out.println(-1);
    }
	
    public static int find(int x,int[] a)
    {
        if(a[x] == x)
            return x;
        return find(a[x],a);
    }
	
    public static void union(int x,int y,int parent[])
    {
        if(find(x,parent)!= find(y,parent))
            parent[find(y,parent)]=find(x,parent);
    }
	
    public static int count_set(int[] a)
    {
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==i)
                count++;
        }
        return count;
    }
}