package Demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root;

    //层序遍历
    public void sequence(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            System.out.print(temp.val + " ");
        }

    }

    public ArrayList<ArrayList<Integer>> zPrint(Node root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null) {
            return arrayLists;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> nodes = new ArrayList<>();
            while (size != 0) {
                Node temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }

                nodes.add(temp.val);
                if (flag % 2 == 0) {
                    Collections.reverse(nodes);
                }
                arrayLists.add(nodes);
                flag++;
                size--;
            }
        }
        return arrayLists;
    }
}
