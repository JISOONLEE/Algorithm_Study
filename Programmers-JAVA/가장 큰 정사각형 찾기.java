class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int h = board.length;
        int w = board[0].length;
        
        if(h == 1 && w == 1) {
            if(board[0][0] == 1)
                return 1;
            else
                return 0;
        }
        for(int i=1; i<h; i++){
            for(int j=1; j<w; j++){
                if(board[i][j] == 1)
                    board[i][j] = Math.min(Math.min(board[i-1][j],board[i][j-1]), board[i-1][j-1])+1;
                if(board[i][j] > answer)
                    answer = board[i][j];
            }
        }
        answer *= answer;
        return answer;
    }
}
