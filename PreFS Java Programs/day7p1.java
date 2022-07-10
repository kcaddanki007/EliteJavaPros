/*Special numbers are numbers whose only prime factors are 2, 3 or 5. 
The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 Special numbers. 
By convention, 1 is included.

You are given a number n, the task is to find n-th Special number.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print N-th Special Number.


Sample Input-1:
---------------
7

Sample Output-1:
----------------
8


Sample Input-2:
---------------
15

Sample Output-2:
----------------
24
*/

//using functions within functions to create outputs

import java.util.*;
import java.lang.*;
class day7p1{

	static int maxDivide(int a, int b)
	{
		while (a % b == 0)
			a = a / b;
		return a;
	}

	static int isUgly(int no)
	{
		no = maxDivide(no, 2);
		no = maxDivide(no, 3);
		no = maxDivide(no, 5);

		return (no == 1) ? 1 : 0;
	}

	
	static int getNthUglyNo(int n)
	{
		int i = 1;
		int count = 1;

		while (n > count) {
			i++;
			if (isUgly(i) == 1)
				count++;
		}
		return i;
	}

	public static void main(String args[])
	{
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int no = getNthUglyNo(n);
		System.out.println(no);
	}
}

