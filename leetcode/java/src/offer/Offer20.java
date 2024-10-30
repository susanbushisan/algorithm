package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer20 {

    public static void main(String[] args) {
        Offer20 o = new Offer20();
        System.out.println(o.isNumber(".1"));
    }

    public boolean isNumber(String s) {
        List<Map<Character, Integer>> states = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            states.add(new HashMap<>());
        }
        states.get(0).put(' ', 0);
        states.get(0).put('p', 1);
        states.get(0).put('d', 2);
        states.get(0).put('.', 4);
        states.get(1).put('d', 2);
        states.get(1).put('.', 4);
        states.get(2).put('d', 2);
        states.get(2).put('.', 3);
        states.get(2).put('e', 5);
        states.get(2).put(' ', 8);
        states.get(3).put('d', 3);
        states.get(3).put('e', 5);
        states.get(3).put(' ', 8);
        states.get(4).put('d', 3);
        states.get(5).put('p', 6);
        states.get(5).put('d', 7);
        states.get(6).put('d', 7);
        states.get(7).put('d', 7);
        states.get(7).put(' ', 8);
        states.get(8).put(' ', 8);

        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char t = '?';
            if (Character.isDigit(c)) {
                t = 'd';
            } else if (Character.isSpaceChar(c)) {
                t = ' ';
            } else if (c == '.') {
                t = '.';
            } else if (c == '+' || c == '-') {
                t = 'p';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            }
            if (!states.get(p).containsKey(t)) {
                return false;
            }
            p = states.get(p).get(t);
        }
        return p == 2 || p == 4 || p == 7 || p == 8;
    }

}
