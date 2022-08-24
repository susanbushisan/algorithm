package util;

import java.util.function.Supplier;

public class TimerUtils {

    public static <T> T op(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T res = supplier.get();
        System.out.println(System.currentTimeMillis() - start + "ms");
        return res;
    }
}
