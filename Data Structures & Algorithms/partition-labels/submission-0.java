class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // lets prepare the last mapping for each character
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);//the last occurence
        }
        // Lets iterate through the string and divide where we gets an end;
        int end=0;
        int lastSavedLength=0;

        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);//
            //Lets track the occurence
            // System.out.println("end: "+end);
            end=Math.max(map.get(ch),end);
            if(i==end){
                System.out.println("end: "+end);
                res.add(end-lastSavedLength+1);
                lastSavedLength=end+1;
                end=0;//reset end
            }
        }
        return res;
    }
}
