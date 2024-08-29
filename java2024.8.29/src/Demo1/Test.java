package Demo1;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.size()

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.isEmpty();
    }
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String str : operations){
            char ch = str.charAt(0);
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }else if(ch=='C'){
                stack.pop();
            }else if(ch=='D'){
                stack.push(stack.peek()*2);
            }else{
                int top = stack.pop();
                int peek= stack.peek();
                stack.push(top);
                stack.push(top+peek);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
