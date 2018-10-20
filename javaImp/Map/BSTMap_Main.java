package javaImp.Map;

import javaImp.Array.Array;
import javaImp.Util.FileOperation;

public class BSTMap_Main {
    public static void main(String[] args) {
        System.out.println("Pride and prejudice");

        Array<String> words = new Array<>();
        if (FileOperation.readFile("src/pride-and-prejudice.txt", words)) {
            System.out.println("Total words：" + words.getSize());

            Map<String, Integer> map = new BSTMap<>();
            for(int i =0; i< words.getSize(); i++) {
                if (map.contains(words.get(i))) {
                    map.set(words.get(i), map.get(words.get(i)) + 1);
                }
                else {
                    map.add(words.get(i), 1);
                }
            }

            System.out.println(" Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PRIEJUDICE:" + map.get("prejudice"));
        }
    }
}
