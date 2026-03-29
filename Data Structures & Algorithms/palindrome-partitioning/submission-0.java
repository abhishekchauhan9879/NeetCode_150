class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,result,new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<List<String>> result, List<String> current){
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start,i+1));
                backtrack(s,i+1,result,current);
                current.remove(current.size()-1);
            }
        }
        
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
