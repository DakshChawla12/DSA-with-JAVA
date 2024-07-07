public class buyAndSellStock {
    
    public static int maxProfit(int stockPrices[]) {
        
        // Initialize variables to track the minimum buy price and maximum profit
        int minBuyPrice = Integer.MAX_VALUE;
        int max_Prof = Integer.MIN_VALUE;
    
        // Iterate through the stock prices array to find the maximum profit
        for (int stockPrice : stockPrices) {
            // Update the minimum buy price if the current stock price is lower
            minBuyPrice = Math.min(minBuyPrice, stockPrice);

            // Update the maximum profit if selling at the current price yields a higher profit
            max_Prof = Math.max(max_Prof, (stockPrice - minBuyPrice));
        }
    
        // Check if there is a positive profit; return the maximum profit if so, otherwise, return 0
        return Math.max(max_Prof, 0);
    }
    

    public static void main(String[] args) {
        int arr[] = new int[]{7,1,5,3,6,2};
        int res = maxProfit(arr);
        System.err.println(res);
    }

}



