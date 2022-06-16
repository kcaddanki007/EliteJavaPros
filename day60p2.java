import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Set;
import java.util.Map;
import java.util.*;

class Test
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] chars = s.split("");
        Stream.of(chars)
                .collect(Collectors.groupingBy(e->e,TreeMap:: new,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a,b)-> b.compareTo(a)))
                .map(e->{
                    StringBuilder str = new StringBuilder();
                    for(int i=0;i<e.getValue();i++)
                        str.append(e.getKey());
                    return str.toString();
                })
                .forEach(System.out::print);
    }
}