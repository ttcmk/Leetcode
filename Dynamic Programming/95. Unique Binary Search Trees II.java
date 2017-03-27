/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 1. 用一个arraylist来存所有可能的二叉树。
 2. 用递归的思想，每次先求小于i的所有数能组成的左子树组成的list；再求大于i的所有数能组成的右子树组成的list；
 3. 令i为root，则所有可能的子树的可能情况有左子树list * 右子树list，即两个for循环；
 4. 递归的返回条件是start与end相等时，为就是自己；start大于end时，不再有右子树，返回null；
 */
 
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return genTree(1,n);
    }
    
    public List<TreeNode> genTree(int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();
        
        if(start > end){
            list.add(null);
            return list;
        }
        
        if(start == end){
            TreeNode treeNode = new TreeNode(start);
            list.add(treeNode);
            return list;
        }
        
        for(int i=start;i<=end;i++){
            List<TreeNode> leftTree = genTree(start,i-1);
            List<TreeNode> rightTree = genTree(i+1,end);
            
            for(TreeNode leftNode: leftTree){
                for(TreeNode rightNode: rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
