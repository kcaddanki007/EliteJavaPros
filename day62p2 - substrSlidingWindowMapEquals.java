/*You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]
*/
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        System.out.println(getMapping(w1,w2));
    }
    static List<Integer> getMapping(String w1,String w2){
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character,Integer> w2map = new HashMap<>();
        for(int i=0;i<w2.length();i++) 
           w2map.put(w2.charAt(i),w2map.getOrDefault(w2.charAt(i),0)+1);
           
        HashMap<Character,Integer> w1map = new HashMap<>();
        for(int i=0;i<w2.length();i++)
           w1map.put(w1.charAt(i),w1map.getOrDefault(w1.charAt(i),0)+1);
           
        if(w1map.equals(w2map)) res.add(0);
        
        int n = w1.length()-w2.length();
        int m = w2.length()-1;
        for(int i=1;i<=n;i++){
            w1map.put(w1.charAt(i-1),w1map.get(w1.charAt(i-1))-1);
            if(w1map.get(w1.charAt(i-1))==0)  w1map.remove(w1.charAt(i-1));
            w1map.put(w1.charAt(i+m),w1map.getOrDefault(w1.charAt(i+m),0)+1);
            
            if(w1map.equals(w2map)) res.add(i);
            
        }
        return res;
    }
}