/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {//Tc=o(h) SC=o(1) Iterative appraoch
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val)root=root.left;
            else if(p.val>root.val && q.val>root.val)root=root.right;
            else return root;
        }
        return null;
    }
}
//Recursive approach TC=o(h) SC=o(h)
// if(root==null)return null;
// if(p.val<root.val && q.val<root.val)return fun(root.left,p,q);
// if(p.val>root.val && q.val>root.val)return fun(root.right,p,q);
// return root; 