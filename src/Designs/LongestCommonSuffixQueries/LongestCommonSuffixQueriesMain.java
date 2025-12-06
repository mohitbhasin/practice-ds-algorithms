import java.util.*;

class LongestCommonSuffixQueriesMain {
	public static void main(String[] args) {
        List<String[][]> wordsList = new ArrayList<>();
        wordsList.add(new String[][]{{"mango","ango","xango"}, {"go","ango","xyz"}});
        wordsList.add(new String[][]{{"starting","sting","ring"}, {"ring","ing","random"}});
        wordsList.add(new String[][]{{"respect","aspect","spect"}, {"spect","ect","detect"}});
        wordsList.add(new String[][]{{"alpha","beta","gamma"}, {"ta","eta","zeta"}});
        wordsList.add(new String[][]{{"abcdefgh","poiuygh","ghghgh"}, {"gh","acbfgh","acbfegh"}});
        LongestCommonSuffixQueries obj = new LongestCommonSuffixQueries();
        for(int i=0; i<wordsList.size(); i++) {
            int[] result = obj.stringIndices(wordsList.get(i)[0], wordsList.get(i)[1]);
            for(int ans: result) {
                System.out.print(ans+",");
            }
            System.out.println();
        }
    }
}