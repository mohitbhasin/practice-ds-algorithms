import java.util.*;

// Inefficient solution.
// Explore BFS or optimize this DFS
class RemoveInvalidParentheses {
	public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("()())()");
        list.add("))((");
        list.add("(a)())()");
        list.add(")(f");

        for(String s: list) {
            System.out.println(removeInvalidParentheses(s));
        }
	}

	static Set<String> set;
	static int maxLen;
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        maxLen = 0;
        set = new HashSet<>();
        helper(s, "", 0, 0);
        for(String curr: set) {
        	if(curr.length()==maxLen) result.add(curr);
        }
        return result;
    }
    
    public static void helper(String s, String curr, int balance, int index) {
         // base case: want to add current valid parentheses.
                // if(index is at end && balance==0)
        
        // check current index char - if it makes bal +ve ? ignore
                                // otherwise recursive call with char added and balance updated.
                                // for non parentheses chars, keep balance unchanged
        if(balance<0) {
        	return;
        }
        if(index>=s.length()) {
            if(balance==0 && curr.length()>0) {
                set.add(curr);
                maxLen = Math.max(maxLen, curr.length());
            }
            return;
        }
        char c = s.charAt(index);
        int val = 0;
        val += c=='(' ? 1 : 0;
        val += c==')' ? -1 : 0;
        helper(s, curr+c, balance+val, index+1);
        helper(s, curr, balance, index+1);
    }
}