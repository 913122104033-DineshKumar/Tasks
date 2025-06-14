package explorer;

class File {
    private String name;
    private Directory parent;
    private String content;

    public File(String name, Directory parent, String content) {
        this.name = name;
        this.parent = parent;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public Directory getParent() {
        return parent;
    }

    public String getContent() {
        return content;
    }

    public void setParent (Directory parent) {
        this.parent = parent;
    }

}
