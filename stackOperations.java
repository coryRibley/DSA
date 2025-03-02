
public class stackOperations {
    @SuppressWarnings("unused")

    public static void main(String[] args) {
        int plate;
        LinkedStack stack = new LinkedStack();

        for (int i = 0; i < 25; i++) {
            stack.push(i + 1);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        } 

        System.out.println(stack.isEmpty());
        
    }
}