import java.util.*;

class InorderSuccessorInBST {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		TreeNode root = tree.bstNode();


//			      6
//			   /    \
//			  2      8
//       	 / \    / \
//			0   4  7   9
//       	   / \
//			  3   5
		List<TreeNode> list = new ArrayList<>();
		list.add(new TreeNode(4));
		list.add(new TreeNode(5));
		list.add(new TreeNode(2));
		list.add(new TreeNode(1));
		
		for(TreeNode p: list) {
			TreeNode result = inorderSuccessor(root, p);
			System.out.println(result);
		}
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        TreeNode curr = root;
        
        while(curr!=null) {
            if(curr.val>p.val) {
                successor=curr;
                curr=curr.left;
            } else {
                curr=curr.right;
            }
        }
        return successor;
    }
}