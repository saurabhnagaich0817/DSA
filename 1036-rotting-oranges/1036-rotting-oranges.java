class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;

        // Add all rotten oranges to the queue
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int time = 0;

        // BFS traversal to rot fresh oranges
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.level > time) {
                time++;
            }

            // Spread rot to adjacent cells
            if (p.i - 1 >= 0 && grid[p.i - 1][p.j] == 1) {
                grid[p.i - 1][p.j] = 2;
                q.add(new Pair(p.i - 1, p.j, p.level + 1));
            }
            if (p.i + 1 < m && grid[p.i + 1][p.j] == 1) {
                grid[p.i + 1][p.j] = 2;
                q.add(new Pair(p.i + 1, p.j, p.level + 1));
            }
            if (p.j - 1 >= 0 && grid[p.i][p.j - 1] == 1) {
                grid[p.i][p.j - 1] = 2;
                q.add(new Pair(p.i, p.j - 1, p.level + 1));
            }
            if (p.j + 1 < n && grid[p.i][p.j + 1] == 1) {
                grid[p.i][p.j + 1] = 2;
                q.add(new Pair(p.i, p.j + 1, p.level + 1));
            }
        }

        // Check for any remaining fresh oranges
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    class Pair {
        int i;
        int j;
        int level;
        public Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
}