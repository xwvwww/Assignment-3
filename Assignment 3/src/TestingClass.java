import java.util.Random;

public class TestingClass {

    public static void main(String[] args) {
        // Testing MyHashTable
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        // Adding random elements to MyHashTable
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000));
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        // Printing number of elements in each bucket
        MyHashTable.HashNode<MyTestingClass, Student>[] chainArray = table.getChainArray();
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, Student> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }

        // Testing BST
        BST<Integer, String> bst = new BST<>();

        // Adding random elements to BST
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000);
            String value = "Value " + i;
            bst.put(key, value);
        }

        // Printing the size of BST
        System.out.println("Size of BST: " + bst.size());

        // Iterating through BST and printing key-value pairs
        for (Integer key : bst.iterator()) {
            System.out.println("Key is " + key + " and value is " + bst.get(key));
        }
    }

    // Define MyTestingClass here with its own hashCode() method
    static class MyTestingClass {
        int value;

        public MyTestingClass(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            // Your custom hash code implementation
            return value;
        }
    }

    // Define Student class here (assuming it's a simple class with a name field)
    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
}
