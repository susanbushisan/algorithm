package infrastructure;

import java.util.Arrays;

public class ArrayL {

    private int size;

    private int[] element;

    public ArrayL() {
        element = new int[10];
    }

    public void add(int i) {
        if (size >= element.length - 1) {
            int newCapacity = element.length + (element.length >> 1);
            element = Arrays.copyOf(element, newCapacity);
        }
        element[size++] = i;
    }

    public int get(int index){
        return element[index];
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        ArrayL arrayL = new ArrayL();
        for (int i = 0; i < 10000; i++) {
            arrayL.add(i);
        }
        for (int i = 0; i < 10000; i++) {
            System.out.println(arrayL.get(i));
        }
        System.out.println(arrayL.size());
    }
}
