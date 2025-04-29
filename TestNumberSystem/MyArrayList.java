public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] data;
    private int size;

    public MyArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public void insertAtEnd(int value) {
        if (size >= data.length) allocateMore();
        data[size++] = value;
    }

    @Override
    public void insertAtStart(int value) {
        insertAtPos(0, value);
    }

    @Override
    public void insertAtPos(int index, int value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size >= data.length) allocateMore();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public void set(int index, int value) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        System.arraycopy(data, 0, arr, 0, size);
        return arr;
    }
}