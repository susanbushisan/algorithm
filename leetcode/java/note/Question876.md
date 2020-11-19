### 方法一：双指针

典项的双指针题，找中点

~~~
    public ListNode middleNode(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
~~~

时间复杂度：O(N)
空间复杂度：O(1)