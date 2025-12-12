package org.kniit.lab2.task5;

// Абстрактный класс для общего элемента файловой системы
abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract long getSize();
    public abstract void add(FileSystemComponent component);
    public abstract void remove(FileSystemComponent component);
    public abstract void display(String indent);
}

// Класс для файла (листовой элемент)
class File extends FileSystemComponent {
    private long size;

    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Files cannot contain other components");
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Files cannot contain other components");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name + " (" + size + " bytes)");
    }
}

// Класс для папки (компоновщик)
class Folder extends FileSystemComponent {
    private java.util.List<FileSystemComponent> children;

    public Folder(String name) {
        super(name);
        this.children = new java.util.ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name);
        String childIndent = indent + "  ";
        for (FileSystemComponent child : children) {
            child.display(childIndent);
        }
    }
}

