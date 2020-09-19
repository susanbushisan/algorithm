
public class Question1037 {

    public static void main(String[] args) {
        Question1037 q1037 = new Question1037();
        int[][] point = { { 1, 1 }, { 2, 3 }, { 3, 2 } };
        long start = System.currentTimeMillis();
        System.out.println(q1037.isBoomerang(point));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];

        return (x1 - x2) * (y1 - y3) == (x1 - x3) * (y1 - y2);
    }
}
