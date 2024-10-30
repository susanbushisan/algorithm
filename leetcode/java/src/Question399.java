import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question399 {
    public static void main(String[] args) {
        Question399 q = new Question399();
        List<List<String>> equations = new ArrayList<>();
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        long start = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - start + "ms");
        System.out.println(Arrays.toString(q.calcEquation(equations, values, queries)));
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }

}
