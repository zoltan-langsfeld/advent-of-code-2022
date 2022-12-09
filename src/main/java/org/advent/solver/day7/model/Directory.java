package org.advent.solver.day7.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class Directory extends Node {
    private final List<Node> children = new ArrayList<>();

    public Directory(String label) {
        this.label = label;
    }

    Node getChild(Node child) {
        final var indexOfChild = children.indexOf(child);
        if (indexOfChild == -1) {
            return null;
        }
        return children.get(indexOfChild);
    }

    List<File> getAllFiles() {
        return children.stream().filter(child -> child instanceof File).map(file -> (File) file).toList();
    }

    List<Directory> getAllSubDirectories() {
        return children.stream().filter(child -> child instanceof Directory).map(directory -> (Directory) directory).toList();
    }

    boolean hasNoChildren() {
        return children.isEmpty();
    }

    void addSizeToParents(int additionalSize) {
        if (this.isRoot()) {
            return;
        }
        this.getParent().size += additionalSize;
        this.getParent().addSizeToParents(additionalSize);
    }

    private boolean isRoot() {
        return isNull(this.getParent());
    }

    void addChild(Node child) {
        if (!children.contains(child)) {
            child.setParent(this);
            children.add(child);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Directory)) return false;

        return super.equals(o);
    }
}
