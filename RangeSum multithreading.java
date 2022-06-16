import java.io.*; 
import java.util.*;
import java.util.concurrent.*;
import java.lang.*;

public class RangeSum {
    public static void main(String[] args) throws Exception
    {    //Implement your code here
        
        // read set of integers input
        File file = new File("MyFile.txt");
        Scanner sc1 = new Scanner(file);
        String[] list=sc1.nextLine().split(" ");
        int numbers[]=new int[list.length];

        for(int i=0;i<list.length;i++)
            numbers[i]=Integer.parseInt(list[i]);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][2];
        {
            for(int i=0;i<n;i++)
            {
                mat[i][0] = sc.nextInt();
                mat[i][1] = sc.nextInt();
            }
        }
        int sum=0;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) 
        {
            callable c = new callable(mat[i][0],mat[i][1],numbers);
            Future<Integer> ans = executor.submit(c);
            sum+=ans.get();
        }
        executor.shutdown();
        System.out.println(sum);
    }
}
class callable implements Callable<Integer>
{
    private Integer n1,n2;
    private int[] a;
 
  public callable(Integer n1,Integer n2,int[] a) {
    this.n1 = n1;
    this.n2 = n2;
    this.a = a;
  }
  public Integer call() throws Exception {
    int sum = 0;
    for(int i=n1;i<=n2;i++)
        sum+=a[i];
    return sum;
  }
}