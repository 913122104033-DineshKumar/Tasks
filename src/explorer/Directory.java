package explorer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Directory {
    private String name;
    private Directory parent;
    private List<Directory> directories;
    private List<File> files;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.directories = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public List<File> getFiles() {
        return files;
    }

    public Directory makeDirectory(String name) {
        if (checkDirectoryExists(name)) {
            return this;
        }
        Directory directory = new Directory(name, this);
        addSubDirectories(directory);
        return directory;
    }

    public Directory changeDirectory (String command, Directory root) {
        if (command.equals(".")) {
            return this;
        } else if (command.equals("..")) {
            return this.parent;
        } else if (command.equals("/")) {
            return root;
        }
        if (this.checkFileExists(command)) {
            for (Directory dir : this.directories) {
                if (dir.name.equals(command)) {
                    return dir;
                }
            }
        }
        return null;
    }

//    public Directory moveDirectory (Directory srcDirectory) {
//
//    }

    private boolean checkDirectoryExists (String name) {
        for (Directory d : this.directories) {
            if (d.name.equals(name)) {
                return true;
            }
        }
        return false;
    }

    private void addSubDirectories(Directory dir) {
        this.directories.add(dir);
    }

    public boolean checkFileExists (String name) {
        for (File f : this.files) {
            if (f.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String buildPath(String parentName) {
        Stack<String> stack = new Stack<>();
        Directory currentDirectory = this;
        while (!currentDirectory.name.equals(parentName)) {
            stack.push(currentDirectory.name);
            stack.push("/");
            currentDirectory = currentDirectory.parent;
        }
        stack.push(currentDirectory.name + "/");
        return stack.toString();
    }
}
