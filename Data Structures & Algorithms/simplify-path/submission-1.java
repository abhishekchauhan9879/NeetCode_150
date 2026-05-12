class Solution {
    public String simplifyPath(String path) {
        String strings[] = path.split("/");
        Stack<String> stack = new Stack<>();


        for(String str: strings){

            if(str.equals(".")||str.equals("")){
                continue;
            }
            else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(str);
            }
        }

        StringBuilder res = new StringBuilder();

        for(String s: stack){
            res.append("/").append(s);
        }
        if(res.length() == 0){
            return "/";
        }
        return res.toString();

    }
}