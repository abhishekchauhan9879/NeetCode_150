class Solution {
    public boolean isAnagram(String s, String t) {
        int strLen1=s.length();
        int strLen2=t.length();

        if(strLen1!=strLen2){
            return false;
        }
        s=s.toLowerCase();
        t=t.toLowerCase();
        int[] arr = new int[26];
        for(int i=0;i<strLen1;i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int x:arr){
            if(x!=0)return false;
        }
        return true;
    }
}
