package 算法类.domain;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {






    private static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            Queue queue = new LinkedList();
            queue.add(this);
            while (!queue.isEmpty()){
                for (int i = 0; i < queue.size(); i++) {
                     TreeNode cur = (TreeNode) queue.poll();
                     queue.add(cur.left);
                     queue.add(cur.right);
                }
            }
            return queue.toString();
        }
    }
}
