/*Reena has to sent the mails regularly.
She used emphasize any word W based on a given set of words[].
Two emphasize the words she used enclose them with <i> and </i> tag.
The emphasize procedure of the sub-words of W is as follows:
	
	- If two sub-words are intersected with each other, 
	  enclose them with one <i></i> tag.
	
	- If two sub-words are enclosed with <i></i> tag and neighbours also,
	  then merge the sub-words as one and enclose with one <i> </i> tag.

You will be given the word W, and set of words[] to emphasize.
Your task is to help Reena to emphasize the word W.
and print it.

Input Format:
-------------
Line-1: A string W, the word.
Line-2: space separated strings, set of words[].

Output Format:
--------------
Print the string, the emphasized string.

Sample Input-1:
---------------
kmitngit123
it 123

Sample Output-1:
----------------
km<i>it</i>ng<i>it123</i>


Sample Input-2:
---------------
qwertykeypad
qwerty key pad

Sample Output-2:
----------------
<i>qwertykeypad</i>
*/

import java.util.*;
class day40p2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] w=sc.nextLine().split(" ");
        boolean fill[]=new boolean[s.length()];
        Arrays.fill(fill,true);
        for(String k:w){
            int n=k.length();
            int idx=s.indexOf(k,0);
            while(idx!=-1){
                for(int j=idx;j<idx+n;j++){
                    fill[j]=false;
                }
                idx=s.indexOf(k,idx+1);
            }
        }
        boolean flag=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(fill[i]){
                if(flag){
                    sb.append("</i>");
                    flag=false;
                }        
                sb.append(s.charAt(i));
            }else{
                if(flag==false){
                    sb.append("<i>");
                    sb.append(s.charAt(i));
                    flag=true;
                }
                else{
                    sb.append(s.charAt(i));
                }
            }
        }
        if(flag){
            sb.append("</i>");
        }
        System.out.println(sb.toString());
        
    }
}