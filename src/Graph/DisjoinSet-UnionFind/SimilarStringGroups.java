import java.util.*;


class SimilarStringGroups {
	public static void main(String[] args) {
        List<String[]> strsList = new ArrayList<>();

        strsList.add(new String[] {"abcd","abdc","acbd","bdca"});
        strsList.add(new String[] {"omv","ovm"});
        strsList.add(new String[] {"mvo","ovm"});
        strsList.add(new String[] {"tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq","tq"});
        strsList.add(new String[] {"nqqqhidshfsdldpxcrxybbeoldoyqmxiplpvbwetwuqlaqnuqcfegslkyszgoigdjaqwcga","nqqqhidshfsdldpxcrxybbeopdoyqmxipllvbwgtwuqlaqnuqcfegslkyszeoigdjaqwcga","nqqqhidshfsdldpxcrxybbeoldoyqmxiplpvbwgtwuqlaqnuqcfegslkyszeoigdjaqwcga","nqqqhidshfsdldpxcrxybbeoldoyqmxiplpvkwgtwuqlaqnuqcfegslbyszeoigdjaqwagc","nqqqhidshfsdldpxcrxybbeoldoyqmxiplpvkwgtwuqlaqnuqcfegslbyszeoigdjaqwcga","oqqqhidshfsdldpxcrxybbeoldnyqmxiplpvkwgtwuqlaqnuqcfegslbyszeoigdjaqwcga"});

        for(String[] strs: strsList) {
            System.out.println(numSimilarGroups(strs));
        }
    }

    // Time Complexity: O(N^2 . L . amortized(N))
    // N = length of strs[]
    // N^2 = number of pairs of strings
    // L = length of string
    public static int numSimilarGroups(String[] strs) {
        totalGroups = strs.length;

        parent = new int[strs.length];
        for(int i=0; i<strs.length; i++) {
            parent[i]=i;
        }

        for(int i=0; i<strs.length-1; i++) {
            for(int j=i+1; j<strs.length; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    union(i,j);
                }
            }
        }
        return totalGroups;
    }
    
    static int[] parent;
    static int totalGroups;
    
    public static boolean isSimilar(String s1, String s2) {
        int count = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                count++;
            }
            if(count>2) {
                return false;
            }
        }
        return true;
    }
    
    public static int find(int i) {
        if(parent[i]==i) {
            return i;
        }
        // path compression for better performance.
        parent[i] = find(parent[i]); 
        return parent[i];
        
        // Without path compression
        // return find(parent[i]);
    }

    public static void union(int i, int j) {
        int root_i = find(i);
        int root_j = find(j);
        if(root_i!=root_j) {
            totalGroups--;
            parent[root_i] = root_j;
        }
    }
}