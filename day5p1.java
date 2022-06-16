//Level Order question
//Levels starts with 0
//Even levels should have odd elements and should be in increasing order only
//Odd levels should have even elements and should be in decreasing order only
//If it matches, print true otherwise print false

/*
//TreeNode Structure for Your Reference..

class BinaryTreeNode{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}

*/
import java.util.*;
import java.lang.*;
class Solution {
    public boolean isXmasTree(BinaryTreeNode root) {
        // Implement Your Code here..
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque<>();
        
        adq.offer(root);    
        boolean evenLev = true;
        
        while(!adq.isEmpty()){
            
            int adqsize = adq.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<adqsize;i++){
                BinaryTreeNode curr = adq.pollFirst();
                list.add(curr.data);
                if(curr.left!=null && curr.left.data!=-1) adq.offer(curr.left);
                if(curr.right!=null && curr.right.data!=-1) adq.offer(curr.right);
            }
            
             System.out.println(evenLev);
             System.out.println(list);
                if(evenLev){
                    for(int i=1; i<list.size();i++){
                         if(list.get(i)%2 == 0 || list.get(i)<=list.get(i-1))  return false;
                    }  
                }else{
                    for(int i=1; i<list.size();i++){
                          if(list.get(i)%2!=0 || list.get(i)>=list.get(i-1)) return false;
                    } 
            }
            evenLev = !evenLev;
        }
        return true;
    }
}