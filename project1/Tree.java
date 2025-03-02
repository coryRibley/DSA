package project1;

public interface Tree {
    // Add a node to the tree given input data
    void add(int data);

    // Remove a node from the tree given data to remove
    int delete(int data);

    // Print tree contents in order
    void printInOrder();

    // Print tree contents following pre order
    void printPreOrder();

    // Print tree contents following post order
    void printPostOrder();
}