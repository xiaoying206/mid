public abstract class MyAbstractList implements MyList {
    @Override
    public boolean checkBoundaries(int index, int size) {
        return index >= 0 && index < size;
    }
    public MyAbstractList() {}
    @Override
    public String toString() {
        int[] arr = toArray();
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}