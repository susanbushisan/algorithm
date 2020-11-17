思路

    发生碰撞的情况为相邻的两个数左边为负右边为正这一种情况，无限次发生碰撞之后剩下的数组就是答案

### 方法一：单调栈

~~~
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
~~~