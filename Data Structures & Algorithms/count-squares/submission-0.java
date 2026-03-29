class CountSquares {

    HashMap<String, Integer> map;
    List<int[]> points;

    public CountSquares() {
        map = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x=point[0];
        int y=point[1];

        points.add(point);

        String key = x+"#"+y;
        map.put(key, map.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int count=0;
        for(int[] p:points){
            int x2 = p[0];
            int y2 = p[1];

            if(Math.abs(x2-x)!=Math.abs(y2-y) || x2==x){
                continue;
            }
            count+= map.getOrDefault(x+"#"+y2,0) *
                    map.getOrDefault(x2+"#"+y,0);
        }
        return count;
    }
}
