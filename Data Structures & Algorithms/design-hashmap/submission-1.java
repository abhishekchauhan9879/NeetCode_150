class MyHashMap {

    private List<int[]>[] buckets;
    private int size=1000;

    public MyHashMap() {
        buckets = new ArrayList[size];
        for(int i=0;i<size;i++){
            buckets[i]=new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);

        for(int[] pair:buckets[index]){
            if(pair[0]==key){
                pair[1]=value;return;
            }
        }

        buckets[index].add(new int[]{key,value});
    }
    
    public int get(int key) {
        int index = getIndex(key);
        for(int[] pair:buckets[index]){
            if(pair[0]==key){
                return pair[1];
            }
        }
        return -1;
    }
    
    private int getIndex(int key){
        return key%size;
    }

    public void remove(int key) {
        int index=getIndex(key);

        buckets[index].removeIf(pair->pair[0]==key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */