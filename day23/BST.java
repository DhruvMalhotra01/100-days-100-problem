import java.util.*; // for Queue and LinkedList

public class BST {

    // ------------------------- Node Class -------------------------
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) { // constructor added
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // ------------------------- Tree Info Class (for diameter2) -------------------------
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    // ------------------------- Binary Tree Builder -------------------------
    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) return null; // fixed condition

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // ------------------------- Traversals -------------------------
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // ------------------------- Level Order -------------------------
    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    // ------------------------- Height -------------------------
    public static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ------------------------- Count of Nodes -------------------------
    public static int countOfNodes(Node root) {
        if (root == null) return 0;
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount + 1;
    }

    // ------------------------- Sum of Nodes -------------------------
    public static int sumOfNode(Node root) {
        if (root == null) return 0;
        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return leftSum + rightSum + root.data;
    }

    // ------------------------- Diameter (O(n^2)) -------------------------
    public static int diameter1(Node root) {
        if (root == null) return 0;
        int leftDiameter = diameter1(root.left);
        int rightDiameter = diameter1(root.right);
        int rootDiameter = height(root.left) + height(root.right) + 1;
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // ------------------------- Diameter (Optimized O(n)) -------------------------
    public static TreeInfo diameter2(Node root) {
        if (root == null) return new TreeInfo(0, 0);

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);

        return new TreeInfo(height, diameter);
    }

    // ------------------------- MAIN FUNCTION -------------------------
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Root Node: " + root.data);

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.println("Level Order:");
        levelOrder(root);

        System.out.println("Height of tree: " + height(root));
        System.out.println("Count of nodes: " + countOfNodes(root));
        System.out.println("Sum of nodes: " + sumOfNode(root));
        System.out.println("Diameter (O(n^2)): " + diameter1(root));
        System.out.println("Diameter (Optimized): " + diameter2(root).diameter);
    }
}
