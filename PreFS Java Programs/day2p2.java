			//working with system.exit

import java.util.*;
class problem{
        public static void main(String args[]){
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          if(n%2==1){
              int[] arr = new int[n];
              for(i=0;i<n;i++){
                  arr[i]=sc.nextInt();
              }
              for(i=0;i<n;i+=2){
                 if(arr[i]!=arr[++i]){
                     System.out.println(arr[i]);
                     System.exit(0);
                 }
              }
            
            }
 
          else{
              System.exit(0);
          }
    }
}