class Solution {
    public boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^A-Za-z0-9]","");
        String reversed = new StringBuilder(filtered).reverse().toString();
        return filtered.equalsIgnoreCase(reversed);
    }
}
