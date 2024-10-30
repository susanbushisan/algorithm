import struct.ListNode;
import util.ListNodeUtils;

import java.util.*;

/**
 * 合并K个升序链表
 */
public class Question23 {
    public static void main(String[] args) throws Exception {
        Question23 q = new Question23();
        ListNode[] lists = {
                ListNodeUtils.creatListNode(1, 4, 5,3,2,3,346,56,456,57,5,3463,56,35,6354,73,456,3),
                ListNodeUtils.creatListNode(1, 3, 4,245,25,2354,2,46,567,4,56,34,56,35,63,57,54,3,56,3456,65),
                ListNodeUtils.creatListNode(2, 6,65346,3547,7,345,3,5,46,546,345,6,35,7,73,456,345,634,5),
        };

        long start = System.currentTimeMillis();
        System.out.println("\n方法一：");
        System.out.println(q.mergeKLists(lists));
        System.out.println(System.currentTimeMillis() - start + "ms");

        start = System.currentTimeMillis();
        System.out.println("\n方法二：");
        System.out.println(q.mergeKListsSlow(lists));
        System.out.println(System.currentTimeMillis() - start + "ms");


        ListNode[] listsT = {
                ListNodeUtils.creatListNode(1, 4, 5,3,2,3,346,56,456,57,5,3463,56,35,6354,73,456,3),
                ListNodeUtils.creatListNode(1, 3, 4,245,25,2354,2,46,567,4,56,34,56,35,63,57,54,3,56,3456,65),
                ListNodeUtils.creatListNode(2, 6,65346,3547,7,345,3,5,46,546,345,6,35,7,73,456,345,634,5),
        };
        start = System.currentTimeMillis();
        System.out.println("\n方法三：");
        System.out.println(q.mergeKListsRightI(listsT));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    private ListNode mergeKListsRightI(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
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

    /**
     * 将所有元素放在数组当中，然后排序，最后返回生成链表
     */
    public ListNode mergeKListsI(ListNode[] lists) {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode d = new ListNode();
        ListNode ln = d;
        Queue<ListNode> priority = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (ListNode list : lists) {
            if (list != null){
                priority.add(list);
            }
        }
        while (!priority.isEmpty()){
            ListNode poll = priority.poll();
            ln.next = poll;
            ln = ln.next;
            if (poll.next != null){
                priority.add(poll.next);
            }
        }
        return d.next;
    }
}
