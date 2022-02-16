/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        for (int i=0; i<m; i++) {
            randomMove();
        }
    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
//        System.out.println("NS " + ns);
        int step = random.nextBoolean() ? 1 : -1;
//        System.out.println("STEP " + step);
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // Euclidean distance calculated from the lamp post to the point of distance (d)
        double result = Math.sqrt(Math.pow((y-0), 2) + Math.pow((x-0), 2));
//        System.out.println("Distance " + result);
        return result;
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;

        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }

//        System.out.println("For m: " + m + " Square root of m(steps) " + Math.sqrt(m) + " steps & Distance " + totalDistance / n + " n " + n);

        return totalDistance / n;
    }

    public static void main(String[] args) {

        int[] steps = {5, 10, 15, 20, 25, 30}; // 6 values of no of steps

        for (int m: steps) {
            int n = 10;
            if (args.length > 1) n = Integer.parseInt(args[1]);
            double meanDistance = randomWalkMulti(m, n);
            System.out.println(m + " steps: " + meanDistance + " over " + n + " experiments");
        }
    }

}
