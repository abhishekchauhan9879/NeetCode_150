class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> myMap = new HashMap<>();

        for(String s:strs){
            int arr[]=new int[26];

            for(char c:s.toCharArray()){
                arr[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            //key for Map
            for(int i:arr){
                sb.append(i).append("#");
            }
            String key=sb.toString();
            myMap.computeIfAbsent(key, k->new ArrayList<>()).add(s);

        }
        return new ArrayList<>(myMap.values());
    }
}
