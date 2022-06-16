/*
Balbir singh is working with Binary Trees.
The elements of the tree is given in the level order format.
Balbir has a task to split the tree into two parts by removing only one edge
in the tree,such that the product of sums of both the sub-trees should be maximum.

You will be given the root of the binary tree.
Your task is to help the Balbir singh to split the binary tree as specified.
print the product value, as the prouct may be large, print product%1000000007

Your task is to implement the class Solution:
	- public boolean maxProduct(BinaryTreeNode root):
	return an integer value, the product % 1000000007.
	
NOTE: 
Please do consider the node with data as '-1' as null in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
1 2 4 3 5 6

Sample Output-1:
----------------
110

Explanation:
------------
if you split the tree by removing edge between 1 and 4, 
then the sums of two trees are 11 and 10. So, the max product is 110.


Sample Input-2:
---------------
3 2 4 3 2 -1 6

Sample Output-2:
----------------
100
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
    Set<Long> set = new HashSet<>();
    public int maxProduct(BinaryTreeNode root) {
        long totalsum = dfs(root);
        long maxProd = 0;
        for(Long a : set){
            Long b = totalsum-a;
            //System.out.println("a:"+a+" b:"+b);
            maxProd = Math.max(maxProd,a*b);
        }
        return (int)(maxProd%1000000007);
    }
    public long dfs(BinaryTreeNode root){
        if(root==null) return 0;
        
        long sum=root.data + dfs(root.left) + dfs(root.right);
        set.add(sum);
        return sum;
    }
}