package clowoodive.gitblog.example.dfs;

public class Dfs {
    private boolean[] visited = new boolean[9];
    private int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
    };

    public void doDfs(int v) {
        this.visited[v] = true;

        System.out.print(v + " ");

        for (int i : this.graph[v]) {
            if (this.visited[i] == false)
                doDfs(i);
        }
    }
}
