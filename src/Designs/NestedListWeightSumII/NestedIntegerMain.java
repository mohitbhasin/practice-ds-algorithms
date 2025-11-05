import java.util.*;

class NestedIntegerMain {
	public static void main(String[] args) {
		// [1,[2,[3,[4,[5]]]]]
		NestedInteger nestedListA;
		NestedInteger nestedListB;
		nestedListA = new NestedInteger();
		nestedListA.add(new NestedInteger(5));
		nestedListB = new NestedInteger();
		nestedListB.add(new NestedInteger(4));
		nestedListB.add(nestedListA);
		nestedListA = new NestedInteger();
		nestedListA.add(new NestedInteger(3));
		nestedListA.add(nestedListB);
		nestedListB = new NestedInteger();
		nestedListB.add(new NestedInteger(2));
		nestedListB.add(nestedListA);
		nestedListA = new NestedInteger();
		nestedListA.add(new NestedInteger(1));
		nestedListA.add(nestedListB);

		List<NestedInteger> nestedList = Arrays.asList(nestedListA);

		System.out.println(weightedDepthSum(nestedList));
	}

	public static int weightedDepthSum(List<NestedInteger> nestedList) {
        weightedSum = 0;
        maxDepth = 0;
        for(NestedInteger ni: nestedList) {
            findMaxDepth(ni, 0);
        }
        for(NestedInteger ni: nestedList) {
            findSum(ni, 0);
        }
        return weightedSum;
    }
    
    static int weightedSum;
    static int maxDepth;
    public static void findMaxDepth(NestedInteger nestedInt, int depth) {
        if(nestedInt.isInteger()) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        for(NestedInteger ni: nestedInt.getList()) { 
            findMaxDepth(ni, depth+1);
        }
    }
    
    public static void findSum(NestedInteger nestedInt, int depth) {
        if(nestedInt.isInteger()) {
            int weight = maxDepth-depth+1;
            weightedSum+=nestedInt.getInteger()*weight;
            return;
        }
        for(NestedInteger ni: nestedInt.getList()) { 
            findSum(ni, depth+1);
        }
    }
}