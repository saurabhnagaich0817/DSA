/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int m;
    public int diameterOfBinaryTree(TreeNode root) {
         m=0;
        find(root);
       
        return m;
    }
    public int find(TreeNode root){
        if(root==null){
            return 0 ;
        }
        int l=find(root.left);
        int r=find(root.right);
        m=Math.max(m,l+r);
       
        return 1+Math.max(l,r);
      
    }
}