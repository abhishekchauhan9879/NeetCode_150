class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> myMap = new HashMap<>();

        for( String x: strs){
            char[] arr = x.toCharArray();
            Arrays.sort(arr);
            String idx = new String(arr);
            if(!myMap.containsKey(idx)){
                myMap.put(idx, new ArrayList<>());
            }
            myMap.get(idx).add(x);
        }
        return new ArrayList<>(myMap.values());
    }
}
