
public interface Stack {
 
    //add to the top
    void push(int plate);
    
    //remove from the top
    int pop();
    
    //look at first item
    int peek();
    
    //how many elements?
    int size();
    
    //is the stack empty?
    boolean isEmpty();
}