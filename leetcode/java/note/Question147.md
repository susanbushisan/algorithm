思考

    此题考验的就是链表的排序，对于排序算法没有那么方便，比较方便的是归并排序
    
### 方法一：归并排序

~~~
    public struct.ListNode insertionSortList(struct.ListNode head) {
        if(head == null||head.next==null){
            return head;
        }

        struct.ListNode fast = head;
        struct.ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        struct.ListNode breakPoint = slow.next;
        slow.next = null;
        struct.ListNode left = insertionSortList(head);
        struct.ListNode right = insertionSortList(breakPoint);
        return sort(left,right);
    }

    private struct.ListNode sort(struct.ListNode left,struct.ListNode right){
        if (left == null){
            return right;
        }else if (right == null){
            return left;
        }
        if (left.val < right.val){
            left.next = sort(left.next,right);
            return left;
        }else {
            right.next = sort(right.next,left);
            return right;
        }
    }
~~~

具体实现:/src/Question113.java


分析：时间复杂度为O(nlogn),空间复杂度为O（1）