class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;

        do{
            slow=sumOfSquares(slow);
            fast=sumOfSquares(sumOfSquares(fast));
        }while(slow!=fast);

        return slow==1;
    }

    private int sumOfSquares(int n){
        int res=0;
        while(n!=0){
            int lastDigit=n%10;
            res+=lastDigit*lastDigit;
            n=n/10;
        }
        return res;
    }
}
