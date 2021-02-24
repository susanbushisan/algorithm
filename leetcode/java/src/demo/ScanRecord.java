package demo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用两个栈实现浏览器后退前进功能
 */
public class ScanRecord {

    private String currentStr;

    private Deque<String> back = new ArrayDeque<>();

    private Deque<String> ahead = new ArrayDeque<>();



    public void ahead() {
        back.push(currentStr);
        currentStr = ahead.pop();
        print();
    }

    public void back() {
        ahead.push(currentStr);
        currentStr = back.pop();
        print();
    }

    public void go(String str) {
        if (str == null){
            return;
        }
        if (currentStr != null){
            back.push(currentStr);
        }
        currentStr = str;
        print();
    }

    private void print(){
        System.out.println("---------------------");
        System.out.println("当前页面为：" + currentStr);
        System.out.println("后退列表为：" + back);
        System.out.println("前进列表为：" + ahead);
        System.out.println("---------------------");
    }

    public boolean canBack(){
        return !back.isEmpty();
    }

    public boolean canAhead(){
        return !ahead.isEmpty();
    }

    public static void main(String[] args) {
        //1.创建一个浏览器记录
        ScanRecord scanRecord = new ScanRecord();

        //2.浏览器访问页面A
        scanRecord.go("页面A");

        //extra:时候能后退
        System.out.println(scanRecord.canBack());

        //3.浏览器访问页面B
        scanRecord.go("页面B");

        //extra:时候能后退
        System.out.println(scanRecord.canBack());

        //4.浏览器后退到页面A
        scanRecord.back();

        //5.浏览器前进到页面B
        scanRecord.ahead();
    }


}
