class WordDictionary {

    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean isEnd;
    }
    private TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(node.children[index]==null){
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, TrieNode node){
        if(node==null)  return false;

        if(index==word.length()){
            return node.isEnd==true;
        }

        char ch=word.charAt(index);

        if(ch!='.'){
            return dfs(word, index+1, node.children[ch-'a']);
        }else{
            for(int i=0;i<26;i++){
                if(node.children[i]!=null){
                    if(dfs(word,index+1,node.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
