### 方法一：哈希表

利用hash判重复

~~~
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head.val)){
                return true;
            }else {
                set.add(head.val);
            }
            head = head.next;
        }
        return false;
    }
~~~

时间复杂度为:O（N）
空间复杂度为：O（N）,最多需要大小为N的哈希表

### 方法二：双指针

~~~

~~~

时间复杂度为:O（N）
空间复杂度为：O（1）
