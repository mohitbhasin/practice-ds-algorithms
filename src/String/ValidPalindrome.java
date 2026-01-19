import java.util.*;

class ValidPalindrome {
	public static void main(String args[]) {
        List<String> strList = new ArrayList<>();
        strList.add("Madam, in Eden, Im Adam");
        strList.add("rac3car");
        strList.add("@#$%^&*");
        strList.add("A man, a plan, a canal: Panama");
        strList.add("A1");

        for(String s: strList) {
            System.out.println(s+" : "+isPalindrome_cleaner(s));
            // System.out.println(s+" : "+isPalindrome(s));
        }
	}

	public static boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        
        while(l<r) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            // !Character.isLetterOrDigit(a) can be used
            if(!((a>='a' && a<='z') || (a>='A' && a<='Z') || (a>='0' && a<='9'))) {
                l++;  
            }
            else if(!((b>='a' && b<='z') || (b>='A' && b<='Z') || (b>='0' && b<='9'))) {
                r--;
            } else {
                a = Character.toLowerCase(a);
                b = Character.toLowerCase(b);
                if(a!=b) return false;
                l++;
                r--;
            }
        }
        return true;
    }

    public static boolean isPalindrome_cleaner(String s) {
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