/*In an english training institute, the trainer Reeta given a task to the trainees.
We know that, in english we have prefixes and suffixes for the words.
You can divide a word as concatenation of prefix and suffix.
i.e., word = prefix + suffix, another = an + other

You will be given a list of prefixes and a statement consisting of words.
Now, the task given to the trainees is as follows:
	- Replace all the words in the statement with the prefix, 
	  if you found prefix of that word in the list.
	- If you found more than one prefix in the list for a word in the statement,
	  replace the word with the prefix that has the shortest length.

Your task is to help the trainees to prepare and print the final statement
after all the replacements done.

Input Format:
-------------
Line-1: Space separated strings, prefixes.
Line-2: A single line of words, statement.

Output Format:
--------------
Print the String, the final statement.


Sample Input-1:
---------------
am add mean ref 
amigos used to address or refer to a friend

Sample Output-1:
----------------
am used to add or ref to a friend


Sample Input-2:
---------------
th the pa tho
thomas the trainer teaches theroy part of thermodynamics

Sample Output-2:
----------------
th th trainer teaches th pa of th
*/

import java.util.*;
public class day15p1{
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
        root = new TrieNode();
        
        String str = sc.nextLine();
        String[] prefix = str.split(" ");
        
        str = sc.nextLine();
        String[] words  = str.split(" ");
        int n = words.length;
        
        String[] ans = new String[n];
        
        for(int i=0;i<prefix.length;i++) insert(prefix[i]);
        
        for(int i=0;i<n;i++){
            boolean flag = false;
            
            for(int j=1;j<=words[i].length();j++){
                if(search(words[i].substring(0,j))){
                    ans[i] = words[i].substring(0,j);
                    flag = true;
                    break;
                }
            }
            
            if(!flag) ans[i] = words[i];
        }
        
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
        
    }
}