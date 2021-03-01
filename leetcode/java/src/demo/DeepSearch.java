package demo;

import java.util.*;

public class DeepSearch {

    public static class Graph { // 无向图
        private int v; // 顶点的个数
        private LinkedList[] adj; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        //BreadthFirstSearch
        public void bfs(int s, int t) {
            if (s == t) return;
            boolean[] visited = new boolean[v];
            visited[s] = true;
            int[] prev = new int[v];
            Arrays.fill(prev, -1);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(s);
            while (!queue.isEmpty()) {
                int p1 = queue.poll();
                for (int i = 0; i < adj[p1].size(); i++) {
                    int p2 = (int) adj[p1].get(i);
                    if (!visited[p2]) {
                        prev[p2] = p1;
                        if (p2 == t) {
                            //打印结果
                            print(s, t, prev);
                        }
                        visited[p2] = true;
                        queue.add(p2);
                    }
                }
            }
        }

        //DepthFirstSearch
        public void dfs(int s, int t) {
            if (s == t) return;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(s);
            boolean[] visited = new boolean[v];
            visited[s] = true;
            dfsHelper(s,t,stack,visited);
        }

        private boolean dfsHelper(int s, int t, Deque<Integer> stack, boolean[] visited) {
            if (s == t){
                print(stack);
                return true;
            }
            for (int i = 0; i < adj[s].size(); i++) {
                int p2 =(int) adj[s].get(i);
                if (!visited[p2]){
                    visited[p2] = true;
                    stack.push(p2);
                    if (dfsHelper(p2,t,stack,visited)){
                        return true;
                    }
                    stack.pop();
                    visited[p2] = false;
                }
            }
            return false;
        }

        private void print(Deque<Integer> stack) {
            System.out.println(stack);
        }

        private void print(int s, int t, int[] prev) {
            if (prev[t] == s) {
                System.out.printf(s + " -> " + t);
            } else {
                print(s, prev[t], prev);
                System.out.printf(" -> " + t);
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addEdge(1, 2);
        graph.addEdge(11, 7);
        graph.addEdge(2, 7);
        graph.addEdge(3, 9);
        graph.addEdge(8, 13);
        graph.addEdge(7, 13);
        graph.addEdge(7, 14);
        graph.addEdge(3, 16);
        graph.addEdge(5, 16);
        graph.addEdge(5, 8);
        graph.addEdge(3, 12);
        graph.addEdge(5, 9);
        graph.addEdge(9, 10);
        graph.bfs(1, 12);
        graph.dfs(1, 12);

        System.out.println(foundThirdFriend(graph, 1));
        System.out.println(foundThirdFriendNew(graph, 1));
    }

    //求三度好友关系

    public static List<Integer> foundThirdFriend(Graph g, int s){
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        first.addAll(g.adj[s]);
        for (int p : first) {
            LinkedList<Integer> p2 = g.adj[p];
            for (int p3 : p2) {
                if (!first.contains(p3) && !second.contains(p3)&& p3 != s){
                    second.add(p3);
                }
            }
        }
        for (int p : second) {
            LinkedList<Integer> p2 = g.adj[p];
            for (int p3 : p2) {
                if (!first.contains(p3) && !second.contains(p3) && !third.contains(p3)&& p3 != s){
                    third.add(p3);
                }
            }
        }

        return third;
    }
    //求三度好友关系

    public static List<Integer> foundThirdFriendNew(Graph g, int s){
        boolean[] visited = new boolean[g.v];
        visited[s] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        for (int i = 0; i < 3; i++) {
            if (!queue.isEmpty()){
                int p = queue.poll();
                for (int j = 0; j < g.adj[p].size(); j++) {
                    int p2 = (int) g.adj[p].get(j);
                    if (!visited[p2]) {
                        visited[p2] = true;
                        queue.add(p2);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }


}
