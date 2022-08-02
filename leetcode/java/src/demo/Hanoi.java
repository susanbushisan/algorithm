package demo;

import java.util.*;

/**
 * 经典汉洛塔问题
 */
public class Hanoi {
    public static void main(String[] args) {
        // n代表盘子的个数
        int n = 4;
        new Hanoi().hanoi(n);
    }

    Deque<Integer> a;
    Deque<Integer> b;
    Deque<Integer> c;

    int step = 1;

    private void hanoi(int n) {
        a = new ArrayDeque<>(n);
        b = new ArrayDeque<>(n);
        c = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            a.push(n-i);
        }
        print();
        helper(n, a, b, c);
        System.out.println(c);
    }


    void helper(int n, Deque<Integer> a, Deque<Integer> b, Deque<Integer> c) {
        if (n == 1) {
            c.push(a.poll());
            print();
            return;
        }
        helper(n - 1, a, c, b);
        helper(1, a, b, c);
        helper(n - 1, b, a, c);
    }

    private void print() {
        System.out.println("---step" + step++ + "----");
        Deque<String> print = new ArrayDeque<>();
        print.push("a\tb\tc");
        Deque<Integer> aTemp = new ArrayDeque<>(a);
        Deque<Integer> bTemp = new ArrayDeque<>(b);
        Deque<Integer> cTemp = new ArrayDeque<>(c);
        while (!aTemp.isEmpty() || !bTemp.isEmpty() || !cTemp.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            if (!aTemp.isEmpty()) {
                sb.append(aTemp.pollLast());
            }
            sb.append('\t');
            if (!bTemp.isEmpty()) {
                sb.append(bTemp.pollLast());
            }
            sb.append('\t');
            if (!cTemp.isEmpty()) {
                sb.append(cTemp.pollLast());
            }
            print.push(sb.toString());
        }
        while (!print.isEmpty()) {
            System.out.println(print.poll());
        }
        System.out.println("----end-----");
    }

}
