思考

没啥好说的，基础链表题，抡起袖子就是干
    
### 方法一：模拟进位运算

设置一个进位标志符，运算的时候加上它，如果链表到表尾了就用0代替

~~~
while (t1!=null || t2!= null || step){
    temp = t1 + t2 + step
    tNode.next = new ListNode(temp);
}
~~~

代码实现：src/Question2.addTwoNumbers

- 时间复杂度O（M） M代表两个链表比较长的那个的长度
- 空间复杂度O（M）

### 方法二：暴力解法

将链表转为数字，然后运算，然后再转为链表,然而链表太长了需要使用BigInteger去操作

~~~
StringBuilder stringBuilder = new StringBuilder();

while (l1 != null){
    stringBuilder.append(l1.val);
    l1 = l1.next;
}
int n1 = Integer.parseInt(stringBuilder.reverse().toString());

stringBuilder.setLength(0);

while (l2 != null){
    stringBuilder.append(l2.val);
    l2 = l2.next;
}
int n2 = Integer.parseInt(stringBuilder.reverse().toString());

int res = n1 + n2;

if (res == 0){
    return new ListNode(0);
}

ListNode result = new ListNode(-1) ;
ListNode temp = result;

do {
    temp.next = new ListNode( res%10);
    temp = temp.next;
    res /= 10;
}while (res > 0);

return result.next;
~~~
- 时间复杂度O（M） M代表两个链表比较长的那个的长度
- 空间复杂度O（M）

### 方法三：复用链表

在方法一的基础上如果出现了链表长度相差悬殊，可能造成空间的浪费，当摸个位置只有一条链表能到达并且进位为0时，将能达到的链表链在result后面即可

~~~
ListNode result = new ListNode((l1.val + l2.val) % 10);
ListNode re = result;
int carry = (l1.val + l2.val) >= 10 ? 1 : 0;
while (l1.next != null && l2.next != null) {
    l1 = l1.next;
    l2 = l2.next;
    int sum = l1.val + l2.val + carry;
    if (sum >= 10) {
        result.next = new ListNode(sum - 10);
        result = result.next;
        carry = 1;
    } else {
        result.next = new ListNode(sum);
        result = result.next;
        carry = 0;
    }
}
if (l1.next == null && l2.next == null) {
    if (carry == 1) {
        result.next = new ListNode(1);
    }
    return re;
} else if (l1.next == null) {
    while (l2.next != null) {
        l2 = l2.next;
        int sum = l2.val + carry;
        if (sum >= 10) {
            result.next = new ListNode(sum - 10);
            result = result.next;
            carry = 1;
        } else {
            result.next = new ListNode(sum);
            result = result.next;
            carry = 0;
        }
    }
    if (carry == 1) {
        result.next = new ListNode(1);
    }
    return re;
} else {
    while (l1.next != null) {
        l1 = l1.next;
        int sum = l1.val + carry;
        if (sum >= 10) {
            result.next = new ListNode(sum - 10);
            result = result.next;
            carry = 1;
        } else {
            result.next = new ListNode(sum);
            result = result.next;
            carry = 0;
        }
    }
    if (carry == 1) {
        result.next = new ListNode(1);
    }
    return re;
}

~~~

代码实现：src/Question2.addTwoNumbers2

- 时间复杂度O（N） N代表两个链表比较短的那个的长度
- 空间复杂度O（N）