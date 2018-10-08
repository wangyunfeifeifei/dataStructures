package javaImp.SET;

import javaImp.Array.Array;
import javaImp.Util.FileOperation;

public class BSTSet_Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        Array<String> words1 = new Array<>();
        if(FileOperation.readFile("src/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words=:" + words1.getSize());
            BSTSet<String> set1 = new BSTSet<>();
            for(int i = 0; i < words1.getSize(); i++) {
                set1.add(words1.get(i));
            }
            System.out.println("Total different words=" + set1.getSize());
        }

        System.out.println("A Tale of Two Cities");

        Array<String> words2 = new Array<>();
        if(FileOperation.readFile("src/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words=:" + words2.getSize());
            BSTSet<String> set2 = new BSTSet<>();
            for(int i = 0; i < words2.getSize(); i++) {
                set2.add(words2.get(i));
            }
            System.out.println("Total different words=" + set2.getSize());
        }
    }
}
