import java.util.*;


class KokoEatingBananas {
	public static void main(String[] args) {
        List<int[]> pilesList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();

        pilesList.add(new int[] {231598633,148577784,963216069,560973594,409101157,167404007,822160098,654520229,725064177,242068896,530484452,824577751,334841973,460979628,135276760,657039788,931779420,38935607,663505675,83424509,251392222,22158699,674775869,675855737,727419773,47159664,624801053,584157870,494422754,823374269,802081140,341634654,111617747,291043848,128087406,504191492,712562573,622331832,246680951,811626602,895179364,460094815,794340415,715842825});
        hList.add(271685328);
        pilesList.add(new int[]{2,2,2,2,2});
        hList.add(5);

        for(int i=0; i<pilesList.size(); i++) {
            System.out.println(minEatingSpeed(pilesList.get(i), hList.get(i)));
        }
    }

    // Bruteforce
    public static int minEatingSpeed_bf(int[] piles, int h) {
        for(int k=1; k<=Integer.MAX_VALUE; k++) {
            long total = 0;
            for(int pile: piles) {
                total+=pile/k;
                total+=pile%k>0 ? 1 : 0;
            }
            if(total<=h) {
                return k;
            }
        }
        return -1;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile: piles) {
            right=Math.max(right, pile);
        }
        
        long total = 0;
        int k = 0;
        while(left<right) {
            k = (left + right)/2;
            for(int pile: piles) {
                total+=pile/k;
                total+=pile%k>0 ? 1 : 0;
            }
            
            if(total<=h) {
                right=k;
            } else {
                left=k+1;
            }
            total=0;

        }
        return left;
    }
}