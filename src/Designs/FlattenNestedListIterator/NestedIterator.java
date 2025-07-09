import java.util.*;

// Time complexity: O(m), Where m is the total number of elements
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    // The constructor take O(n) time to fill stack, where n is the size of nestedList.
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack();
        for(int i=nestedList.size()-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    // Amortized time of O(1)
    @Override
    public Integer next() {
        if(hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    // hasNext has an amorized time complexity of O(1).
    // if top of the stack is an integer then it is returned right away.
    // otherwise, top elements is processed lazily.
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> currList = stack.pop().getList();
            for(int i=currList.size()-1; i>=0; i--) {
                stack.push(currList.get(i));
            }
        }
        return stack.size()>0;
    }
}