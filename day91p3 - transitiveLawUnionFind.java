/*A transitive law is "If a == b and b == c, then a == c"
Which also says "If a == b and b != c, then a != c"

You will be given a list of strings relations[], i.e, like p==q or p!=q.
Your task is to find out whether all the relations follow the transitive law or not.
If all of them followed return true, otherwise return false.

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false


Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true
*/
import java.util.*;
class Solution{
    static int[] parent;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] relations = sc.nextLine().split(" ");
        System.out.println(isTransitive(relations));
    }
    static boolean isTransitive(String[] relations){
        HashMap<Character,Integer> map = new HashMap<>();
        int nodeCnt=0;
        for(String rel : relations){
            char lhs = rel.charAt(0);
            char rhs = rel.charAt(3);
            if(!map.containsKey(lhs)) map.put(lhs,nodeCnt++); 
            if(!map.containsKey(rhs)) map.put(rhs,nodeCnt++);
        }
        parent = new int[nodeCnt];
        Arrays.fill(parent,-1);
        for(String rel : relations){
            if(rel.charAt(1)=='='){
                int indl = map.get(rel.charAt(0));
                int indr = map.get(rel.charAt(3));
                union(indl,indr);
            }
        }
        for(String rel : relations){
            if(rel.charAt(1)=='!'){
                int indl = map.get(rel.charAt(0));
                int indr = map.get(rel.charAt(3));
                if(find(indl)==find(indr)) return false;
            }
        }
        return true;
    }
    static int find(int i){
        while(parent[i]>=0){
            i = parent[i];
        }
        return i;
    }
    static void union(int a,int b){
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb)
          parent[pa]=pb;
    }
}