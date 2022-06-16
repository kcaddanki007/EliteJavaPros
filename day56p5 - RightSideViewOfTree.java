/*
Balbir singh is working with Binary Trees.
The elements of the tree is given in the level order format.
Balbir is looking the tree from right side. 
So, he can view only rihtmost nodes only (one node per level).

You will be given the root of the binary tree.
Your task is to find the nodes which can be viewed by Balbir from right side.
And print the nodes from top to bottom order.

Your task is to implement the class Solution:
	- public List<Integer> rightSideView(BinaryTreeNode root):
	return the list of node values.
	
NOTE: 
Please do consider the node with data '-1' as null node in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
1 2 3 5 -1 -1 5

Sample Output-1:
----------------
[1, 3, 5]



Sample Input-2:
---------------
3 2 4 3 2

Sample Output-2:
----------------
[3, 4, 2]

*/
import java.util.*;

/*
    //Structure of BinaryTreeNode for your reference.

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
    public List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> al = new ArrayList<>();
        if(root==null || root.data==-1) return al;
        ArrayDeque<BinaryTreeNode> adq = new ArrayDeque<>();
        adq.offerLast(root);
        while(!adq.isEmpty()){
            al.add(adq.peekLast().data);
            int adqsize = adq.size();
            for(int i=0;i<adqsize;i++){
                BinaryTreeNode r = adq.pollFirst();
                if(!(r.left == null || r.left.data==-1)) adq.offer(r.left);
                if(!(r.right == null || r.right.data==-1)) adq.offer(r.right);
            }
        }
        return al;
    }
}
