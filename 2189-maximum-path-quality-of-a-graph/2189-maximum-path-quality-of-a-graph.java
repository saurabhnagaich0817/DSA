class Solution {
    int res = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) map.put(i, new HashMap<>());
        for (int[] edge : edges) {
            map.get(edge[0]).put(edge[1], edge[2]);
            map.get(edge[1]).put(edge[0], edge[2]);
        }
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        visited.put(0, 1);
        dfs(0, maxTime, values[0], visited, values, map);
        return res;
    }

    public void dfs(int cur, int time, int value, Map<Integer, Integer> visited, int[] values, Map<Integer, Map<Integer, Integer>> map) {
        if (cur == 0) {
            res = Math.max(res, value);
        }
        for (Map.Entry<Integer, Integer> entry : map.get(cur).entrySet()) {
            if (time < entry.getValue()) continue;
            if (!visited.containsKey(entry.getKey())) value += values[entry.getKey()];
            visited.put(entry.getKey(), visited.getOrDefault(entry.getKey(), 0) + 1);
            dfs(entry.getKey(), time - entry.getValue(), value, visited, values, map);
            visited.put(entry.getKey(), visited.getOrDefault(entry.getKey(), 0) - 1);
            if (visited.get(entry.getKey()) == 0) {
                visited.remove(entry.getKey());
                value -= values[entry.getKey()];
            }
        }
    }
}