class TimeMap {

    public class Pair{
        private String value;
        private int timestamp;

        Pair(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }

    private static HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key)==null)  return "";

        List<Pair> curr = map.get(key);
        int start =0;
        int end =curr.size()-1;
        String ans="";
        while(start<=end){
            int mid = start+(end-start)/2;

            if(curr.get(mid).timestamp<=timestamp){
                ans=curr.get(mid).value;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}
