import java.util.*;
public class Hashmap_Demo<k,v> {
    int element = 0;      //No. of elements(K-V pairs) to be added in array list.

    class Node {
        k key;
        v value;
        Node next;

        public Node(k key, v value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Node> map = new ArrayList<>();

    public Hashmap_Demo(int size) {
        for (int i = 0; i < size; i++) {        //size of array list
            map.add(null);
        }
    }

    public Hashmap_Demo() {
//        for (int i = 0; i < 4; i++) {
//            map.add(null);
//        }
        this(4);
    }

    private int findIndex(k key) {
        int idx = key.hashCode();
        idx = idx % map.size();
        return idx;
    }

    public void put(k key, v value) {
        int idx = findIndex(key);
        Node head = map.get(idx);
        Node temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        Node nn = new Node(key, value);
        map.set(idx, nn);
        nn.next = head;
        element++;

        int thf = 2;        //threshold frequency
        int lf = element / map.size();
        if (lf > thf) {
            rehashing();
        }
    }

    public void rehashing() {
        ArrayList<Node> newmap = new ArrayList<>();
        for (int i = 0; i < 2 * map.size(); i++) {
            newmap.add(null);
        }
        ArrayList<Node> oldmap = map;
        map = oldmap;
        for (Node nn : oldmap) {
            while (nn != null) {
                int idx = findIndex(nn.key);
                put(nn.key, nn.value);
                nn = nn.next;
            }
        }
    }

    public boolean containsKey(k key) {
        int idx = findIndex(key);
        Node temp = map.get(idx);
        while (temp != null) {                //  !(temp == null)
            if (temp.key.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void remove(k key) {
        int idx = findIndex(key);
        Node head = map.get(idx);
        Node prev = null;
        prev.next = head;
        // make if else condition for a map which contains only 1 element, and we have to remove it .
        // make if condition for above and put the below while loop in the else condition.
        while (head != null) {                //  !(temp == null)
            if (head.key.equals(key)) {
                prev.next = head.next;
                head.next = null;
            }
            prev = head;
            head = head.next;
        }
    }

    public void get(k key) {
        // Try Yourself
        return;
    }
}