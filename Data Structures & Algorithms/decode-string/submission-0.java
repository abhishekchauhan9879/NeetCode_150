class Solution {

    class Pair {
        int count;
        String prev;

        Pair(int count, String prev) {
            this.count = count;
            this.prev = prev;
        }
    }

    public String decodeString(String s) {
        Stack<Pair> stack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num=0;

        for(char ch: s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }else if(ch=='['){
                stack.push(new Pair(num,curr.toString()));

                //Reset
                curr=new StringBuilder();
                num=0;
            }else if(ch==']'){
                Pair topElem = stack.pop();
                StringBuilder decoded = new StringBuilder(topElem.prev);
                for(int i=0;i<topElem.count;i++){
                    decoded.append(curr);
                }

                curr=decoded;
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}