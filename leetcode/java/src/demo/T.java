package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T {
    public static void main(String[] args) {

        int i = 1000;
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            List<Integer> l = new ArrayList<>();
            int t = j;
            while (t / 2 != 0){
                t = t/2;
                l.add(t);
            }
            System.out.println(l.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }


}
