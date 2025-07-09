import java.util.*;
class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode();
		for(List<Integer> level: helper(tree.getTree())){
			System.out.println(level);
		}
		System.out.println();
		tree.print(tree.getTree());
	}

	public static List<List<Integer>> helper(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = que.size();
			for(int i=0; i<size; i++) {
				TreeNode curr = que.poll();
				level.add(curr.val);
				if(curr.left!=null) {
					que.offer(curr.left);
				}
				if(curr.right!=null) {
					que.offer(curr.right);	
				}
			}
			result.add(level);
		}
		return result;
	}
}