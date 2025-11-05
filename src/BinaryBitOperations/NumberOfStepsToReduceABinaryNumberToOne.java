import java.util.*;

class NumberOfStepsToReduceABinaryNumberToOne {
	public static void main(String[] args) {
		// *1011 -> +1 -> 1100
        // *1100 -> /2 -> 110
        // *110 -> /2 -> 11
        // *11 -> +1 -> 100
        // *100 -> /2 -> 10
        // *10 -> /2 = 1

        List<String> list = new ArrayList<>();

        list.add("1011");
        list.add("10");
        list.add("1");
        list.add("101010101010");
        list.add("1111111111111111");

        for(int i=0; i<list.size(); i++) {
        	System.out.println("input: "+list.get(i));
            System.out.println("Output ----> "+numSteps(list.get(i)));
            System.out.println();
        }
    }

    // Time complexity O(n^2)
    // For o(n) solution, iterate right to left,
    // if current bit after carry is odd then add two steps and set carry 1
    // if current bit after carry is even then add one step and set carry 0
    public static int numSteps (String str) {
        StringBuilder sb = new StringBuilder(str);
        int count = 0;
        
        while(!sb.toString().equals("1")) {
            // num is odd, add 1 to make it even.
            if(sb.charAt(sb.length()-1) == '1') {
                int i = sb.length()-1;
                int carry = 1;
                while(carry==1 && i>=0) {
                    if(sb.charAt(i)=='1') {
                        sb.setCharAt(i, '0');
                    } else {
                        sb.setCharAt(i, '1');
                        carry=0;
                    }
                    i--;
                }
                if(carry==1) {
                    sb.insert(0, '1');
                }
                System.out.println("Converted to even: "+sb);
            }
            // number is even, divide it by 2
            else {
                sb.deleteCharAt(sb.length()-1);
                System.out.println("Divided by 2: "+sb);
            }
            count++;
        }
        return count;
    }
}