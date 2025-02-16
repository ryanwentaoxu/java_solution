public class magic {

    public static void main(String[] args) {
        magic m = new magic();
        m.solution(5);
    }   
    public int[] getNextPos(int[][] matrix, int x, int y) {
        int x1 = x - 1;
        int y1 = y + 1;
        if (x1 < 0) {
            x1 = matrix.length - 1;
        }
        if (y1 >= matrix.length) {
            y1 = 0;
        }

        if (matrix[x1][y1] != 0) {
            x1 = x;
            y1 = y;
        }

        // x1 = (x1 + 1) % matrix.length;

        while (matrix[x1][y1] != 0) {
            x1 = (x1 + 1) % matrix.length;
        }

        return new int[]{x1, y1};
    }

    public void solution(int N) {
        int[][] ret = new int[N][N];

        int[] coord = new int[2];
        coord[0] = 0;
        coord[1] = N/2;
        ret[0][N/2] = 1;
        for (int i = 1; i < N * N; i++) {
            int value = i + 1;
            int[] position = getNextPos(ret, coord[0], coord[1]);
            ret[position[0]][position[1]] = value;
            coord[0] = position[0];
            coord[1] = position[1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ret[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
}
