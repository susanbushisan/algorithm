我觉得应该是分情况讨论，时间复杂度O（N）就可以扫描出答案，当然我这里使用了一个List作为中间存储

这题写的快吐了，完全使用各种判断去解题，分别考虑全部的情况

### 方法一：分组讨论边界情况
~~~
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();
        int status = 0;
        for (int[] interval : intervals) {
            for (int j = 0; j < 2; j++) {
                if (status == 0) {
                    if (interval[j] >= newInterval[0]) {
                        if (j == 1) {
                            newInterval[0] = interval[0];
                        }
                        status = 1;
                    } else if (j == 1) {
                        temp.add(interval);
                    }
                }
                if (status == 1) {
                    if (interval[j] > newInterval[1]) {
                        if (j == 1) {
                            newInterval[1] = interval[1];
                        }
                        temp.add(newInterval);
                        status = 2;
                        continue;
                    }
                }
                if (status == 2 && j == 1) {
                    temp.add(interval);
                }

            }
        }
        if (status != 2){
            temp.add(newInterval);
        }

        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
~~~
代码实现：src/Question57.java

空间复杂度为O（1）没有使用额外的空间