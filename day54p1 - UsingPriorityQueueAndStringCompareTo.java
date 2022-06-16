/*Sridhar brought his latest Apple iPhone 12 pro. He started his conversation 
with one of his friend on WhatsApp with list of words.

Now it’s our task to find and return what are the most common words 
in the list of words he used in sorted order based on occurrence from 
largest to smallest. If any of words he used are having same occurrence 
then consider the lexicographic order.

You will be given a list of words, you need to print top P number of 
most common used words as described in the statement. 

Input Format:
-------------
Line-1: comma separated line of words, list of words.
Line-2: An integer P, number of words to display. 

Output Format:
--------------
Print P number of most common used words.


Sample Input-1:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
3

Sample Output-1:
----------------
[are, case, egg]



Sample Input-2:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
3

Sample Output-2:
----------------
[are, egg, case]
*/

import java.util.*;
class day54p1{
        public static void main(String args[]){
		  Scanner sc = new Scanner(System.in);
          String[] words = sc.nextLine().split(",");
          int n = words.length;
          int p = sc.nextInt();
		  System.out.println(getMaxWords(words,n,p));
		}
		static ArrayList<String> getMaxWords(String[] words,int n,int p){
		    HashMap<String,Integer> map = new HashMap<>();
		    for(int i=0;i<n;i++)
		       map.put(words[i],map.getOrDefault(words[i],0)+1);
		    Queue<String[]> pq = new PriorityQueue<>((a,b)->{
		        int a1 = Integer.parseInt(a[1]);
		        int b1 = Integer.parseInt(b[1]);
		        if(a1==b1) return a[0].compareTo(b[0]);
		        else return Integer.compare(b1,a1);
		    });
		    for(Map.Entry<String,Integer> e : map.entrySet()){
		        pq.offer(new String[]{e.getKey(),""+e.getValue()});
		    }
		    ArrayList<String> ans = new ArrayList<>();
		    for(int i=0;i<p;i++){
		        ans.add(pq.poll()[0]);
		    }
		    return ans;
		}
}     
 