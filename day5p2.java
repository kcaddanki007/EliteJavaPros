//Rotate a two dimensional array with a shift value of S

import java.io.*;
import java.util.*;
import java.lang.*;
class day5p2{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
		  int p = sc.nextInt();
		  int q = sc.nextInt();
		  int s = sc.nextInt();
		  int[][] inp = new int[p][q];
		  int[][] ans = new int[p][q];
		  for(int i=0;i<p;i++){
		      for(int j=0;j<q;j++) inp[i][j] = sc.nextInt();
		  }
		  
		  for(int i=0;i<p;i++){
		      for(int j=0;j<q;j++){
		          int newj = (j+s)%q;
		          int newi = (i+(j+s)/q)%p;
		          ans[newi][newj] = inp[i][j];
		      }
		         
		  }
		  
		  for(int i=0;i<p;i++){
		      for(int j=0;j<q;j++)
		          System.out.print(ans[i][j]+" ");
		      System.out.print("\n");
		  }
		}
}