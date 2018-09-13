package SwordToOffer;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;
    
    public void push(int node) {
        mainStack.push(node);
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }
    }
    
    public void pop() {
        if(mainStack.isEmpty())
            return;
        Integer top = mainStack.pop();
        if(top == null)
            return;
        if(top == minStack.peek()) {
        	minStack.pop();
        	min = minStack.peek();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int min() {
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack ms = new MinStack();
    	ms.push(3);
    	System.out.println(ms.min());
    	ms.push(4);
    	System.out.println(ms.min());
    	ms.push(2);
    	System.out.println(ms.min());
    	ms.push(3);
    	System.out.println(ms.min());
    	ms.pop();
    	System.out.println(ms.min());
    	ms.pop();
    	System.out.println(ms.min());
    	ms.pop();
    	System.out.println(ms.min());
    	ms.push(0);
    	System.out.println(ms.min());
    }
}