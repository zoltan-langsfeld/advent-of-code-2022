package org.advent.solver.day7.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.nonNull;

public class FileSystem {
    private final Directory rootDirectory;
    private Directory currentDir;

    private final int availableSpace = 70000000;

    public FileSystem(final String[] rawData) {
        this.rootDirectory = new Directory("ROOT");
        this.currentDir = rootDirectory;
        buildFileSystem(rawData);
    }

    private void buildFileSystem(String[] rawData) {
        for (String currentLine : rawData) {
            if (currentLine.matches("\\$ cd.*")) {
                final var targetDir = new Directory(currentLine.split(" ")[2]);

                if (targetDir.getLabel().equals("/")) {
                    this.goToRoot();
                } else if (targetDir.getLabel().equals("..")) {
                    this.goToParent();
                } else {
                    this.goToSubDirectory(targetDir);
                }
            } else if (!currentLine.matches(".*\\$.*")) {
                final var child = NodeFactory.createNode(currentLine);
                this.addChildToCurrentDir(child);
            }
        }
        calculateDirSizes();
    }

    private void goToRoot() {
        this.currentDir = this.rootDirectory;
    }

    private void goToParent() {
        if (currentDir == rootDirectory) {
            System.err.println("Current dir is root, cannot go higher up.");
            return;
        }
        currentDir = currentDir.getParent();
    }

    private void goToSubDirectory(Node subDir) {
        final var realSubDir = currentDir.getChild(subDir);
        if (nonNull(realSubDir)) {
            this.currentDir = (Directory) realSubDir;
            return;
        }
        System.err.println("Cannot change to dir as it does not exist.");
    }

    private void addChildToCurrentDir(Node child) {
        currentDir.addChild(child);
    }

    private void calculateDirSizes() {
        this.calculateDirSizes(rootDirectory);
    }

    private void calculateDirSizes(Directory directory) {
        final int sizeOfFiles = directory.getAllFiles().stream().map(Node::getSize).reduce(Integer::sum).orElse(0);
        directory.setSize(sizeOfFiles);
        directory.addSizeToParents(sizeOfFiles);
        if (directory.hasNoChildren()) {
            return;
        }
        directory.getAllSubDirectories().forEach(this::calculateDirSizes);
    }

    public int getSumOfDirectories(int sizeLimit) {
        final var directories = new ArrayList<Directory>();
        this.getAllDirectories(rootDirectory, directories);

        return directories.stream().map(Directory::getSize).filter(size -> size < sizeLimit).reduce(Integer::sum).orElse(0);
    }

    private List<Directory> getAllDirectories() {
        final var directories = new ArrayList<Directory>();
        this.getAllDirectories(rootDirectory, directories);

        return directories;
    }

    private void getAllDirectories(Directory dir, List<Directory> directories) {
        directories.add(dir);
        if (dir.hasNoChildren()) {
            return;
        }

        dir.getAllSubDirectories().forEach(subDir -> this.getAllDirectories(subDir, directories));
    }

    public int getSizeOfDirectoryToBeDeleted(int neededSpace) {
        final var allDirectories = this.getAllDirectories();
        final int currentlyUsedSpace = this.rootDirectory.size;
        if (availableSpace - currentlyUsedSpace > neededSpace) {
            return 0;
        }

        Collections.sort(allDirectories);

        for (final var directory : allDirectories) {
            if (availableSpace - currentlyUsedSpace + directory.getSize() > neededSpace) {
                return directory.getSize();
            }
        }

        return -1;
    }
}
