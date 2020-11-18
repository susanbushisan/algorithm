思考

    题目字面意思就是找从root到叶子节点的和等于给定值，那找到所有的路劲然后和值进行对比，如果相等就把路劲保存起来，用深度优先搜索（dfs）就可以了


    上一种方法性能太差，有更好的做法，使用回溯法，使用一个list记录当前路劲，如果符合就加入结果，不符合就遍历左右节点然后将自己的节点移除

### 方法一：回溯

~~~
    public List<List<Integer>> pathSum2(struct.TreeNode root, int sum) {
        List<List<Integer>> paths=new ArrayList<List<Integer>>();
        go(root,0,sum,new ArrayList<Integer>(),paths);
        return paths;
    }

    private void go(struct.TreeNode node,int sum,int target,ArrayList<Integer> path,List<List<Integer>> paths){
        if(node==null)return;
        sum+=node.val;
        path.add(node.val);
        //判断该路径和是否符合目标值
        if(sum==target&&node.left==null&&node.right==null){
            paths.add(new ArrayList<Integer>(path));
        }else{
            go(node.left,sum,target,path,paths);
            go(node.right,sum,target,path,paths);
        }
        //回溯
        path.remove(path.size()-1);
    }
~~~

具体实现:/src/Question113.java

分析：
回溯法：时间复杂度为O(n^2),空间复杂度为O（n）