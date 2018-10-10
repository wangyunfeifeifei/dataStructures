package javaImp.SET;

import javaImp.Array.Array;
import javaImp.Util.FileOperation;

public class MAIN {
    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        Array<String> words = new Array<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.getSize());

            for (int i = 0; i < words.getSize(); i++) {
                set.add(words.get(i));
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) * 1.0 / 1e9;
    }

    public static void main(String[] args) {
        String filename = "src/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("Bst set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linkedlist set: " + time2 + " s");
    }
}
