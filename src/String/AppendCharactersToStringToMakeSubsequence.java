import java.util.*;

class AppendCharactersToStringToMakeSubsequence {
	public static void main(String[] args) {
		List<String[]> list = new ArrayList<>();
		list.add(new String[] {"a","a"});
		list.add(new String[] {"abb","aaaaaab"});
		list.add(new String[] {"axbyc","abcde"});
		list.add(new String[] {"xyz","abc"});

		for(String[] pair: list) {
			System.out.println(appendCharacters(pair[0], pair[1]));
		}
	}

	public static int appendCharacters(String source, String target) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i<target.length() && j<source.length()) {
            if(target.charAt(i)==source.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return target.length()-i;
    }
}