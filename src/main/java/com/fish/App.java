package com.fish;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5};
        int[] a1 = new int[3];
        System.arraycopy(a, 0, a1, 0, 3);
        System.err.println(Arrays.toString(a1));

        int[] a2 = new int[3];
        System.arraycopy(a, 3, a2, 0, 3);
        System.err.println(Arrays.toString(a2));


        System.err.println("------");
        System.err.println(1<<30);
        System.err.println(Integer.MAX_VALUE - 8);
    }

}
