import java.util.*;


class FindLongestSelfContainedSubstring {
    public static void main(String[] args) {
        List<String> sList = new ArrayList<>();
        sList.add("abcdefghigklmnopqrstuvwxyz");
        sList.add("aabbcc");
        sList.add("abcabc");
        sList.add("aaabbbcccddd");
        sList.add("abcde");
       
        for(String s: sList) {
            System.out.println(maxSubstringLength(s));
        }
    }

    public static int maxSubstringLength(String s) {
        Map<Character, Integer> startMap = new HashMap<>();
        Map<Character, Integer> endMap = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char startChar = s.charAt(i);
            char endChar = s.charAt(s.length()-i-1);

            startMap.putIfAbsent(startChar, i);
            endMap.putIfAbsent(endChar, s.length()-i-1);
        }

        int max = -1;

        for(int startIndex=0; startIndex<s.length(); startIndex++) {
            int endIndex = endMap.get(s.charAt(startIndex));
            for(int j=startIndex; j<s.length(); j++) {
                if(startMap.get(s.charAt(j))<startIndex) {
                    break;
                }
                endIndex = Math.max(endIndex, endMap.get(s.charAt(j)));
                if(j==endIndex && endIndex-startIndex+1<s.length()) {
                    max = Math.max(max, endIndex-startIndex+1);
                }
                
            }
        }
        return max;
    }
}