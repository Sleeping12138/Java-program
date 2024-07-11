package Demo2;

public class Test {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

        stack.printStack();
        System.out.println(stack.size());
    }
}
