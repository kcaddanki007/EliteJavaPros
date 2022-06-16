import java.util.*;
class day46p2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(maxRepeat(s));
    }
     static int maxRepeat(String s) {
  int start = 1;
  int end = s.length();
  String max = "";
  while (start <= end) {
   int mid = (end+start) / 2;
   String str = getNext(s, mid);
   if (str.isEmpty()) {
    end = mid - 1;
   } else {
       max = str;                
    start = mid + 1;
   }
  }
  return max.length();
 }

 static String getNext(String s, int len) {
  Set<Long> set = new HashSet<>();
  long h = hash(s.substring(0, len));
  set.add(h);
        long pow=1;
        for(int l=1;l<len;l++){
            pow*=26;
        }
  for (int i = 1; i <= s.length()-len; i++) {
            h=nextHash(pow,h,s.charAt(i - 1), s.charAt(i+len-1));
   if (!set.add(h)) {
                return s.substring(i, len + i);
   } 
  }
  return "";
 }

    static long nextHash(long pow,long hash,char left,char right){
        return (hash - left * pow) * 26 + right;
    }
    
 static long hash(String s) {
  long hash = 0;
        long mul=1;
  for (int i = s.length()-1; i >=0; i--) {
   hash += s.charAt(i)*mul;
            mul*=26;
  }
  return hash;
 }   
}