import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return val+"";
	}

	public void print(TreeNode t) {
		if(t==null) return;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> level;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(t);
		int size=1;
		while(!q.isEmpty()) {
			size=q.size();
			level = new ArrayList<>();
			for(int i=0; i<size; i++) {
				TreeNode temp = q.poll();
				level.add(temp.val);
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
			result.add(level);
		}

		
		for(List<Integer> l : result) System.out.println(l);

	}

	public TreeNode() {

	}
	public TreeNode getTree() {
		// iorder - 
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.right = new TreeNode(31);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(11);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		return root;
	}

	public TreeNode getTree2() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(6);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(3);
		return root;
	}
	public TreeNode getTree3() {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.right.right = new TreeNode(2);
		return root;
	}
	public TreeNode getTree4() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}
}