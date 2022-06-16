/*A set of computers connected with each other and formed a network with the 
following rule, one computer can directly connected with atmost two computers only.
Each computer is assigned with an ID, the computer ID's may be repeated.

You are given the entire network as a tree.
Your task is to transform the network into a single row of computers,
The transformin process follows the below order:
    - For transformation, use the same network tree structure.
    - The transformation should be done in the pre-order format of the tree.
    - In the network tree, the right computer points to the next computer 
      and the left computer connected to no computer.
    
Implement the class Solution:
   1. public void transform(BinaryTreeNode root) : transform the tree.

NOTE: in the input tree, consider -1 as 'No Connection'.


Input Format:
-------------
Single line of space separated integers, network ID's in the form the tree.

Output Format:
--------------
Print a string, as described in sample.


Sample Input-1:
---------------
1 2 3 4 5 6 7

Sample Output-1:
----------------
1 2 4 5 3 6 7

Explanation:
------------
Look at the hint for unerstanding
*/
import java.util.*;

/*
Tree structure for reference
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
    static ArrayDeque<BinaryTreeNode> adq = new ArrayDeque<>();
	public void transform(BinaryTreeNode root) {
        //implement your code here.
        if(root==null) return;
        fillQueue(root);
        //System.out.println(adq.size());
        root = adq.pollFirst();
        BinaryTreeNode curr = root;
        while(!adq.isEmpty()){
            curr.right=adq.pollFirst();
            curr.left = null;
            curr = curr.right;
        }
	}
	public void fillQueue(BinaryTreeNode root){
	    if(root==null || root.data == -1) return;
	    adq.offer(root);
	    fillQueue(root.left);
	    fillQueue(root.right);
	}
}