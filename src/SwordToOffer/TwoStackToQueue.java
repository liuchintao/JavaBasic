package SwordToOffer;

import java.util.Stack;

public class TwoStackToQueue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	
	public TwoStackToQueue(Stack<T> stack1, Stack<T> stack2){
		this.stack1 = stack1;
		this.stack2 = stack2;
	}
	
	public T pop() {
		if(stack2.isEmpty())
			while(!stack1.isEmpty())
				stack2.add(stack1.pop());
		if(stack2.isEmpty())
			return null;
		return stack2.pop();
	}
	
	public void push(T e) {
		stack1.add(e);
	}
}
