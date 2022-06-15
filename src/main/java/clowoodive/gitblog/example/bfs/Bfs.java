package clowoodive.gitblog.example.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    private boolean[] visited = new boolean[9];
    private int[][] graph = {
            {},
            {2, 3, 8},
            {1, 6, 8},
            {1, 5},
            {5, 7},
            {3, 4, 7},
            {2},
            {4, 5},
            {1, 2}
    };

    public void doBfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        this.visited[v] = true;
        queue.offer(v);

        while (!queue.isEmpty()) {
            var nodeIdx = queue.poll();
            System.out.print(nodeIdx + " ");

            for (int i = 0; i < graph[nodeIdx].length; i++) {
                int nextNodeIdx = graph[nodeIdx][i];
                if (!this.visited[nextNodeIdx]) {
                    this.visited[nextNodeIdx] = true;
                    queue.offer(nextNodeIdx);
                }
            }
        }
    }
}
