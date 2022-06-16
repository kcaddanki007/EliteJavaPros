/*Bheemla is working with Binary Trees.
The elements of the tree is given in the level order format.
Bheemla likes to print the nodes of the tree line by line.

You will be given the root of the binary tree.
Your task is to help Bheemla to print the nodes according to his wish. 
Look at the hint for understanding.

Your task is to implement the class Solution:
	- public List<List<Integer>> printTheLines(BinaryTreeNode root):
	return the list of node values.
	
NOTE: 
Please do consider the node with data '-1' as null node in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print the list of list of integers


Sample Input-1:
---------------
1 2 3 4 5 6 7

Sample Output-1:
----------------
[[4],[2],[1,5,6],[3],[7]]



Sample Input-2:
---------------
3 2 -1 1 -1 -1 -1 4 5

Sample Output-2:
----------------
[[4],[1],[2,5],[3]]

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
class Node
{
    BinaryTreeNode t;
    int val;
    Node(BinaryTreeNode t,int val)
    {
        this.t = t;
        this.val = val;
    }
}
class Solution {
    static TreeMap<Integer,List<Integer>> hm = new TreeMap<>();
    static int val=0;
    public List<List<Integer>> printTheLines(BinaryTreeNode root) {
        // implement your code here.
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(root,0));
        while(!q.isEmpty())
        {
            int len = q.size();
            for(int i=0;i<len;i++)
            {
                Node cur = q.pollFirst();
                if(!hm.containsKey(cur.val))
                    hm.put(cur.val,new ArrayList<>());
                hm.get(cur.val).add(cur.t.data);
                if(cur.t.left != null && cur.t.left.data!=-1)
                    q.offerLast(new Node(cur.t.left,cur.val-1));
                if(cur.t.right != null && cur.t.right.data!=-1)
                    q.offerLast(new Node(cur.t.right,cur.val+1));    
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Integer i : hm.keySet())
            res.add(hm.get(i));
        return res;
    }
}
