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
        if (checkDirectoryExists(name) != null) {
            return this;
        }
        Directory directory = new Directory(name, this);
        addSubDirectories(directory);
        return directory;
    }

    public Directory changeDirectory (String command, Directory root) {
        Directory directory = switch (command) {
            case "." -> this;
            case ".." -> this.parent;
            case "/" -> root;
            default -> this.checkDirectoryExists(command);
        };
        return directory;
    }

    private Directory findRoot () {
        Directory dir = this;
        return dir.parent == null ? dir : dir.findRoot();
    }

    public Directory moveDirectory (Directory srcDirectory) {
        this.addSubDirectories(srcDirectory);
        srcDirectory.setParent(this);
        Directory parent = srcDirectory.getParent();
        parent.removeSubDirectories(srcDirectory);
        return this.changeDirectory(srcDirectory.name, this.findRoot());
    }

    public Directory moveFile (File srcFile) {
        this.addFile(srcFile);
        srcFile.setParent(this);
        srcFile.getParent().removeFile(srcFile);
        return this;
    }

    private Directory checkDirectoryExists (String name) {
        for (Directory d : this.directories) {
            if (d.name.equals(name)) {
                return d;
            }
        }
        return null;
    }

    private void addSubDirectories(Directory dir) {
        this.directories.add(dir);
    }

    private void removeSubDirectories (Directory dir) {
        this.directories.remove(dir);
    }

    public void addFile (File file) {
        this.files.add(file);
    }

    private void removeFile (File file) {
        this.files.remove(file);
    }

    private void setParent(Directory parent) {
        this.parent = parent;
    }

    public File checkFileExists (String name) {
        for (File f : this.files) {
            if (f.getName().equals(name)) {
                return f;
            }
        }
        return null;
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
