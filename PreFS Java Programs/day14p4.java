/*
Chitti(ROBO) is busy in turning the people into chittis(ROBOS) by surrounding them.
In a room there are n*n boxes occupied by ROBOS and people.
   1.A person will be turned into ROBO if he is surrounded by all ROBOs. 
   2.A person will not be turned into ROBO if he is on the edge of the room
     and all the connected people to him (directly or indirectly) are also not
     to be turned.
 Return the n*n boxes after conversion.
 
Input Format
-------------
Line-1:integer n represent the n*n boxes of the room..
Next n lines:Each line of string consists of combination of 'X'(represents ROBO)
and 'O'(represents a person)
   
Output Format:
--------------
Print n*n space seperated values after conversion.
  
   
Sample Input-1:
---------------
4
XXXX
XOOX
XXOX
OXXX
   
Sample Output-1:
----------------
X X X X 
X X X X 
X X X X 
O X X X 
   
Explanation:
------------
The people at second row and third row are converted to ROBOs as they are
surrounded by ROBOs.
But the person at fourth row is safe as he is on edge.
  
   
Sample Input-2:
---------------
 5
XOOOX
XXXXX
XOXXX
XXXOX
OXXXX
  
Sample Output-2:
----------------
X O O O X 
X X X X X 
X X X X X 
X X X X X 
O X X X X 

 */
 
 import java.util.*;
import java.lang.*;

class day14p4{
    
    static int find(int r, int c,int parent[][]){
        int a = r*1000+c;
        if(parent[r][c]==a){
            return a;
        }
        else{
           return parent[r][c]=find(parent[r][c]/1000,parent[r][c]%1000,parent);
        }
    }
    

    static void union(int r1,int c1,int r2, int c2,int[][] parent){
        int small = find(r1,c1,parent);
        int smallPlus1 = find(r2,c2,parent);
        if(small!=smallPlus1){
            int r = smallPlus1/1000;
            int c = smallPlus1%1000;
            parent[r][c] = small;
        }
    }
    
    
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          char[][] input = new char[n][n];
          int[][] parent = new int[n][n];
          
          
          //initialising input and parent
          for(int i=0;i<n;i++){
              String S = sc.next();
              input[i] = S.toCharArray();
              
              for(int j=0;j<n;j++){
                  parent[i][j] = i*1000+j;
              }
          }
          
          //unionising
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  if(input[i][j]=='O'){
                      
                      //down
                      if(i+1 < n){
                          if(input[i+1][j]=='O'){
                             union(i,j,i+1,j,parent);
                         }
                      }
                       //right
                      if(j+1 < n){
                          if(input[i][j+1]=='O'){
                             union(i,j,i,j+1,parent);
                         }
                      }
                      
                    
                      //left
                      if(j-1 >= 0){
                          if(input[i][j-1]=='O'){
                             union(i,j,i,j-1,parent);
                         }
                      }
                      
                      //up
                      if(i-1 >= 0){
                         if(input[i-1][j]=='O'){
                            union(i,j,i-1,j,parent);
                    
                         }
                      }
                      
                  
                  }
              }
          }
          
          
          //changing the input based on DSU
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  if(input[i][j]=='O'){
                  if(parent[i][j]/1000 == 0 || parent[i][j]%1000 == 0 || parent[i][j]/1000 == n-1 || parent[i][j]%1000 == n-1){
                      input[i][j]='O';
                  }
                  else{
                      input[i][j]='X';
                  }
                }  
              }
          }
          
        //   System.out.println();
        //   for(int i=0;i<n;i++){
        //       for(int j=0;j<n;j++){
        //           System.out.print(parent[i][j]+" ");
        //       }
        //       System.out.println();
        //   }
        //   System.out.println();
          
          for(int i=0;i<n;i++){
              for(int j=0;j<n;j++){
                  System.out.print(input[i][j]+" ");
              }
              System.out.println();
          }
          
          
		  
	}	 
}        