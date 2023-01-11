package gradle.cliapp.with.lib.template.data.structures;

/**
 * List class
 * @param <T> The type of the list
 */
public class List<T extends Comparable<T>> {
    /**
     * The head of the list
     */
    Node<T> first;

    /**
     * Add a new node to the list
     * @param data data of the node
     */
    public List<T> insert(T data) {
        if (first == null) {
            first = new Node<T>(data);
        } else {
            Node<T> last = first;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(new Node<T>(data));
        }
        return this;
    }

    /**
     * Remove a node from the list
     * @param data data of the node
     * @return the list
     */
    public List<T> remove(T data) {
        Node<T> current = first;
        while (current.getData().compareTo(data) != 0) {
            current = current.getNext();
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        if (current == first && current.getNext() == null) {
            first = null;
        } else if (current == first) {
            first = current.getNext();
        } else {
            Node<T> previous = first;
            while (previous.getNext() != current) {
                previous = previous.getNext();
            }
            previous.setNext(current.getNext());
        }

        return this;
    }

    /**
     * Get the size of the list
     * @return size of the list
     */
    public int size() {
        if (first != null) {
            return first.count();
        } else {
            return 0;
        }
    }
    /**
     * Get the data of the list if exists
     * @return data of the list
     */
    public T get(T data) {
        Node<T> current = first;
        while (current != null) {
            if (current.getData().compareTo(data) == 0) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    /**
     * Get the array data of the list if exists
     * @return array data of the list
     */
    public Object[] listData() {
        Object[] array = new Object[size()];
        Node<T> node = first;
        for (int i = 0; i < array.length; ++i) {
            array[i] = node.getData();
            node = node.getNext();
        }
        return array;
    }
}

