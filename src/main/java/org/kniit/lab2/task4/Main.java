package org.kniit.lab2.task4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Container container = new Container(1000);

        Shape sphere = new Sphere(5);
        Shape cube = new Cube(3);

        System.out.println("Add sphere: " + container.add(sphere));
        System.out.println("Add cube: " + container.add(cube));
        System.out.println("Free volume: " + container.getFreeVolume());
    }
}
