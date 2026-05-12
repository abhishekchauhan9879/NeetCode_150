class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int lastFreq=0;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            int topElem[] = stack.pop();
            lastFreq+=topElem[1];
        }
        lastFreq++;
        stack.push(new int[]{price,lastFreq});
        return lastFreq;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */