class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                char sPeek = stack.peek();
                if((sPeek=='(' && ch!=')')
                ||(sPeek=='[' && ch!=']')
                ||(sPeek=='{' && ch!='}')){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.empty();
    }
}
