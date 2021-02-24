package demo;

/**
 * 基于数组实现的循环队列
 */
public class CircularQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(8);
        System.out.println(circularQueue.enqueue("0"));
        System.out.println(circularQueue.enqueue("1"));
        System.out.println(circularQueue.enqueue("2"));
        System.out.println(circularQueue.enqueue("3"));
        System.out.println(circularQueue.enqueue("4"));
        System.out.println(circularQueue.enqueue("5"));
        System.out.println(circularQueue.enqueue("6"));
        System.out.println(circularQueue.enqueue("7"));
        System.out.println(circularQueue.enqueue("8"));
        System.out.println(circularQueue.dequeue());
    }

    //循环队列队满的时候tail指向空，所以数组要加1
    public CircularQueue(int capacity){
        items = new String[capacity + 1];
        n = capacity + 1;
    }

    public boolean enqueue(String item){
        //判断队列是否满了
        if ((tail+1)%n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;

    }

    public String dequeue(){
        //判断队列是否为空
        if (tail == head){
            return null;
        }
        String res  = items[head];
        items[head++] = null;
        if (head == n){
            head = 0;
        }
        return res;
    }
}
