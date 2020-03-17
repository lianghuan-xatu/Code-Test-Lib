public class leetcode79
{
    /**
     *
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */

    public static void main(String args[]){
       char board[][] =
               { {'A','B'},
                 {'C','D'}
               };
       String word= "CDBA";

      System.out.println(exist(board,word));

        }
    public static boolean exist(char[][] board, String word) {
           int isvisited[][]=new int[board.length][board[0].length];
           //初始化标记数组
        for(int x=0;x<isvisited.length;x++){
            for (int y=0;y<isvisited[0].length;y++){
                isvisited[x][y]=0;
            }
        }


            for (int m=0;m<board.length;m++){
                for(int n=0;n<board[0].length;n++){
                    if(canpass(board,word,0,m,n,isvisited)){
                        return true;
                    }

                }
            }
            return false;
    }
    public static boolean canpass(char[][] board,String word,int index,int m,int n,int isvisited[][]){

        if(index==word.length()){
            return true;  }
        if(m<0||m>=board.length) return false;
        if(n<0||n>=board[0].length) return false;
        if(isvisited[m][n]==1||board[m][n]!=word.charAt(index)) return false;
        //当前index所在字符匹配    继续向下匹配
        isvisited[m][n]=1;
             if(canpass(board,word,index+1,m+1,n,isvisited)) return true;
             if(canpass(board,word,index+1,m-1,n,isvisited)) return true;
             if(canpass(board,word,index+1,m,n+1,isvisited)) return true;
             if(canpass(board,word,index+1,m,n-1,isvisited)) return true;
             isvisited[m][n]=0;   //上下左右都不匹配消除标记
    return false;
    }

}

