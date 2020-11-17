又是链表题，看来双指针法能发挥作用了。

不过想做个暴力的看行不行

### 方法一：大力出奇迹

~~~
    public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        Deque<ListNode> deque = new LinkedList<>();
        ListNode var = head.next;
        while (var != null){
            deque.addLast(var);
            var = var.next;
        }


        while (!deque.isEmpty()){
            ListNode listNode = deque.pollLast();
            head.next = listNode;
            head = listNode;
            if (!deque.isEmpty()){
                listNode = deque.pollFirst();
                head.next = listNode;
                head = listNode;
            }
        }
        head.next = null;
    }



~~~

没想到过了，思路就是用双向队列将每一个节点保存起来，然后队头队尾依次出队被head链起来

代码实现：src/Question143.java

时间复杂度为O（N）一遍搞定，空间复杂度为O（N），需要N的双向队列

不过双指针法应该是更好的思路，可惜这张纸写不下