/*VishnuVardan is working with Binary Trees.
He wants to find all the sub trees with following conditions:
    - A single node is also considered as a tree with no childs. 
    - If the root node value of th tree is X, then all the node values 
    in that tree should be X.

Your task is to help VishnuVardan to find the number of sub trees are there 
in the given tree with the given terms.

Your task is to implement the class Solution:
	- public int countSubtrees(BinaryTreeNode root)
	return an integer result.

NOTE: Please do consider node with value -1 as null node.


Input Format:
-------------
Space separated integers, nodes of the tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,1,2,1,1,2,2

Sample Output-1:
----------------
6


Sample Input-2:
---------------
1,2,3,4,5,6,7

Sample Output-2:
----------------
4

For explanation look at the hint.
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
    static int count = 0;
    public int countSubtrees(BinaryTreeNode root) {
        //implement your code here
    int val = value(root);
    return count;
    }
    static int value(BinaryTreeNode root){
        if((root.left==null || root.left.data==-1) && (root.right==null || root.right.data==-1)){
            count++;
            return root.data;
        } 
        int leftval = -1;
        int rightval = -1;
        if(root.left!=null && root.left.data!=-1) leftval = value(root.left);
        else leftval = root.data;
        if(root.right!=null && root.right.data!=-1) rightval = value(root.right);
        else rightval = root.data;
        
        if(leftval!=-1 && rightval!=-1 && leftval==rightval && leftval==root.data){
            count++;
            return root.data;
        }
        return -1;
    }
}