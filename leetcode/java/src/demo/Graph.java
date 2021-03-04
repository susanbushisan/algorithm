package demo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用无向图作为例子，有向图类似
 */
public class Graph {

    private int v;
    private LinkedList<Integer>[] adj;


    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "->");
    }

    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private boolean recurDfs(int w, int t, boolean[] visited, int[] prev) {
        visited[w] = true;
        if (w == t) {
            return true;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                if (recurDfs(q, t, visited, prev)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.dfs(0,6);
        graph.bfs(0,6);
    }
}
