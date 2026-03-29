class Solution {
   class TrieNode {
       TrieNode[] children = new TrieNode[26];
       boolean isEnd;
       int numChildren=0;
   }
   private TrieNode buildTrie(String[] words){
       TrieNode root = new TrieNode();


       for(String word: words){
           TrieNode node = root;


           for(char ch: word.toCharArray()){
               int idx = ch - 'a';


               if(node.children[idx]==null){
                   node.children[idx] = new TrieNode();
                   node.numChildren++;
               }


               node = node.children[idx];
           }
           node.isEnd = true;
       }
       return root;
   }


   public List<String> findWords(char[][] board, String[] words) {
       TrieNode root = buildTrie(words);
       List<String> res = new ArrayList<>();


       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               dfs(board, i, j, root, new StringBuilder(), res);
           }
       }
       return res;
   }


   private void dfs(char[][] board, int i, int j,TrieNode node, StringBuilder path, List<String> res){


       char c = board[i][j];
       //if already visited and no children return
       if(c=='#' || node.children[c-'a']==null)    return;

       TrieNode curr = node.children[c-'a'];
       path.append(c);
       if (curr.isEnd) {
           res.add(path.toString());
           curr.isEnd = false; // avoid duplicates
       }
       //Mark it visited
       board[i][j]='#';
       //Diagonal coordinates
       int dx[]={-1,1,0,0};
       int dy[]={0,0,-1,1};


       for(int d=0;d<4;d++){
           int ni=i+dx[d];
           int ny=j+dy[d];


           if(ni>=0 && ny>=0 && ni<board.length && ny < board[0].length){
               dfs(board,ni,ny,curr,path, res);
           }
       }


       //backtrack
       board[i][j]=c;
       path.deleteCharAt(path.length()-1);


       if(!curr.isEnd && curr.numChildren==0){
           node.children[c-'a']=null;
	       node.numChildren--;
       }
   }
}
