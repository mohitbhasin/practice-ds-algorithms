import java.util.*;

class AddStrings {
	public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"11", "123"});
        list.add(new String[]{"456", "99"});
        list.add(new String[]{"0", "0"});

        for(String[] pair: list) {
            System.out.println("Sum: "+addStrings(pair[0], pair[1]));
        }
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        // for more optimization, integrate carry check in the loop instead of if().
        // while(i>=0 || j>=0 || carry>0) {

        while(i>=0 || j>=0) {
            int a = (i>=0) ? num1.charAt(i--) - '0' : 0;
            int b = (j>=0) ? num2.charAt(j--) - '0' : 0;
            int sum = a+b+carry;
            sb.append(sum%10);
            carry=sum/10;
        }
        // can be taken out, if carry checked in the loop.
        if(carry>0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // instead of splitting in multiple if check,
    // pre-calculate digits.
    public static String addStrings_lessOptimized(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0) {
            int sum = 0;
            if(i>=0 && j>=0) {
                sum = carry + (num1.charAt(i) - '0') + (num2.charAt(j) - '0');
            } else if (i>=0) {
                sum = carry + (num1.charAt(i) - '0');
            } else {
                sum = carry + (num2.charAt(j) - '0');
            }
            i--;
            j--;
            // inserting at the begining of stringBuffer is O(n) operation.
            // Integers can be added to string buffer and they will be converted to string automatically.
            sb.insert(0, sum%10);
            carry=sum/10;
        }
        if(carry>0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}