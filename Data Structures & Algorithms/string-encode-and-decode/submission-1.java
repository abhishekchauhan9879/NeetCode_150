class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str:strs){
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            j++;
            String st=str.substring(j,j+length);
            res.add(st);

            i=j+length;
        }
        return res;
    }
}
