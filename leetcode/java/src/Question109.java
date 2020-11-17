import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question109 {

    public static void main(String[] args) {
        Question109 q164 = new Question109();
        ListNode root = ListNodeUtils.creatListNode(-10, -3, 0, 5, 9);
        long start = System.currentTimeMillis();
        System.out.println(q164.sortedListToBST(root));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!= null){
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        TreeNode treeNode = toBST(arr);
        return treeNode;
    }

    private TreeNode toBST(int[] arr) {
        if (arr.length == 0){
            return null;
        }
        int center = arr.length / 2 + 1;
        TreeNode top = new TreeNode(arr[center - 1]);
        if (center != 1) {
            top.left = toBST(Arrays.copyOfRange(arr, 0, center - 1));
            top.right = toBST(Arrays.copyOfRange(arr, center, arr.length));
        }
        return top;
    }
}
