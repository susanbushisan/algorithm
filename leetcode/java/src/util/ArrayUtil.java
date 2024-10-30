package util;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ArrayUtil {

    public static ScriptEngine engineFactory() {
        return new ScriptEngineManager()
                .getEngineByName(System.getProperty("java.version").contains("1.8.") ? "nashorn" : "rhino");
    }

    /**
     * JVM 自带的 JS 引擎
     */
    private final static ScriptEngine engine = engineFactory();

    public static int[][] creatTwoDimensionalArray(String input) {

        ScriptObjectMirror eval = null;
        try {
            eval = (ScriptObjectMirror) engine.eval("JSON.parse('" + input + "')");
        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        int size = eval.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            ScriptObjectMirror slot = (ScriptObjectMirror) eval.getSlot(i);
            int[] ints = new int[slot.size()];
            for (int j = 0; j < slot.size(); j++) {
                ints[j] = (int) slot.getSlot(j);
            }
            res[i] = ints;
        }
        return res;
    }

}
