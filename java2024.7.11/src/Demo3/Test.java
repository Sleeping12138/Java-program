package Demo3;

public class Test {
    public static void main(String[] args) {
        MyListStack stack = new MyListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

//        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

        stack.printStack();
        System.out.println(stack.size());
    }
}
