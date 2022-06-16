/*Mr Rakesh is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is self mirror tree or not.
Can you help Anil to find and return "true" if the given BT is a self mirror tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.
  
NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false
*/
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
    public boolean isSelfMirrorTree(BinaryTreeNode root) {
        // Implement Your Code here..
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque<>();
        adq.offerLast(root);
        
        while(!adq.isEmpty()){
            int adqsize = adq.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<adqsize;i++){
                BinaryTreeNode curr = adq.pollFirst();
                list.add(curr.data);
                if(curr.left!=null) adq.offerLast(curr.left);
                if(curr.right!=null) adq.offerLast(curr.right);
                
            }
                for(int i=0;i<(list.size()+1)/2;i++)
                    if(list.get(i) != list.get(list.size()-1-i)) return false;
        }
        return true;
    }
}

