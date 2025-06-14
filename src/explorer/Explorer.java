package explorer;

import java.util.*;

public class Explorer {

    private Directory root;
    private Directory currentDirectory;
    private Map<String, Directory> directoryRefs;
    private Map<String, File> fileRefs;

    public Explorer() {
        this.directoryRefs = new HashMap<>();
        this.fileRefs = new HashMap<>();
        this.root = new Directory("c:", null);
        this.currentDirectory = root;
        directoryRefs.put(root.getName(), root);
    }

    public String makeDirectory(String name) {
        Directory dir = currentDirectory.makeDirectory(name);
        if (dir == currentDirectory) {
            return "Directory with this name already exists";
        }
        directoryRefs.put(name, dir);
        currentDirectory = currentDirectory.changeDirectory(name, root);
        return "Directory is created in " + currentDirectory.getParent().buildPath(root.getName());
    }

    public String changeDirectory (String name) {
        Directory dir = currentDirectory.changeDirectory(name, root);
        if (dir == null) {
            return "No such directory found";
        }
        currentDirectory = dir;
        return "Directory changed to: " + currentDirectory.buildPath(root.getName());
    }

    public String createFile(String name, String content) {
        if (currentDirectory.checkFileExists(name) != null) {
            return "File with these name can't be created";
        }
        File file = new File(name, currentDirectory, content);
        currentDirectory.addFile(file);
        fileRefs.put(name, file);
        return file.getContent();
    }

    public String pwd() {
        return currentDirectory.buildPath(root.getName());
    }

    public void list() {
        Directory directory = currentDirectory;
        String path = directory.buildPath(root.getName());
        System.out.println("Directories in " + path + "...");
        for (Directory d : directory.getDirectories()) {
            System.out.println(d.getName());
        }
        System.out.println("...");
        System.out.println("Files in " + path + "...");
        for (File f : directory.getFiles()) {
            System.out.println(f.getName());
        }
        System.out.println("...");
    }

    public void tree (Directory root, int dSpace, int dfSpace) {
        for (Directory d : root.getDirectories()) {
            for (int space = 0; space < dSpace; space++) {
                System.out.print(" ");
            }
            System.out.println(d.getName());
            tree(d, dSpace + 4, dfSpace + 4);
            for (File f : d.getFiles()) {
                for (int space = 0; space < dfSpace; space++) {
                    System.out.print(" ");
                }
                System.out.println(f.getName());
            }
        }
    }

    public String move (String directoryName, String parentName) {
        if (!directoryRefs.containsKey(directoryName)) {
            return "No source directory found";
        }
        if (!directoryRefs.containsKey(parentName)) {
            return "No parent directory found";
        }
        Directory parent = directoryRefs.get(parentName);

        return "Directory " + directoryName + " is changed to " + parentName;
    }
}
