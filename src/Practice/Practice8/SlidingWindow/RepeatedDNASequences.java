import java.util.*;

class RepeatedDNASequences {
	public static void main(String[] args) {
		List<String> dnaList = new ArrayList<>();
		dnaList.add("ATATTGGCCAATTGGCCAATTCGC");
		dnaList.add("TTTTTTTTTTGGGGGGGGGG");
		dnaList.add("ACGTACGTACGGGTTACGTACGTAC");

		for(String s: dnaList) {
			System.out.println(findRepeatedDnaSequences(s));
			// System.out.println(findRepeatedDnaSequences_slow(s));
			// System.out.println("-----");
		}
	}


	public static List<String> findRepeatedDnaSequences(String s) {
		if(s.length()<10) return new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		map.put('A',1);
		map.put('C',2);
		map.put('G',3);
		map.put('T',4);

		Set<Integer> visited = new HashSet<>();
		Set<String> result = new HashSet<>();

		int hash = 0;
		int base = 4;
		int k = 10;
		// initial hash value
		for(int i=0; i<k; i++) {
			int c = map.get(s.charAt(i));
			hash+=c*Math.pow(base, k-i-1);
		}

		visited.add(hash);
		int exponentValue = (int) Math.pow(base, k-1);
		for(int i=k; i<s.length(); i++) {
			hash-=map.get(s.charAt(i-k))*exponentValue;
			hash*=base;
			hash+=map.get(s.charAt(i));
			if(visited.contains(hash)) {
				result.add(s.substring(i-k+1,i+1));
			} else {
				visited.add(hash);
			}
		}
		return new ArrayList<>(result);
	}
	


	public static List<String> findRepeatedDnaSequences_slow(String s) {
		if(s.length()<10) {
			return new ArrayList<>();
		}
		Set<String> result = new HashSet<>();
		
        Set<String> set = new HashSet<>();

        for(int i=10; i<=s.length(); i++) {
        	String sequence = s.substring(i-10, i);
        	if(set.contains(sequence)) {
        		result.add(sequence);
        	} else {
        		set.add(sequence);
        	}
        }
        return new ArrayList<>(result);
    }

}