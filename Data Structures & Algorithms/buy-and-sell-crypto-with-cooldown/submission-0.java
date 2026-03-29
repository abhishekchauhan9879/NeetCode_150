class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0];
        int sold=0;
        int rest=0;

        for(int price:prices){
            int prevSold=sold;

            sold=hold+price;
            hold=Math.max(hold,rest-price);
            rest=Math.max(rest,prevSold);
        }

        return Math.max(sold,rest);
    }
}
