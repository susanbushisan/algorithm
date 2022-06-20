这真是太巧了，这是我2021年参加一个面试的面试题，当时我觉得这道题挺简单的，现在直接碰到了。而且这道题和21题神似。
既然如此，那让我探究一下最优解。

### 方案一：栈辅助
~~~ java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> s1 = new ArrayDeque<>();
        Deque<ListNode> s2 = new ArrayDeque<>();
        while (l1 != null){
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        boolean flag = false;
        while (!s1.isEmpty() || !s2.isEmpty() || flag){
            int i = 0;
            if (!s1.isEmpty()){
                i += s1.pop().val;
            }
            if (!s2.isEmpty()){
                i += s2.pop().val;
            }
            if (flag){
                i ++;
            }
            if (i >= 10){
                i -= 10;
                flag = true;
            }else {
                flag = false;
            }
            ListNode temp = res;
            res = new ListNode(i);
            res.next = temp;
        }
        return res;
    }
~~~
