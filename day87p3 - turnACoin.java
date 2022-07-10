/*In an exhibition, A shopkeeper organizing a game stall,
'N' peolple can participate in the game, each person will get a token 
with a positive number printed on both sides(possibly different).

After that, all of them place the 'N' tokens on a table in a row, 

Now, the shopkeeper will turn any number of tokens upside down.
For example, if a token placed on a table shows 5 upside 2 downside
after turn it will show 2 upside and 5 downside.

After turning the tokens, if the number X on the downside of the token, 
is not on the upside of any other token, then the person who owns that token 
will be the winner. If no such number found, NO winner.

Based on following information and you need to find X.
You will be given 'N' upside numbers and 'N' down side numbers on tokens 
when placed on table.

Note: You need to print the number X, and X to be smallest of all such tokens.
if no such number X present, print 0.

Input Format:
----------------
Line-1 -> an integers N, number of tokens
Line-2 -> N space seperated integers, upside numbers
Line-3 -> N space seperated integers, downside numbers

Output Format:
------------------
Print the integer X if found.
Otherwise print '0'.


Sample Input-1:
-------------------
5
1 2 4 4 7
1 3 4 1 3

Sample Output-1:
---------------------
2

Explanation:
---------------
If we turn the second token upside down, the upside numbers are [1,3,4,4,7]
and the downside numbers are [1,2,4,1,3].
We choose the second token, which has number 2 on the downside, and it
isn't on the upside of any token, so X=2.


Sample Input-2:
-------------------
5
1 3 4 4 1
1 4 3 1 3

1 3 3 4 1
1 4 4 1 3

Sample Output-2:
---------------------
0
*/
import java.util.*;
class day87p3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<2*n;i++){
            int temp = sc.nextInt();
            hm.put(temp,hm.getOrDefault(temp,0)+1);
        }
        ArrayList<Map.Entry<Integer,Integer>> al = new ArrayList<>(hm.entrySet());
        Collections.sort(al,(a,b)->{
          if(a.getValue()==b.getValue())
              return a.getKey()-b.getKey();
          return a.getValue()-b.getValue();
        });
        if(al.get(0).getValue()!=1) System.out.println(0);
        else System.out.println(al.get(0).getKey());
    }
}