public class MyLinkedList extends MyAbstractList {
    private Node start;
    private Node end;
    private int size;

    public MyLinkedList() {
        start = end = null;
        size = 0;
    }

    @Override
    public int get(int index) {
        return getNodeByIndex(index).data;
    }

    public Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        Node current = start;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    @Override
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (start == null) {
            start = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    @Override
    public void insertAtStart(int value) {
        Node newNode = new Node(value);
        newNode.next = start;
        start = newNode;
        if (end == null) end = newNode;
        size++;
    }

    @Override
    public void insertAtPos(int index, int value) {
        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node newNode = new Node(value);
            Node prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        if (index == 0) {
            start = start.next;
            if (start == null) end = null;
        } else {
            Node prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) end = prev;
        }
        size--;
    }

    @Override
    public void set(int index, int value) {
        getNodeByIndex(index).data = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        Node current = start;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }
}