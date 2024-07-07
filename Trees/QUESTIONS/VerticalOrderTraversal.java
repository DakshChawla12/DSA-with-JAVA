package QUESTIONS;

import java.util.*;

public class VerticalOrderTraversal {

    class Tuple {
        TreeNode node;
        int vertical_level;
        int horizontal_level;
        public Tuple(TreeNode _node, int verticalLevel, int horizontalLevel) {
            node = _node;
            vertical_level = verticalLevel;
            horizontal_level = horizontalLevel;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List < List < Integer >> findVertical(TreeNode root) {

        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList <> ();

        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.vertical_level;
            int y = tuple.horizontal_level;


            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
            }
            map.get(x).get(y).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

}
