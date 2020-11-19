### 方法一：迭代

两者比较然后改变新链表的位置，知道其中一个链表为空就可以将结果的链尾指向不为空的一端就完成了

~~~
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        ListNode t = d;
        while (l1 != null || l2 != null){
            if (l2 == null){
                t.next = l1;
                break;
            }else if (l1 == null){
                t.next = l2;
                break;
            }
            if (l1.val < l2.val){
                t.next = l1;
                l1 = l1.next;
            }else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        return d.next;
    }
~~~

时间复杂度：O(N+M)
空间复杂度：O(1)