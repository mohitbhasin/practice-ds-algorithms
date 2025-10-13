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
	public TreeNode getBinaryNums() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		return root;
	}

	public TreeNode getSubTree1() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		return root;
	}

	public TreeNode getSubTree2() {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		return root;
	}

	public TreeNode getSubTree3() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		root.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.right.right.right.right.right.left = new TreeNode(2);
		return root;
	}

	public TreeNode getSymetricTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		return root;
	}

	public TreeNode getSubTree4() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		root.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right = new TreeNode(1);
		root.right.right.right.right.right.left = new TreeNode(2);
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

	public TreeNode maxDiffAncestor() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(3);
		return root;
	}

	public TreeNode diameter() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		return root;
	}

	public TreeNode pathSumIII() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);
		return root;
	}

	public TreeNode bstNode() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		return root;
	}

	public TreeNode pathSumII() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(13);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		return root;
	}

	// public TreeNode buildTree(String s) {
	// 	String[] vals = s.split(',');
	// 	TreeNode root = new TreeNode(vals[0]);
	// 	for(int i=1; i<vals.length; i++) {
			
	// 	}
	// }
}