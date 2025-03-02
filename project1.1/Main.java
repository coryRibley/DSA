import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //First, create a Node class
    public static class Node {
        //The left and right child of the current node are created,
        //as well as the current node and its key value
        int key;
        Node left, right;
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
     
    public static class BinaryTree {
        // Root
        Node root;
        ArrayList<Integer> preOrderList;
        ArrayList<Integer> postOrderList;

        //constructor
        BinaryTree() {
            root = new Node(4);
            root.left = new Node(2);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
            root.right = new Node(6);
            root.right.left = new Node(5);
            root.right.right = new Node(7);
            preOrderList = new ArrayList<>();
            postOrderList = new ArrayList<>();
        }

        public Node add(Node curr, int key) {
            if (curr == null) {
                Node newNode = new Node(key);
                return newNode;
            }

            if (key <= curr.key) {
                curr.left = add(curr.left, key);
            }
            else {
                curr.right = add(curr.right, key);
            }

            return curr;
        }



        // Helper function to find the smallest node in a subtree
        private Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        // Function to delete a node with a given key
        private Node delete(Node curr, int key) {
            if (curr == null) return null;
            
            if (key == root.key) { return removeRoot(root); }

            if (key < curr.key) {
                curr.left = delete(curr.left, key);
            } else if (key > curr.key) {
                curr.right = delete(curr.right, key);
            } else {
                // Node found
                // If node only has one child:
                if (curr.left == null) return curr.right;
                if (curr.right == null) return curr.left;
            
                // Replace with successor if node has two children
                Node successor = findMin(curr.right);
                curr.key = successor.key;
                curr.right = delete(curr.right, successor.key);
            }
        
            return curr;
        }

        public Node removeRoot(Node curr) {
            if (curr == null) return null;
        
            // Case 1: Root has no children
            if (curr.left == null && curr.right == null) {
                return null;
            }
        
            // Case 2: Root has only one child
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
        
            // Case 3: Root has two children
            Node successor = findMin(curr.right);  // Get in-order successor
            curr.key = successor.key;              // Replace root with successor value
            curr.right = delete(root.right, successor.key); // Delete successor
        
            return root;
        }

        public void printInOrder() {
            // Update preOrderedList to correctly sort
            preOrderList.clear();
            updatePreOrder(root);
            int[] sorted = new int[preOrderList.size()];

            // Copy array list into array to sort within
            for (int i = 0; i < preOrderList.size(); i++) {
                sorted[i] = preOrderList.get(i);
            }

            // Sort array using bubble sort
            int temp;
            for (int i = sorted.length - 1; i > 0; i--) {
                for (int j = 0; j < i - 1; j++) {
                    if (sorted[j] > sorted[j + 1]) {
                        temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }


            // Print sorted array contents
            System.out.println("\nIn-order Traversal: ");
            for (int num : sorted) {
                System.out.print("" + num + " ");
            }
            System.out.println();
        }

        public void printPreOrder() {
            preOrderList.clear();  // Clear before updating
            updatePreOrder(root);  // Update preOrderList

            System.out.println("\nPre-order Traversal: ");
            // Print each element in pre-ordered list
            for (int num : preOrderList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        private void updatePreOrder(Node curr) {
            if (curr == null) return;  // Base case for recursion

            preOrderList.add(curr.key);  // Add current node (parent)
            updatePreOrder(curr.left);  // Visit left child
            updatePreOrder(curr.right); // Visit right child

        }

        public void printPostOrder() {
            postOrderList.clear();  // Clear before updating
            updatePostOrder(root);  // Update

            System.out.println("\nPost-order Traversal: ");
            // Print each element in post-ordered list
            for (int num : postOrderList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        private void updatePostOrder(Node curr) {
            if (curr == null) return;  // Base case for recursion

            updatePostOrder(curr.left);  // Visit left child
            updatePostOrder(curr.right); // Visit right child

            postOrderList.add(curr.key);  // Add parent after visiting children
        }

    }

    // Menu Display
    public static void displayMenu() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n1. Create a binary search tree\n");
        System.out.println("2. Add a node\n");
        System.out.println("3. Delete a node\n");
        System.out.println("4. Print nodes by In-order\n");
        System.out.println("5. Print nodes by Pre-order\n");
        System.out.println("6. Print nodes by Post-order\n");
        System.out.println("7. Exit the program\n");
    }

    // Main function
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean created = false; // Allows correct detection for tree having been created
        BinaryTree tree = new BinaryTree(); // Creates default tree
        System.out.println("\nWelcome to the Binary Tree Manager.\n");
        displayMenu(); // Display Menu

        while (true) {
            try {
                System.out.print("Input: ");
                Integer input = scnr.nextInt();

                switch (input) {
                    case 1: 
                    if (created) { System.out.println("\nTree already created."); break; }
                        created = true;
                        System.out.println("\nTree successfully created.");
                        displayMenu(); // Display Menu
                        break;
                    case 4: 
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printInOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 5: 
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printPreOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 6: 
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printPostOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 7:
                        System.out.println("\nExiting Program...");
                        scnr.close();
                        System.exit(0);
                    default:
                        System.out.println("\nMenu item is invalid. Please try again.");
                }

            } 
            finally {

            }
        }
    }
}