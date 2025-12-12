package org.kniit.lab2.task4;

abstract class Shape {
    public abstract double getVolume();
}

final class Sphere extends Shape {
    private final double r;

    public Sphere(double r) {
        if (r <= 0) throw new IllegalArgumentException("Radius must be > 0");
        this.r = r;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }
}

final class Cube extends Shape {
    private final double a;

    public Cube(double a) {
        if (a <= 0) throw new IllegalArgumentException("Side must be > 0");
        this.a = a;
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }
}

final class Cylinder extends Shape {
    private final double r;
    private final double h;

    public Cylinder(double r, double h) {
        if (r <= 0 || h <= 0) throw new IllegalArgumentException("r and h must be > 0");
        this.r = r;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return Math.PI * r * r * h;
    }
}

