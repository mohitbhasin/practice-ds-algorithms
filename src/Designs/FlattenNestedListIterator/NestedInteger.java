import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private Integer integer;
    private List<NestedInteger> list;

    public NestedInteger() {
        this.list = new ArrayList<>();
        this.integer = null;
    }
    
    public NestedInteger(int integer) {
        this.integer = integer;
        this.list = null;
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(int value) {
        this.list = null;
        this.integer = value;
    }

    public void add(NestedInteger ni) {
        if (this.integer != null) {
            this.list = new ArrayList<>();
            this.list.add(new NestedInteger(this.integer));
            this.integer = null;
        }
        if (this.list != null) {
            this.list.add(ni);
        }
    }
    
    public List<NestedInteger> getList() {
        return list;
    }
}