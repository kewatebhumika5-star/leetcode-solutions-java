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

    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {

        totalSum = treeSum(root);

        subtreeSum(root);

        return (int)(maxProduct % MOD);
    }

   
    private long treeSum(TreeNode node) {
        if (node == null)
            return 0;

        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    private long subtreeSum(TreeNode node) {
        if (node == null)
            return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long currentSum = node.val + left + right;

        long product = currentSum * (totalSum - currentSum);

        maxProduct = Math.max(maxProduct, product);

        return currentSum;
    }
}
