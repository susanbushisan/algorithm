import struct.ListNode;
import util.ListNodeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question207 {
    public static void main(String[] args) {
        Question207 q = new Question207();
        int[][] prerequisites = {{1, 0}};
        long start = System.currentTimeMillis();
        System.out.println(q.canFinish(2, prerequisites));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            for (int i = 1; i < prerequisite.length; i++) {
                edge.get(prerequisite[i-1]).add(prerequisite[i]);
                inDegree[prerequisite[i]] ++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            visited ++;
            Integer remove = queue.remove();
            for (int i = 0; i < edge.get(remove).size(); i++) {
                int k = edge.get(remove).get(i);
                inDegree[k] --;
                if (inDegree[k] == 0){
                    queue.add(k);
                }
            }
        }

        return visited == numCourses;
    }


}
