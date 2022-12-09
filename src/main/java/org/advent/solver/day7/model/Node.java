package org.advent.solver.day7.model;

import java.util.Objects;

public abstract class Node implements Comparable<Node> {

    private Directory parent;
    protected String label;
    protected int size;

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.size, other.size);
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Directory getParent() {
        return parent;
    }

    public String getLabel() {
        return label;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;

        return Objects.equals(label, node.label);
    }
}
