思考

    简单且粗暴，拿到所有链表，然后判断本身元素，找到最小的构成结构，然后该条链表向后移动，结果通过了，但是时间复杂度很不理想时间复杂度为O（k*N^2）
    
    
### 方法一：顺序合并

简单且粗暴，拿到所有链表，然后判断本身元素，找到最小的构成结构，然后该条链表向后移动，结果通过了，但是时间复杂度很不理想时间复杂度为O（k*N^2）
~~~
public ListNode mergeKListsSlow(ListNode[] lists) {
    ListNode root = null;
    ListNode temp = null;
    boolean flag = false;
    while (true){
        int min = Integer.MAX_VALUE;
        int op = -1;
        for (int i = 0; i < lists.length; i ++) {
            ListNode list = lists[i];
            if (list == null){
                continue;
            }
            if (list.val < min){
                min = list.val;
                op = i;
            }
        }
        if(op == -1){
            break;
        }
        if (!flag){
            flag = true;
            temp = new ListNode(lists[op].val);
            root = temp;
            lists[op] = lists[op].next;
        }else {
            temp.next = new ListNode(lists[op].val);
            temp = temp.next;
            lists[op] = lists[op].next;
        }
    }
    return root;
}
~~~

具体实现：/src/Question23.mergeKListsSlow

### 方法二：暴力拆解

那么暴力的来了，将链表所有元素放到一个list中，然后排序，最后生成结果

~~~
public ListNode mergeKLists(ListNode[] lists) {
    List<Integer> list = new ArrayList<>();
    for (ListNode listNode : lists) {
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
    }
    Collections.sort(list);
    ListNode root = null;
    ListNode temp = null;
    if (list.size()>0){
        temp = new ListNode(list.get(0));
        root = temp;
    }
    for (int i = 1; i < list.size(); i++) {
        temp.next = new ListNode(list.get(i));
        temp = temp.next;
    }
    return root;

}
~~~
具体实现：/src/Question23.mergeKLists

### 方法三：小根堆

和方法一的进一步处理，使用最小堆（小根堆）优化找到最小头元素方法，可以将时间复杂度降到O(kN *logk)
~~~
private ListNode mergeKListsRight(ListNode[] lists) {
    Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
    for (ListNode node: lists) {
        if (node != null) {
            pq.offer(node);
        }
    }

    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    while (!pq.isEmpty()) {
        ListNode minNode = pq.poll();
        tail.next = minNode;
        tail = minNode;
        if (minNode.next != null) {
            pq.offer(minNode.next);
        }
    }

    return dummyHead.next;

}
~~~
具体实现：/src/Question23.mergeKListsRight