import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 邪教自然有邪教的做法
 */
public class Question739 {
    public static void main(String[] args) {
        Question739 q = new Question739();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        long start = System.currentTimeMillis();
        int[] ints = q.dailyTemperatures(temperatures);
        System.out.println(System.currentTimeMillis() - start + "ms");
        System.out.println(Arrays.toString(ints));

    }

    public int[] dailyTemperaturesI(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int[] help = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        help[temperatures.length - 1] = -1;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                res[i] = 1;
                help[i] = i + 1;
            } else {
                int j = i + 1;
                while (true) {
                    if (temperatures[i] < temperatures[j]) {
                        res[i] = j - i;
                        help[i] = j;
                        break;
                    }
                    if (help[j] == -1){
                        res[i] = 0;
                        help[i] = -1;
                        break;
                    }
                    j = help[j];
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}
