public interface MyList {
    int get(int index);
    void insertAtEnd(int value);
    void insertAtPos(int index, int value);
    void insertAtStart(int value);
    void remove(int index);
    void set(int index, int value);
    int size();
    int[] toArray();

    boolean checkBoundaries(int index, int size);
}