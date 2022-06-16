/*Mr NOkayya is AI developer, He is given a dictionary, he want to implement a 
an Word-Corrector application that checks user-word and corrects it.

For a given user-word, the Word-Corrector handles two types of validations:

1) If the user-word matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
    Ex-1: dict = ["kmit"], user-word = "KmIt": word-corrector = "kmit"
	Ex-2: dict = ["Kmit"], user-word = "kmit": word-corrector = "Kmit"
	Ex-3: dict = ["kmit"], user-word = "kmit": word-corrector = "kmit"
	
2) If after replacing the vowels of the user-word with any vowel individually,
it matches a word in the dictionary (case-insensitive), 
then the user-word is returned with the matched word in the dictionary.
	Ex-1: dict = ["KmIt"], user-word = "kmet": word-corrector = "KmIt"
	Ex-2: dict = ["KmIt"], user-word = "kmmit": word-corrector = "" (no match)
	Ex-3: dict = ["KmIt"], user-word = "kit": word-corrector = "" (no match)

In addition to the above conditions, the word-corrector app works
with the following precedence rules:
 - When the user-word exactly matches a word in the dictionary (case-sensitive), 
    you should return the same word back.
 - When the user-word matches a word up to validation-1, 
    you should return the first such match in the dictionary.
 - When the user-word matches a word up to validation-2, 
    you should return the first such match in the dictionary.
 - If the user-word has no matches in the dictionary, 
    you should return the empty string.

You are given some user-words[], return a list of words result[], 
where result[i] is the corrected words by the Word-Corrector app for 
user-word = user-words[i].


Input Format:
-------------
Line-1: comma separated strings, dictionary[].
Line-2: comma separated strings, user-words[].

Output Format:
--------------
List of corrected user-words[] by Word-Corrector app.


Sample Input-1:
---------------
LiTe,lite,bare,Bare
lite,Lite,LiTe,Bare,BARE,Bear,bear,leti,leet,leto

Sample Output-1:
----------------
[lite, LiTe, LiTe, Bare, bare, , , LiTe, , LiTe]


Sample Input-2:
---------------
kmit,ngit,kmec
KmOT,NHIT,KMIC

Sample Output-2:
----------------
[kmit, , kmec]
*/

import java.util.*;
class day55p3{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String[] dict = sc.nextLine().split(",");
          String[] strings = sc.nextLine().split(",");
          System.out.println(Arrays.toString(obtainFin(dict,strings)));
		}
		static String[] obtainFin(String[] dict,String[] strings){
		    int m = dict.length,n = strings.length;
		    Set<String> orig = new HashSet<>();
		    HashMap<String,String> changeCase = new LinkedHashMap<>();
		    HashMap<String,String> changeVowel = new LinkedHashMap<>();
		    Set<Character> vowels = new HashSet<>();
		    vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
		    vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
		    String[] ans = new String[n];
		    //Processing dict
		    for(int i=0;i<m;i++){
		        orig.add(dict[i]);
		        
		        String t1 = dict[i].toLowerCase();
		        if(!changeCase.containsKey(t1)) changeCase.put(t1,dict[i]);
		        
		        StringBuilder sb = new StringBuilder();
		        String t2 = dict[i].toLowerCase();
		        for(int j=0;j<t2.length();j++){
		            if(vowels.contains(t2.charAt(j))) sb.append('$');
		            else sb.append(t2.charAt(j));
		        }
		        String key = sb.toString();
		        if(!changeVowel.containsKey(key)) changeVowel.put(key,dict[i]);
		    }
		    //processing strings
		    for(int i=0;i<n;i++){
		        if(orig.contains(strings[i])){
		             ans[i] = strings[i];
		             continue;
		        }
		        else if(changeCase.containsKey(strings[i].toLowerCase())){
		            ans[i] = changeCase.get(strings[i].toLowerCase());
		            continue;
		        }
		        
		         StringBuilder sb = new StringBuilder();
		        String t2 = strings[i].toLowerCase();
		        for(int j=0;j<t2.length();j++){
		            if(vowels.contains(t2.charAt(j))) sb.append('$');
		            else sb.append(t2.charAt(j));
		        }
		        String key = sb.toString();
		        if(changeVowel.containsKey(key)){
		            ans[i] = changeVowel.get(key);
		            continue;
		        }
		        
		        ans[i] = "";
		        
		    }
		    
		    return ans;
		}
}     
 