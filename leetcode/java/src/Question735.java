

import java.util.Arrays;


public class Question735 {

    public static void main(String[] args) {
        Question735 q735 = new Question735();
        int[] asteroids = {1,-1,-2,-2};
        long start = System.currentTimeMillis();
        System.out.print(Arrays.toString(q735.asteroidCollision(asteroids)));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /**
     * 不会再发生碰撞的情况，正数后面出现负数
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        int[] result = new int[asteroids.length];
        int resultIndex = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                while (true){
                    if (resultIndex == 0){
                        result[resultIndex] = asteroids[i];
                        resultIndex ++;
                        break;
                    }
                    if (result[resultIndex - 1] > 0){
                        //产生碰撞
                        if(Math.abs(asteroids[i]) == Math.abs(result[resultIndex - 1])){
                            result[resultIndex - 1] = 0;
                            resultIndex -- ;
                            break;
                        }else if (Math.abs(asteroids[i]) > Math.abs(result[resultIndex - 1])){
                            result[resultIndex - 1] = 0;
                            resultIndex -- ;
                            if(resultIndex == 0){
                                result[resultIndex] = asteroids[i];
                                resultIndex ++;
                                break;
                            }
                        }else {
                            break;
                        }
                    }else {
                        result[resultIndex] = asteroids[i];
                        resultIndex ++;
                        break;
                    }
                }

            }else{
                result[resultIndex] = asteroids[i];
                resultIndex ++;
            }
        }
        return Arrays.copyOf(result,resultIndex);
    }
}