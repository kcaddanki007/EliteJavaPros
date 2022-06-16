import java.lang.*;
import java.util.*;

class Test
{
    
    static String cmp  = "aeiou*";
    static int max = Integer.MIN_VALUE,len;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        len =s.length();
        getMax(s,0,0,0);
        System.out.println(max);
    }
    public static void getMax(String s,int count,int ind,int cur)
    {
        //System.out.println(count+" "+ind+" "+cur);
        if(ind>=len)
        {
            //System.out.println("basic if");
            if(cur==4)
                max = Math.max(count,max);
            return;
        }
        else if(count==0)
        {
            //System.out.println("count=0");
            if(s.charAt(ind)!='a')
            {
                getMax(s,0,ind+1,0);
                return;
            }
            else
            {
                getMax(s,1,ind+1,0);
                return;
            }
        }
        else if(s.charAt(ind)==cmp.charAt(cur))
        {
            //System.out.println("match");
            getMax(s,count+1,ind+1,cur);
            return;
        }
        else if(s.charAt(ind)==cmp.charAt(cur+1))
        {
            //System.out.println("match but next");
            getMax(s,count+1,ind+1,cur+1);
            getMax(s,count,ind+1,cur);
            return;
        }
        else
        {
            //System.out.println("else");
            getMax(s,count,ind+1,cur);
        }
    }
}