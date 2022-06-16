/*In summer training camp, a course is divided into N sessions.
Each session handled by N different trainers, each trainer identified by an alphabet.
At the end of the course, the students are requested to give rating for each
trainer between 1 to N, each trainer should be assigned different rating.

For example, there are 3 trainers, I, J and K, the student can vote them as IJK,
JKI, IKJ..etc. Where IJK means, trainer-I got rating-1, trainer-J got rating-2, 
trainer-K got rating-3.

You have to sort the trainers based on the rating they recieved.
The sorting of the trainers is as follows:
	- The sorting of the trainers is decided by who received the most ratings.
	- If the trainer recieved more 1-ratings, he is in first place, 
	- If two or more trainers tie in the first place, you have to consider 
	the second place to resolve the conflict, if they tie again, we continue
	this process until the ties are resolved.
	- If two or more trainers are still tied after considering all the places, 
	we sort them alphabetically based on the assigned letter.

You will be given an array of ratings by S students in the class. 
Your task is to sort the trainers according to the above rules, and return the
sorted list of N trainers as a string by the rating given to them.

Input Format:
-------------
Line: Space separated strings,ratings given by S students for N faculty, 
      where S is ratings.length and N is ratings[i].length

Output Format:
--------------
Print a String output.


Sample Input-1:
---------------
JKI KIJ KJI IJK IKJ JIK

Sample Output-1:
----------------
IJK

Explanation:
------------
Trainer-I was rated first by 2 students, second by 2 students and third by 2 students.
Trainer-J was rated first by 2 students, second by 2 students and third by 2 students.
Trainer-K was rated first by 2 students, second by 2 students and third by 2 students.
There is a tie and you sort the trainers in ascending order by their IDs.


Sample Input-2:
---------------
PQSR SQRP

Sample Output-2:
----------------
SPQR

Explanation:
------------
Trainer-P was rated first by 1 student, Trainer-S was rated first by 1 student, 
there is a tie. In second place for P and S also a tie, now in third place S 
got rated by one student, and P by none. So, S occupies first place, 
then P occupies second-place, trainer-Q was rated by 2 students next,
so Q took third place, and ramaining trainer-R in the last place.


Sample Input-3:
---------------
K K K K

Sample Output-3:
----------------
K
*/
import java.util.*;
class day58p4{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          String[] strings = sc.nextLine().split(" ");
          int n = strings.length;
          System.out.println(getOrder(strings,n));
		}
		static String getOrder(String[] strings,int n){
		    Map<Character,int[]> map = new HashMap<Character,int[]>();
		    int size = strings[0].length();
		    for(int i=0;i<n;i++){
		        for(int j=0;j<size;j++){
		            char key = strings[i].charAt(j);
		            
		            if(map.containsKey(key)){
		                map.get(key)[j]++;
		            }else{
		                int[] arr = new int[size];
		                arr[j]++;
		                map.put(key,arr);
		            }
		        }
		    }
		   List<Map.Entry<Character,int[]>> list = new ArrayList(map.entrySet());
		   Collections.sort(list,new Comparator<Map.Entry<Character,int[]>>(){
		       public int compare(Map.Entry<Character,int[]> a,Map.Entry<Character,int[]> b){
		           int i=0;
		           while(i<size){
		               if(a.getValue()[i]==b.getValue()[i]) i++;
		               else return Integer.compare(b.getValue()[i],a.getValue()[i]);
		           }
		           return Character.compare(a.getKey(),b.getKey());
		       }
		   });
		   
		   StringBuilder sb = new StringBuilder();
		   for(int i=0;i<size;i++){
		       sb.append(list.get(i).getKey());
		   }
		  return sb.toString();
		}
}     





 