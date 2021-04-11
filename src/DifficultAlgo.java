public class DifficultAlgo {

    // finds a max profit within array with k amount of transactions.
    public static int maxProfitWithKTransactions(int[] prices, int k) {

        if (prices.length == 0) return 0;

        int[][] profits = new int[k + 1][prices.length];
        for(int t = 1; t< k + 1; t++){
            int maxThusFar = Integer.MIN_VALUE;
            for (int d = 1; d< prices.length; d++){
                maxThusFar = Math.max(maxThusFar, profits[t- 1][d - 1] - prices[d- 1]);
                profits[t][d] = Math.max(profits[t][d - 1], maxThusFar + prices[d]);
            }
        }
        return profits[k][prices.length - 1];
    }

}
