class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // lets prepare the last mapping for each character
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);//the last occurence
        }
        // Lets iterate through the string and divide where we gets an end;
        int end=0;
        int start=0;

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            //Lets track the occurence
            // System.out.println("end: "+end);
            end=Math.max(map.get(s.charAt(i)),end);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}
