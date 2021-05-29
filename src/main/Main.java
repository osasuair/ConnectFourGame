package main;

import graphics.BuildFrame;
import graphics.Counter;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        BuildFrame buildFrame = new BuildFrame("Connect Four", 700, 600, 6, 7);

        int[][] connectGrid = new int[6][7];

        connectGrid[5][6] = 1;

        for (int[] anInt : connectGrid) {
            System.out.println();
            for (int i : anInt) System.out.print(i + " ");
        }

    }
}
