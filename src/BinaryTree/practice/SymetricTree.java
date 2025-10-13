public class SymetricTree{
    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        System.out.println(isSymmetric(tree.getTree()));
    }

    public static boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    public static boolean helper(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        if((left==null && right!=null) || (left!=null && right==null) || (left.val!=right.val)) {
            return false;
        }
        
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}