import java.util.*;

class MaximumSwap {
	public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(151);
        list.add(4398);
        list.add(9973);

        for(int num: list) {
            System.out.println(num+": Max number with one swap: "+maximumSwap(num));
        }
    }

    public static int maximumSwap(int num) {
        int[] heap = new int[10];;
        Arrays.fill(heap, -1);

        String str = ""+num;
        // fill the heap with last index of a digit
        for(int i=0; i<str.length(); i++) {
            int val = str.charAt(i) - '0';
            heap[val] = i;
        }

        // from left to right, look for a largest number which appears after current number
        // inner loop goes from right to left to look for largest numbers in descending order.
        for(int i=0; i<str.length(); i++) {
            int digit = str.charAt(i) - '0';

            for(int j=9; j>digit; j--) {
                if(heap[j]>i) {
                    return swap(str, i, heap[j]);
                }
            }
        }

        return num;
    }

    public static int swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        str = new String(chars);
        return Integer.valueOf(str);
    }
}