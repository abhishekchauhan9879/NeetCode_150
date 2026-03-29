class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        //iterate through the string
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){
            //for open brackets , add the char
                stack.add(ch);
            }else{
                if(stack.empty()) return false; //first is closing case , invalid
                //we will pop and check for the opposite operand
                //for close brackets, remove the char
                char poppedCh = stack.pop();
                if((poppedCh !='('&& ch==')') ||
                   (poppedCh !='{'&& ch=='}') ||
                   (poppedCh !='['&& ch==']') ){
                    return false; 
                }
            }
            i++;//inc the counter
        }
        // In the last , if stack is empty then true, else false
        return stack.empty();
    }
}
