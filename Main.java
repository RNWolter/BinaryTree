
import java.util.Queue;
import java.util.LinkedList;


class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}


class BinaryTree {

    Node root;


    void printTree() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");


            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }


            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public int countTree(Node root) {


        if (root.left == null && root.right == null) {
            return root.data;
        }

        int countRight = countTree(root.left);
        int countLeft = countTree(root.right);
        return root.data + countLeft + countRight;


    }


    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        tree.printTree();
        System.out.print(tree.countTree(tree.root));
    }
}
