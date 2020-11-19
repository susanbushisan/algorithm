### 方法一：双指针法

快指针先走n步，然后快慢指针同时向后走知道快指针到链尾，然后删除慢指针的下一个原始
~~~
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode();
        d.next = head;
        ListNode t = d,slow = d;
        int count = 0;
        while (t != null){
            if (count>n){
                slow  = slow.next;
            }
            t = t.next;
            count ++;
        }
        slow.next = slow.next.next;
        return d.next;
    }
~~~

时间复杂度为：O(N)
空间复杂度为：O(1)