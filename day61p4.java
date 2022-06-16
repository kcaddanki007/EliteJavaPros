/*Ms Akhila has a habit of reading the words in reverse order.
For Example: if the word is 'hello', she will read it as 'olleh'.

Your task is to help her reading the words in original order.

Note: You have to process each word into reverse order of characaters,
and the given line of words in the original order.

Input Format:
-------------
A line of words as a string S

Output Format:
--------------
Print the processed string S.


Sample Input-1:
---------------
this is EPAM bootcamp

Sample Output-1:
----------------
siht si MAPE pmactoob


Sample Input-2:
---------------
It's My Life

Sample Output-2:
----------------
s'tI yM efiL
*/
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.List;
import java.util.Map;
import java.util.*;

class day61p4
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stream.of(s.split(" "))
        .map(e -> new StringBuilder(e).reverse()+" ")
        .forEach(System.out::print);
    }
}