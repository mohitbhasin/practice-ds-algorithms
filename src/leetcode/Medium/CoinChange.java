import java.util.*;

class CoinChange {
	public static void main(String args[]) {
		List<int[]> coinsList = new ArrayList<>();
        List<Integer> totalList = new ArrayList<>();
        coinsList.add(new int[]{1,2,5});
        totalList.add(11);
        coinsList.add(new int[]{3340,31,4742,2233,9828,4233,54,243});
        totalList.add(720);
        coinsList.add(new int[]{2});
        totalList.add(3);
        coinsList.add(new int[]{2,5,10,1});
        totalList.add(27);
        coinsList.add(new int[]{186,419,83,408});
        totalList.add(6249);
		for(int i=0; i<coinsList.size(); i++) {
            System.out.println("total:"+totalList.get(i)+" count="+coinChange(coinsList.get(i), totalList.get(i)));
        }
	}

    public static int coinChange(int[] coins, int total) {
        int result = helper(coins, total, new int[total+1]);
        return result==Integer.MAX_VALUE ? -1 : result;
    }
    
    public static int helper(int[] coins, int total, int[] memo) {
        if(total<0) return Integer.MAX_VALUE;
        if(total==0) return 0;
        if(memo[total]!=0) return memo[total];
        int minCoin = Integer.MAX_VALUE;
        
        for(int i=0; i<coins.length; i++) {
            int val = helper(coins, total-coins[i], memo);
            if(val!=Integer.MAX_VALUE) {
                minCoin = Math.min(minCoin, val+1);
            }
        }
        memo[total]=minCoin;
        return minCoin;
    }
}