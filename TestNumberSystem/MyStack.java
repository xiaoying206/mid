public class MyStack {
    private MyList stack;

    public MyStack() {
        stack = new MyLinkedList();
    }

    public void push(int value) {
        stack.insertAtEnd(value);
    }

    public int pop() {
        int val = peek();
        stack.remove(stack.size() - 1);
        return val;
    }

    public int peek() {
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}