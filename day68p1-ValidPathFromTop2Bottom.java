/*Mr Nagireddy is working with Binary Trees.
The elements of the tree is given in the level order format.
He is given a sequence of integers as an array, seq[].

You will be given the root of the binary tree.
Your task is to help Nagireddy to find the seq[] is a valid path from root node
to the last node in that tree, the order of elements in seq[] shoud be followed
i.e.,Last Node means, there should be no child to the node.


Your task is to implement the class Solution:
	- public boolean isValidSequence(BinaryTreeNode root, int seq[]):
	return a boolean result.
	
NOTE: 
Please do consider the node with data '-1' as null node in the given trees.


Input Format:
-------------
Line-1: comma separated integers, level order binary tree
Line-2: comma separated integers, a sequence

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
0,1,0,2,0,0,-1,-1,3,0,0
0,1,2,3

Sample Output-1:
----------------
true


Sample Input-2:
---------------
0,1,2,3,4,5,6,7,8,9,10
0,1,3

Sample Output-2:
----------------
false
*/
import java.util.*;

/*
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

class Solution {
    public boolean isValidSequence(BinaryTreeNode root, int[] seq) {
        //Implement Your Code here
        // if(root==null || root.data == -1) return false;
        int i=0;
        int n = seq.length;
        BinaryTreeNode curr = root;
        while(i<n){
            if(curr==null || curr.data!=seq[i]) return false;
            i++;
            
            BinaryTreeNode temp = curr;
            if(curr.left!=null && curr.left.data!=-1 && i<n &&curr.left.data==seq[i]){  
                curr=curr.left;
                //System.out.println("movedleft");
            }
            else if(curr.right!=null && curr.right.data!=-1 && i<n && curr.right.data==seq[i]){
                curr = curr.right;
                //System.out.println("movedleft");
                
            }
            
            
            if(i<n && temp == curr){
                //System.out.println("eqfalse");
                 return false;
            }
            if(i==n && ((curr.right!=null && curr.right.data!=-1)||(curr.left!=null && curr.left.data!=-1)))
              return false;
        }
        return true;
    }
}