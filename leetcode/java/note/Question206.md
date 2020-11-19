### 方法一：迭代

~~~
    public ListNode reverseList(ListNode head) {
        ListNode d = null;
        while (head!=null){
            ListNode temp = head;
            head = head.next;
            temp.next = d;
            d = temp;
        }
        return d;
    }
~~~

时间复杂度：O(N)
空间复杂度：O(1)

### 方法二：递归

~~~
    public ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
~~~

时间复杂度：O(N)
空间复杂度：O(N)