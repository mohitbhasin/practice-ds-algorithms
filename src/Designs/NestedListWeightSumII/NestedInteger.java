import java.util.*;

public class NestedInteger {
    List<NestedInteger> list;
    Integer value;
    
    // Constructor initializes an empty nested list
    public NestedInteger() {
        this.list = new ArrayList<>();
        this.value = null;
    }

    // Constructor initializes a single integer
    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }
    
    // @return true if this NestedInteger holds a single integer rather than a nested list
    public boolean isInteger() {
        return this.value!=null;
    }
    
    // @return the single integer this NestedInteger holds, if it holds a single integer
    // Otherwise, return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if(isInteger()) {
            return this.value;
        }
        return null;
    }
    
    // Sets this NestedInteger to hold a single integer equal to value
    public void setInteger(int value) {
        this.value = value;
    }
    
    // Sets this NestedInteger to hold a nested list and adds the nested integer elem to it
    public void add(NestedInteger ni) {
        list.add(ni);
    }
    
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Otherwise, return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list==null ? null : list;
    }
}