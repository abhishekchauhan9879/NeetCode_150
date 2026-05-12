class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();

        for(String str: operations){
            if(str.equals("C")){
                s.pop();
            }else if(str.equals("D")){
                int lastElem = s.pop();
                s.push(lastElem);
                s.push(lastElem*2);
            }else if(str.equals("+")){
                int lastElem = s.pop();
                int lastSecondElem = s.pop();
                s.push(lastSecondElem);
                s.push(lastElem);
                s.push(lastElem+lastSecondElem);
            }else{
                s.push(Integer.valueOf(str));
            }
        }
        int res=0;
        while(!s.isEmpty()){
            res+=s.pop();
        }
        return res;
    }
}