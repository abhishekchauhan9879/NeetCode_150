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

        return res.toString().length()>0?res.toString():res.append("/").toString();

    }
}