/*At university of Chicago a Computer Science programing faculty as a part of 
teaching passion, in order to make newly joined students more enthusiastic 
in learning the subject he is given a problem at the first day of semester.
The student who solved it first, will be awarded with a cash prize. In regard 
to this he asked the students to work on concept related to strings, he gave a 
task to read a word and find the count of all the turn of phrases of the word, 
and the phrases should be distinct.

Now it’s your time to create a method which satisfies the above program.
The turn of phrases of a word is obtained by deleting 
any number of characters (possibly zero) from the front of the word and
any number of characters (possibly zero) from the back of the word.

Input Format:
-------------
A single string, the word contains only lowercase alphabets [a-z].

Output Format:
--------------
Print an integer, number of distinct phrases possible.


Sample Input-1:
---------------
aabbaba

Sample Output-1:
----------------
21

Explanation:
-------------
The turn of phrases of the word, which are distinct as follows:
a, b, aa, bb, ab, ba, aab, abb, bab, bba, aba, aabb, abba, bbab, baba, 
aabba, abbab, bbaba, aabbab, abbaba, aabbaba


Sample Input-2:
---------------
kmithyd

Sample Output-2:
----------------
28
*/
import java.util.*;
public class day11p1{
    static TrieNode root;
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
         
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    };
   
    static void insert(String key){
        int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++){
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }
    
    static boolean search(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++){
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.isEndOfWord);
    }
    
    
     public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        root = new TrieNode();
        int count = 0;
    
        for (int i = 0; i < str.length() ; i++){
            for(int j=i+1;j<=str.length(); j++){
                if(!search(str.substring(i,j))){
                insert(str.substring(i,j));
                count++;
                }
            }
        }

    System.out.println(count);
    }
}