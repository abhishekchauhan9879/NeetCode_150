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

    private int preIdx=0;
    private HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;

        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(preorder, 0, n-1);
    }

    private TreeNode build(int[] preOrder, int startIn, int endIn){
        if(startIn > endIn) return null;

        TreeNode root = new TreeNode(preOrder[preIdx++]);
        int idx = map.get(root.val);
        root.left = build(preOrder,startIn,idx -1);
        root.right = build(preOrder, idx+1,endIn);
        
        return root;
    }
}
