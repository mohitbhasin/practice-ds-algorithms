import java.util.*;


class BinaryTreeCameras {
	public static void main(String[] args) {
        List<TreeNode> treeList = new ArrayList<>();
        TreeNode tree = new TreeNode();
        treeList.add(tree.getTree());

        for(TreeNode root: treeList) {
            System.out.println(minCameraCover(root));
        }
    }

   public static int minCameraCover(TreeNode root) {
        count=0;
        return getStatus(root)==0 ? count+1 : count;
    }
    static int count;

    // status = 0 (coverage strictly needed)
    // status = 1 (has camera)
    // status = 2 (covered)
    public static int getStatus(TreeNode root) {
        if(root==null) {
            return 2;
        }
        int left = getStatus(root.left);
        int right = getStatus(root.right);
        if(left == 0 || right==0) {
            count++;
            return 1;
        } 
        if(left==1 || right==1) {
            return 2;
        }
        return 0;
    }
}