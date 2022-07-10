/*Crazy Mohan is the head master of a school.
    2 He do the things differently. All the students in the school,
    3 formed as a grid for the assembly.
    4 
    5 Crazy Mohan asked them to stand in sorted order of thier heights diagonally, 
    6 in order to make the assembly look more unique. The students started arranging 
    7 themselves according to their heights.
    8 
    9 You will be given initial order of the assembly, heights of the students.
   10 Now it is your task to find the final state of the assembly of students and print it.
   11 
   12 Input Format:
   13 -------------
   14 Line-1: Two space separated integers M and N, Size of the Grid
   15 Next M lines: N space separated integers, heights of the students.
   16 
   17 Output Format:
   18 --------------
   19 Print the rid of integers, final state of the assembly.
   20 
   21 
   22 Sample Input-1:
   23 ---------------
   24 3 4
   25 2 8 5 2
   26 10 9 10 9
   27 1 5 8 5
   28 
   29 Sample Output-1:
   30 ----------------
   31 2 5 5 2
   32 5 8 8 9
   33 1 10 9 10
   34 
   35 
   36 Sample Input-2:
   37 ---------------
   38 4 6
   39 10 9 10 7 5 9
   40 5 4 9 9 10 10
   41 8 8 1 9 5 2
   42 1 2 1 5 9 9
   43 
   44 Sample Output-2:
   45 ----------------
   46 1 9 5 2 5 9
   47 1 4 9 9 7 10
   48 2 5 5 9 9 10
   49 1 8 8 10 9 10
   50 
   51 
   */
    1 import java.util.*;
    2 class day89p3{
    3     public static void main(String[] args){
    4         Scanner sc = new Scanner(System.in);
    5         int m = sc.nextInt();
    6         int n = sc.nextInt();
    7         int[][] arr = new int[m][n];
    8         for(int i=0;i<m;i++){
    9             for(int j=0;j<n;j++){
   10                 arr[i][j] = sc.nextInt();
   11             }
   12         }
   13         printDiagonallySorted(arr,m,n);
   14     }
   15     static void printDiagonallySorted(int[][] arr,int m,int n){
   16         for(int j=0;j<n;j++){
   17             int tj=j,ti=0;
   18             ArrayList<Integer> al = new ArrayList<>();
   19             while(ti<m && tj<n){
   20                 al.add(arr[ti][tj]);
   21                 ti++;
   22                 tj++;
   23             }
   24             Collections.sort(al);
   25             tj=j;
   26             ti=0;
   27             int alInd = 0;
   28             while(ti<m && tj<n){
   29                 arr[ti][tj] = al.get(alInd);
   30                 ti++;
   31                 tj++;
   32                 alInd++;
   33             }
   34         }
   35         for(int i=1;i<m;i++){
   36             int ti=i,tj=0;
   37             ArrayList<Integer> al = new ArrayList<>();
   38             while(ti<m && tj<n){
   39                 al.add(arr[ti][tj]);
   40                 ti++;
   41                 tj++;
   42             }
   43             Collections.sort(al);
   44             ti = i;
   45             tj=0;
   46             int alInd=0;
   47             while(ti<m && tj<n){
   48                 arr[ti][tj] = al.get(alInd);
   49                 alInd++;
   50                 ti++;
   51                 tj++;
   52             }
   53         }
   54         for(int i=0;i<m;i++)
   55            System.out.println(Arrays.toString(arr[i]));
   56     }
   57 }