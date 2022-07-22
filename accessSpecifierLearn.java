/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

public class Main{
   final int hello;
   Main(String first_name, int your_age){  //constructor with string and age
       String fname = first_name;
       int age = your_age;
       hello = 3;
       System.out.println("\nThe name entered is " + fname);
       System.out.println("Your are " + age + " years old.");
   }
 
   Main(){
       this.hello = 3;
       System.out.println("\nWelcome dear customer");  //constructor with no parameters
   }
   
   public static void main(String args[]){
       FixedDeposit acct = new FixedDeposit();
   }
}
 
class FixedDeposit extends Main{
 
   FixedDeposit(){
 
       //super(); // calling the no-arg constructor in the base class
       double APY = 12.5;
       System.out.println("Your current interest rate is " + APY + "%");
   }
}

