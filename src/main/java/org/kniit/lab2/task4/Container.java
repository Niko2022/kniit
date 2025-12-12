package org.kniit.lab2.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Container {
    private double freeVolume;
    private final List<Shape> shapes = new ArrayList<>(); // список объектов класса Shape

    public Container(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Container volume must be >= 0");
        this.freeVolume = volume;
    }

    public double getFreeVolume() {
        return freeVolume;
    }

    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes); //возвращает неизменяемую копию внутреннего списка фигур для безопасного чтения извне
    }

    public boolean add(Shape shape) {
        if (shape == null) throw new IllegalArgumentException("shape must not be null");

        double v = shape.getVolume();
        if (v <= freeVolume) {
            shapes.add(shape);
            freeVolume -= v;
            return true;
        }
        return false; // фигуру добавить нельзя: не хватает объёма
    }
}
