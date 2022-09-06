class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prefix = new int[n+1][m+1];
        
        for(int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = type == 1?-sk[5]:sk[5];
            
            prefix[r1][c1] += degree;
            prefix[r1][c2+1] += -degree;
            prefix[r2+1][c2+1] += degree;
            prefix[r2+1][c1] += -degree;
        }
        
        for(int i=0;i<n+1;i++) {
            int sum = 0;
            for(int j=0;j<m+1;j++) {
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }
        
        for(int i=0;i<m+1;i++) {
            int sum = 0;
            for(int j=0;j<n+1;j++) {
                sum += prefix[j][i];
                prefix[j][i] = sum;
            }
        }
        
        for (int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]+prefix[i][j]>0) answer++;
            }
        }
        
        return answer;
    }
}
