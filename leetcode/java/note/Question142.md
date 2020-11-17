思考

    将已经访问的节点放入set中，第二次访问到就代表这个节点是入环的第一个节点，但是此时的空间复杂度为O（n），想要空间复杂度达到O(1)，那么可以使用快慢指针，快指针的速度是慢指针的2倍，如果能形成环他们会在n时刻相遇，之后再让head和慢指针一起走，相遇的节点就是入环的节点。（原因是他们两个指针走n步必定相遇，并且他们速度一样，那么相遇的第一个节点就是入环的节点）

### 方法一：哈希表

~~~
    /**
     * 通过Set，找到重复的节点为答案
     */
    public ListNode detectCycleTerrible(ListNode head) {
        Set<ListNode> context = new HashSet<ListNode>();
        ListNode temp = head;
        while(temp != null){
            if(context.contains(temp)){
                return temp;
            }
            context.add(temp);
            temp = temp.next;
        }
        return null;
    }
~~~

时间复杂度为：O（N），空间复杂度为O（N）

### 方法二：双指针

~~~
    /**
     * 快慢指针，可以通过数据证明
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        try {
            do{
                fast = fast.next.next;
                slow = slow.next;
            }
            while (fast != slow);
        } catch (Exception e) {
            return null;
        }
        while (head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
~~~

时间复杂度为：O（N），空间复杂度为O（1）
