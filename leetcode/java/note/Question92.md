思考

    该霸蛮时就霸蛮，一趟扫描，就是不停该next进行反转呗。

### 方法一：分段讨论

~~~
    public struct.ListNode reverseBetween(struct.ListNode head, int m, int n) {
        struct.ListNode d = new struct.ListNode(0) , mEl = null, mElP = null, nEl = null;
        struct.ListNode temp = d;
        temp.next = head;
        if (m == n){
            return  d.next;
        }
        int index = 0;
        while (true) {
            if (index < m - 1){
                temp = temp.next;
                index ++;
            }else if (index == m - 1) {
                mElP = temp;
                temp = temp.next;
                index ++;
            }else if (index == m){
                mEl = temp;
                nEl = temp;
                temp = temp.next;
                index ++;
            }else if (index < n ){
                struct.ListNode next = temp.next;
                temp.next = mEl;
                mEl = temp;
                temp = next;
                index ++;
            }else {
                struct.ListNode next = temp.next;
                temp.next = mEl;
                mElP.next = temp;
                nEl.next = next;

                break;
            }

        }
        return d.next;
    }
~~~

具体实现src/Question92.java

时间复杂度为O(N)，空间复杂度为O(1)