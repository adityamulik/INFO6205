package edu.neu.coe.info6205.union_find;

import java.util.*;

public class UFClient {

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random random = new Random();
        int count = 0;
        while (uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            // make sure that if p and q is connected, if is not connected then union p and q
            uf.connect(p, q);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println("Please enter a number from the command line: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("The number of objects is " + n + ", and the number of connections is " + count(n));

        System.out.println("Part 3: Test the relationship between m and n");
        for (int i = 1000; i < 160000; i *= 2) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += count(i);
            }
            int meanNumber = sum / 10;
            System.out.println("The number of objects is " + i + ", and the number of pairs is " + meanNumber);
        }
    }
}
