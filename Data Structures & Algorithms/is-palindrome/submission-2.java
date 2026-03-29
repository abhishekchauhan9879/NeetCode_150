class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;

        while(l<r){
            char lch = s.toLowerCase().charAt(l);
            char rch = s.toLowerCase().charAt(r);

            if(Character.isLetterOrDigit(lch) && Character.isLetterOrDigit(rch)){
                if(lch!=rch){
                    return false;
                }
                l++;
                r--;
            }else if(!Character.isLetterOrDigit(lch)){
                l++;
            }else{
                r--;
            }

        }
        return true;
    }
}
