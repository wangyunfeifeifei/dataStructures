package javaImp;

import javaImp.Array.Array;

public class Main_array {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();

        for (int i = 0; i < 10; i++){
            arr.append(i);
        }

        System.out.println(arr);

        arr.append(11);

        System.out.println(arr);
    }
}
