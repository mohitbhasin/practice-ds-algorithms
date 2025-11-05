import java.util.*;

class RemoveDuplicateLetters {
	public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("cbacbac");
       list.add("edcba");
       list.add("hecrchiecec");
       list.add("cbac");
       for(String s: list) {
          System.out.println(removeDuplicateLetters(s));
      }
    }

    public static String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.putIfAbsent(c, 0);
            frequencyMap.put(c, frequencyMap.get(c)+1);
        }
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.get(c)-1);
            if(visited.contains(c)) {
                continue;
            }
            
            sb.append(c);
            visited.add(c);

            int curr = sb.length()-1;
            while(curr>0 && sb.charAt(curr-1)>sb.charAt(curr) && frequencyMap.get(sb.charAt(curr-1))>0) {
                char temp = sb.charAt(curr-1);
                sb.deleteCharAt(curr-1);
                visited.remove(temp);
                curr--;
            }
        }
        return sb.toString();
    }
}