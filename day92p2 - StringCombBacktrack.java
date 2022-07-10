/*Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getExpandedList(s));
    }
    static List<String> getExpandedList(String s){
        String[] sarr = s.split("[^a-z,]");
        List<String> res = new ArrayList<>(Arrays.asList(sarr[0].split(",")));
       
        for(int i=1;i<sarr.length;i++){
            List<String> tempres = new ArrayList<>(); 
            String[] temp = sarr[i].split(",");
            for(String left : res){
                for(String right : temp){
                    tempres.add(left+right);
                }
            }
            res = tempres;
        }
        Collections.sort(res);
        return res;
    }
}