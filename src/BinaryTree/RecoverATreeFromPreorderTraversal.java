import java.util.*;

class RecoverATreeFromPreorderTraversal {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1-2-3");
		list.add("2-4--6--8-3--5--7");
		list.add("100-200--300---400-500");
		list.add("1000-500--250---125--62---31");

		for(String traversal: list) {
			TreeNode root = recoverFromPreorder(traversal);
			root.print(root);
			System.out.println("----------------------");
		}
	}

	public static TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length()==0) return null;
        index = 0;
        return helper(traversal, 0);
    }

    static int index;
    
    public static TreeNode helper(String traversal, int depth) {
        int nextDepth = getDepthCount(traversal);
        if(index>=traversal.length() || nextDepth<depth) {
            return null;
        }
        index+=nextDepth;
        int endValueIndex = index;
        while(endValueIndex<traversal.length() && Character.isDigit(traversal.charAt(endValueIndex))) {
            endValueIndex++;
        }
        int val = Integer.parseInt(traversal.substring(index, endValueIndex));
        index = endValueIndex;
        TreeNode node = new TreeNode(val);
        node.left = helper(traversal, depth+1);
        node.right = helper(traversal, depth+1);
        
        return node;
    }

    public static int getDepthCount(String traversal) {
        int depthIndex = index;
        int depthCount = 0;
        for(int i=depthIndex; i<traversal.length(); i++) {
            char c = traversal.charAt(i);
            if(c >= '0' && c<='9') {
                return depthCount;
            }
            depthCount++;
        }
        return depthCount;
    }
}