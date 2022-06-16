/*Mr Nagireddy is working with Binary Trees.
The elements of the tree are given in the level order format.

He is given the root of the binary tree T, to find the most occured STsum(s), if 
there are more than one STsums like that, return all of them as a list.
An STsum is a sub tree sum from a node N, where that node N acts as the root node,
STsum is the sum of all the nodes data of that sub tree of node N.

Your task is to help Nagireddy to find and return the list of STsums, which 
occured more number of times.

Your task is to implement the class Solution:
	- public List<Integer> findFrequentSum(BinaryTreeNode root):
	return a list of integers as result.

NOTE: The Binary Tree T may contain negative values. 	

Input Format:
-------------
Line-1: comma separated integers, level order binary tree

Output Format:
--------------
Print a list of integers in ascending order as result.


Sample Input-1:
---------------
4,-2,5,3,1

Sample Output-1:
----------------
[1,2,3,5,11]


Sample Input-2:
---------------
4,-2,5,3,2

Sample Output-2:
----------------
[3]
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
    static HashMap<Integer,Integer> map = new HashMap<>();
    public List<Integer> findFrequentSum(BinaryTreeNode root) {
        //Implement Your Code here
        int temp = dfs(root);
        int maxFreq = -1;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            maxFreq = Math.max(maxFreq,e.getValue());
        }
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()==maxFreq) ans.add(e.getKey());
        }
        Collections.sort(ans);
        return ans;
        
    }
    public int dfs(BinaryTreeNode root){
        if(root==null) return 0;
        
        int sum=root.data + dfs(root.left) + dfs(root.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}