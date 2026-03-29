class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int freq1[]=fillArray(s1);
        int i=0;
        int j=s1.length()-1;

        while(j<s2.length()){
            String temp = s2.substring(i,j+1);
            int freq2[]=fillArray(temp);
            if(compareArr(freq1,freq2)){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
    private int[] fillArray(String s1){
        int arr[]=new int[26];
        for(char ch:s1.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }
    private boolean compareArr(int[] arr, int[] arr2){
        return Arrays.toString(arr).equals(Arrays.toString(arr2));
    }
}
