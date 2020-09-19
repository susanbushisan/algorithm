

public class Question42 {


    public static void main(String[] args) {
        Question42 q = new Question42();
        int[] height = {
                0,1,0,2,1,0,1,3,2,1,2,1
        };
        long start = System.currentTimeMillis();
        System.out.println(q.trap(height));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public int trap(int[] height) {
        if (height.length <2){
            return 0;
        }
        int area = 0,start = 0,minHeight = height[0];
        for (int i = 1; i < height.length; i++) {
            if (minHeight < height[i]){
                int w = i -start - 1;
                area += w *minHeight;
                for (int j = start + 1; j < i; j++) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        start = height.length -1;minHeight = height[height.length -1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (minHeight <= height[i]){
                int w = start - i -1;
                area += w *minHeight;
                for (int j =  start - 1; j > i; j--) {
                    area -= height[j];
                }
                minHeight = height[i];
                start = i;
            }
        }
        return area;
    }
}
