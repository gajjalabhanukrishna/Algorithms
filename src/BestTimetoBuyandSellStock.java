public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {



        int le = prices.length, maxD = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < le; i++){
            min = Math.min(min, prices[i]);
            maxD = Math.max(maxD, prices[i] - min);
        }

        return maxD;
    }

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        BestTimetoBuyandSellStock b =  new BestTimetoBuyandSellStock();
        b.maxProfit(prices);


    }
}
