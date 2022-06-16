/*A set of computers connected with each other and formed a network with the 
following rule, one computer can directly connected with atmost two computers only.
Each computer is assigned with an ID, the computer ID's may be repeated.

A pair of two different computers (must be leaf nodes) of the network is said to
be NICE, if the shortest distance between theose computers is less than or 
equal to 'D'.

You are given the entire network as a tree, and an integer 'D'.
Your task is to return the number of NICE Pairs in the given network.

Implement the class Solution:
   1. public String numberOfPairs(BinaryTreeNode root, int D) : 
      returns an integer.

NOTE: in the input tree, consider -1 as 'No Connection' (NULL node).


Input Format:
-------------
Line-1: space separated integers, network ID's in the form the tree.
Line-2: An integer, D

Output Format:
--------------
Print an integer, number of NICE pairs.


Sample Input-1:
---------------
2 3 4 -1 5
3

Sample Output-1:
----------------
1

Explanation:
------------
The computer at the leaf nodes in the network are 4 and 5 and the shortest 
distance between them is 3. This is the only NICE pair.


Sample Input-2:
---------------
2 5 3 4 3 7 5
3

Sample Output-2:
----------------
2

Explanation:
------------
The NICE pairs in the network are [4,3] and [7,5] and the shortest 
distance between them is 2. This is the only NICE pair.
*/
import java.util.*;

/*
// for reference
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
    static int res=0;
   public int numberOfPairs(BinaryTreeNode root, int dist) {
        // Implement Your code here.
        findPoss(root,dist);
        return res;
    }
    public List<Integer> findPoss(BinaryTreeNode root, int d){
        if(root==null || root.data==-1) 
          return new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        List<Integer> lal = findPoss(root.left,d);
        List<Integer> ral = findPoss(root.right,d);
        if(lal.size()==0 && ral.size()==0) 
          return new ArrayList<>(Arrays.asList(1));
        for(int l:lal){
            for(int r:ral){
                if(l+r<=d) res++;
            }
        }
        for(int l:lal){
            al.add(l+1);
        }
        for(int r:ral){
            al.add(r+1);
        }
        return al;
    }
}