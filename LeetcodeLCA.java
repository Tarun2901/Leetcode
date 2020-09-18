/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public ArrayList<TreeNode> nodetoroot(TreeNode node, int data, ArrayList<TreeNode> ans)
    {
        if(node==null) return null;
        
        if(node.val==data)
        {
            ArrayList<TreeNode> base = new ArrayList<TreeNode>();
            base.add(node);
            return base;
        }
        
        ArrayList<TreeNode> left = nodetoroot(node.left,data,ans);
        if (left!=null)
        {
            left.add(node);
            return left;
        }
         ArrayList<TreeNode> right = nodetoroot(node.right,data,ans);
        if (right!=null)
        {
            right.add(node);
            return right;
        }
        return null;
    }
    
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<TreeNode>();
        ArrayList<TreeNode> list2 = new ArrayList<TreeNode>();
        list1 = nodetoroot(root,p.val,null);
                list2 = nodetoroot(root,q.val,null);
int i = list1.size()-1;
        int j = list2.size()-1;
        TreeNode LCA  = null;
while(i>=0&&j>=0)
{
    if(list1.get(i)==list2.get(j))
    {
        LCA = list1.get(i);
    }
    i--;
    j--;
}
        return LCA;
    }
}