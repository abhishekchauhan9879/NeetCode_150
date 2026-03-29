class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            n=sumOfSquares(n);
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
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
