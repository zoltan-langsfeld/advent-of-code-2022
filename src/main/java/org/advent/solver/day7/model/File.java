package org.advent.solver.day7.model;

public class File extends Node {

    public File(int size, String label) {
        this.label = label;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;

        return super.equals(o);
    }
}
