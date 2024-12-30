class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int x, int y) {
        boolean[] digits = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[x + i][y + j];
                if (num < 1 || num > 9 || digits[num]) {
                    return false;
                }
                digits[num] = true;
            }
        }

        int sum = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        if (grid[x + 1][y] + grid[x + 1][y + 1] + grid[x + 1][y + 2] != sum) return false;
        if (grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2] != sum) return false;

        if (grid[x][y] + grid[x + 1][y] + grid[x + 2][y] != sum) return false;
        if (grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1] != sum) return false;

        if (grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2] != sum) return false;
        if (grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2] != sum) return false;

        if (grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y] != sum) return false;

        return true;
    }

}