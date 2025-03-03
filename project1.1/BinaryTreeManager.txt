import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Node class
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
        Node root; // Root
        ArrayList<Integer> order; // List used to print tree contents to the terminal

        // Constructor method
        BinaryTree() {
            root = new Node(4);
            root.left = new Node(2);
            root.left.left = new Node(1);
            root.left.right = new Node(3);
            root.right = new Node(6);
            root.right.left = new Node(5);
            root.right.right = new Node(7);
            order = new ArrayList<>();
            order = new ArrayList<>();
        }

        // Function to add a node to the tree
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

        // Function to remove a node with a given key
        private Node remove(Node curr, int key) {
            if (curr == null) return null;
            
            if (key == root.key) { return removeRoot(root); }

            if (key < curr.key) {
                curr.left = remove(curr.left, key);
            } else if (key > curr.key) {
                curr.right = remove(curr.right, key);
            } else {
                // Node found
                // If node only has one child:
                if (curr.left == null) return curr.right;
                if (curr.right == null) return curr.left;
            
                // Replace with successor if node has two children
                Node successor = findMin(curr.right);
                curr.key = successor.key;
                curr.right = remove(curr.right, successor.key);
            }
        
            return curr;
        }

        // Function to handle removing a node when it's the root of the tree
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
            curr.right = remove(root.right, successor.key); // remove successor
        
            return root;
        }

        // Prints tree contents in order
        public void printInOrder() {
            // Update preOrderedList to correctly sort
            order.clear();
            updateOrder(root, 1);
            int[] sorted = new int[order.size()];

            // Copy array list into array to sort within
            for (int i = 0; i < order.size(); i++) {
                sorted[i] = order.get(i);
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

        // Prints tree contents in pre-order
        public void printPreOrder() {
            order.clear();  // Clear before updating
            updateOrder(root, 1);  // Update order

            System.out.println("\nPre-order Traversal: ");
            // Print each element in pre-ordered list
            for (int num : order) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Prints tree contents in post-order
        public void printPostOrder() {
            order.clear();  // Clear before updating
            updateOrder(root, 2);  // Update

            System.out.println("\nPost-order Traversal: ");
            // Print each element in post-ordered list
            for (int num : order) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Helper function for ordering
        private void updateOrder(Node curr, int code) {
            if (curr == null) return;  // Base case for recursion

            if (code == 1) { // Code 1 means pre-order
                order.add(curr.key);  // Add current node (parent)
                updateOrder(curr.left, 1);  // Visit left child
                updateOrder(curr.right, 1); // Visit right child
            }

            if (code == 2) { // Code 2 means post-order
                updateOrder(curr.left, 2);  // Visit left child
                updateOrder(curr.right, 2); // Visit right child
                order.add(curr.key);  // Add parent after visiting children
            }
        }

        // Helper function to find the smallest node in a subtree
        private Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    // Menu Display
    public static void displayMenu() {
        try {
            Thread.sleep(2500); // Used to create a delay for the menu to print
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n1. Create a binary search tree\n");
        System.out.println("2. Add a node\n");
        System.out.println("3. Remove a node\n");
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

                switch (input) { // Allows users to...
                    case 1: // "create" a binary search tree
                    if (created) { System.out.println("\nTree already created."); break; }
                        created = true;
                        System.out.println("\nTree successfully created.");
                        displayMenu();
                        break;
                    case 2: // add nodes to the tree
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        Integer numToAdd;

                        while (true) {
                            try {
                                System.out.print("\nType number to enter into tree: ");
                                numToAdd = scnr.nextInt();
                                break;
                            } catch (Exception InputMismatchException) {
                                System.out.println("\nNot a valid number.");
                            }
                        }

                        tree.root = tree.add(tree.root, numToAdd);
                        System.out.printf("\n%d has successfully been added to the tree.\n", numToAdd);
                        displayMenu();
                        break;
                    case 3: // remove nodes from the tree
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        Integer numToRemove;

                        while (true) {
                            try {
                                System.out.print("\nType number to delete from the tree: ");
                                numToRemove = scnr.nextInt();
                                break;
                            } catch (Exception InputMismatchException) {
                                System.out.println("\nNot a valid number.");
                            }
                        }

                        tree.root = tree.remove(tree.root, numToRemove);
                        System.out.printf("\n%d has successfully been removed from the tree.\n", numToRemove);
                        displayMenu();
                        break;
                    case 4: // print tree contents in-order
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printInOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 5: // print tree contents in pre-order
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printPreOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 6: // print tree contents in post-order
                        if (!created) { System.out.println("\nTree not created yet. Enter '1'."); break; }
                        tree.printPostOrder();
                        displayMenu(); // Display Menu
                        break;
                    case 7: // exit the program
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