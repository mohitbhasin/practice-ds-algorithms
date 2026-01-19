import java.util.*;

class ValidPalindrome {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("Madam, in Eden, Im Adam");
		strList.add("@#$%^&*");
		strList.add("A1");

		for(String s: strList) {
			System.out.println(s+" : "+isPalindrome(s));
		}
	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;

		while(left<right) {
			int leftChar = s.charAt(left);
			int rightChar = s.charAt(right);
			if(!Character.isLetterOrDigit(leftChar)) {
				left++;
				continue;
			}
			if(!Character.isLetterOrDigit(rightChar)) {
				right--;
				continue;
			}
			if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}