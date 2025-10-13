class DiameterOfBinaryTree {
    public static void main(String[] args) {
    	TreeNode root = new TreeNode().getTree4();
    	System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        maxLen(root);
        return max;
    }
    static int max=0;

    public static int maxLen(TreeNode root) {
        if(root==null) return 0;
        int left = maxLen(root.left);
        int right = maxLen(root.right);
        max = Math.max(max, left + right);
        return 1+Math.max(left,right);
    }
}