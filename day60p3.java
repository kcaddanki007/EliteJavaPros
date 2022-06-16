import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.List;
import java.util.Map;
import java.util.*;

class Test
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
            ans.add(sc.nextInt());
        List<Integer> res = ans.stream()
                            .collect(Collectors.groupingBy(e->e,TreeMap:: new,Collectors.counting()))
                            .entrySet().stream()
                            .sorted(Map.Entry.comparingByValue((a,b)-> b.compareTo(a)))
                            .map(e ->e.getKey())
                            .limit(k)
                            .collect(Collectors.toList());
        System.out.println(res);
    }
}