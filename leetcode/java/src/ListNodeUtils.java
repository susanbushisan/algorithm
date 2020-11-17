import java.util.HashSet;
import java.util.Set;

final public class ListNodeUtils {
    /**
     * 构造一个链表
     */
    public static ListNode creatListNode(int... x) {
        if (x.length == 0) {
            return null;
        }

        ListNode head = new ListNode(x[0]);
        ListNode listNode = head;
        for (int i = 1; i < x.length; i++) {
            listNode.next = new ListNode(x[i]);
            listNode = listNode.next;
        }

        return head;
    }

    /**
     * 链表成环
     *
     * @param root     操作链表
     * @param position 环切点
     */
    public static void circleListNode(ListNode root, int position) {
        if (root == null) {
            return;
        }
        int cp = 0;
        ListNode temp = null;
        while (root.next != null) {
            root = root.next;
            if (position == ++cp) {
                temp = root;
            }
        }
        if (cp < position) {
            throw new ArrayIndexOutOfBoundsException("链表长度为: " + cp + ", 环切点为 " + position + ", 无法成环");
        }
        root.next = temp;


    }

    /**
     * 打印链表
     *
     * @param head 链表头
     */
    public static void printListNode(ListNode head) {
        printListNode(head, " -> ");
    }

    /**
     * 打印链表
     *
     * @param head      链表头
     * @param delimiter 分隔符
     */
    public static void printListNode(ListNode head, String delimiter) {
        if (head == null) {
            return;
        }
        StringBuilder r = new StringBuilder();
        ListNode temp = head;
        Set<ListNode> contain = new HashSet<>();
        while (temp != null) {
            if (contain.contains(temp)) {
                r.append(delimiter).append(" link after ").append(temp.val);
                break;
            }
            contain.add(temp);
            if (temp != head) {
                r.append(delimiter);
            }
            r.append(temp.val);
            temp = temp.next;
        }
        System.out.println(r);
    }

    /**
     * 打印成环链表
     *
     * @param head 链表头
     */
    public static void printCircleListNode(ListNode head) {
        printCircleListNode(head, " -> ");
    }

    /**
     * 打印成环链表
     *
     * @param head      链表头
     * @param delimiter 分隔符
     */
    public static void printCircleListNode(ListNode head, String delimiter) {
        if (head == null) {
            return;
        }
        ListNode circle = findCircle(head);

        StringBuilder r = new StringBuilder();
        ListNode temp = head;
        boolean flag = false;
        int index = 0;
        while (temp != null) {
            if (temp == circle) {
                if (flag) {
                    break;
                } else {
                    flag = true;
                    System.out.println("tail connects to node index " + index);
                }
            }
            if (temp != head) {
                r.append(delimiter);
            }
            r.append(temp.val);
            temp = temp.next;
            index++;
        }
        System.out.println(r);
    }

    private static ListNode findCircle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = creatListNode(123, 321, 32, 32, 13, 213, 1);
        circleListNode(listNode, 4);

        printListNode(listNode);
    }
}
