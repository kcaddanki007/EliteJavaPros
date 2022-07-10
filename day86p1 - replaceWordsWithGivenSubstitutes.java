/*There are N pair of words, the pair of words are likely to be similiar in 
meaning, where pair[i] = [org, similar] indicates that org and similar are 
equivalent words in meaning. and you are also provided a sentence 'phrase'.

You need to transform the phrase with pairs and return all possible transformed 
phrases sorted in lexicographical order.

Input Format:
-------------
Line-1: An integer N, number of pairs.
Next N lines: two space seperated strings, the pair. 
last Line: A string S, the original phrase.

Output Format:
--------------
List of transformed phrases in lexicographcal order.


Sample Input-1:
---------------
2
happy joy
share part
i am happy to share this with you

Sample Output-1:
----------------
[i am happy to part this with you, i am happy to share this with you, 
i am joy to part this with you, i am joy to share this with you]


Sample Input-2:
---------------
3
hi hello
sweet sugary
hard tough
hi ramesh the laddu you made is so sweet and hard

Sample Output-2:
----------------
[hello ramesh the laddu you made is so sugary and hard bite, 
hello ramesh the laddu you made is so sugary and tough bite, 
hello ramesh the laddu you made is so sweet and hard bite, 
hello ramesh the laddu you made is so sweet and tough bite, 
hi ramesh the laddu you made is so sugary and hard bite, 
hi ramesh the laddu you made is so sugary and tough bite, 
hi ramesh the laddu you made is so sweet and hard bite, 
hi ramesh the laddu you made is so sweet and tough bite]

*/
import java.util.*;
class day86p1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] substitutes = new String[n][2];
        for(int i=0;i<n;i++){
            substitutes[i][0] = sc.next();
            substitutes[i][1] = sc.next();
        }
        Arrays.sort(substitutes,(a,b)->{
            if(a[1].equals(b[0])) return 1;
            else return 0;
        });
        sc.nextLine();
        String line = sc.nextLine();
        System.out.println(getAllSentences(substitutes,n,line));
    }
    static TreeSet<String> getAllSentences(String[][] substitutes,int n,String line){
        
        TreeSet<String> res = new TreeSet<>();
        res.add(line);
        for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            String original = substitutes[i][0];
            String subs = substitutes[i][1];
            List<String> al = new ArrayList<>();
            for(String sentence : res){
                ArrayList<Integer> indices = new ArrayList<>();
                int startInd = sentence.indexOf(original);
                while(startInd!=-1){
                   indices.add(startInd);
                   int temp = startInd;
                   startInd = sentence.indexOf(original,temp+1);
                }
                for(int j=0;j<indices.size();j++)
                al.add(replaceWithSubs(sentence,(int)indices.get(j),original,subs));
            }
            res.addAll(al);
        }
        }
    return res;
    }
    
    static String replaceWithSubs(String sentence,int startInd, String original,String subs){
        return sentence.substring(0,startInd) + subs + sentence.substring(startInd+original.length(),sentence.length());
    }
    
}