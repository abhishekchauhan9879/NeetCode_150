class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0,j=0;

        StringBuilder res = new StringBuilder();

        while(i<word1.length() && j< word2.length()){
            res.append(word1.charAt(i++));
            res.append(word2.charAt(j++));
        }

        if(word1.length()>i){
            res.append(word1.substring(i));
        }

        if(word2.length()>j){
            res.append(word2.substring(j));
        }

        return res.toString();
    }
}