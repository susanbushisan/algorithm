public class Question641 {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));                    // 返回 true
        System.out.println(circularDeque.insertLast(2));                    // 返回 true
        System.out.println(circularDeque.insertFront(3));                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                        // 返回 true
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 返回 true
        System.out.println(circularDeque.getFront());                // 返回 4

    }

    static class MyCircularDeque {
        private final int[] element;

        private int left;
        private int right;

        private int size;

        public MyCircularDeque(int k) {
            element = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            left--;
            if (left == -1) {
                left = element.length - 1;
            }
            element[left] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            element[right] = value;
            right++;
            if (right == element.length) {
                right = 0;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            left++;
            if (left == element.length) {
                left = 0;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            right--;
            if (right == -1) {
                right = element.length - 1;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return element[left];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return right == 0 ? element[element.length - 1] : element[right - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == element.length;
        }
    }
}
