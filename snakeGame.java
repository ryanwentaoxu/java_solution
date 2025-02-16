import java.util.List;
import java.util.ArrayList;
// import javafx.util.Pair;

public class snakeGame {

    int M;
    int N;
    class Pair {
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    
        public int getX() {
            return x;
        }
    
        public int getY() {
            return y;
        }
    
        public void setX(int x) {
            this.x = x;
        }
        
        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        snakeGame sg = new snakeGame();
        int mat[][] = {{9, 6, 5, 2},
                   {8, 7, 6, 5},
                   {7, 3, 1, 6},
                   {1, 1, 1, 7}};
        sg.solution(mat);
    }

    public void solution(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        int[][] dp = new int[M][N];
        Pair[][] prev_point = new Pair[M][N];
        int max_len = 0;
        int max_row = 0;
        int max_col = 0;
        dp[0][0] = 1;
        prev_point[0][0] = null;

        for (int i = 1; i < N; i++) {
            if (Math.abs(mat[0][i] - mat[0][i - 1]) == 1) {
                dp[0][i] = dp[0][i] + 1;
                prev_point[0][i] = new Pair(0, i - 1);
            }  else {
                dp[0][i] = 1;
                prev_point[0][i] = null;
            }
        }        

        for (int i = 1; i < M; i++) {
            if (Math.abs(mat[i][0] - mat[i - 1][0]) == 1) {
                dp[i][0] = dp[i][0] + 1;
                prev_point[i][0] = new Pair(i-1, 0);
            }  else {
                dp[i][0] = 1;
                prev_point[i][0] = null;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = 1;
                prev_point[i][j] = null;
                if (Math.abs(mat[i][j] - mat[i - 1][j]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
                    prev_point[i][j] = new Pair(i-1, j);
                    
                }
                if (Math.abs(mat[i][j - 1] - mat[i][j]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                    prev_point[i][j] = new Pair(i, j-1);
                }

                if (dp[i][j] > max_len) {
                    max_len = dp[i][j];
                    max_row = i;
                    max_col = j;
                }
            }
        }

        int start_row = max_row;
        int start_col = max_col;
        if (prev_point[start_row][start_col] == null) {
            return;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(mat[max_row][max_col]);

        while (prev_point[start_row][start_col] != null) {
            Pair current = prev_point[start_row][start_col];
            ans.add(0, mat[current.getX()][current.getY()]);
            start_row = current.getX();
            start_col = current.getY();
        }
        

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
    
}
