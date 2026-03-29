class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> myMap = new HashMap<>();

        for( String x: strs){
            int[] arr = new int[26];
            for(char c:x.toCharArray()){
                arr[c-'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for(int i:arr){
                keyBuilder.append(i).append('#');
            }
            String key = keyBuilder.toString();

            myMap.computeIfAbsent(key, k-> new ArrayList<>()).add(x);
        }
        return new ArrayList<>(myMap.values());
    }
}
