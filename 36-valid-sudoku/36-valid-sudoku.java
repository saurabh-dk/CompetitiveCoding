class Solution {
     public boolean isValidSudoku(char[][] board) {
        boolean ans=true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                    if(board[i][j] != '.'){  
                	char c = board[i][j];
                	board[i][j] = '.';
                    ans = checkValid(board,i,j,c);
                    board[i][j] = c;
                    }
                   if(!ans) return ans; 
                }
            }
        return true;
    }
    
    public boolean checkValid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[i][col]==c)
                return false;
            if(board[row][i]==c)
                return false;
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
                return false;
        }
        return true;
    }    
}