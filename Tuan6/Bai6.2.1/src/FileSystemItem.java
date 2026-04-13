public abstract class FileSystemItem {
    protected String name;
    protected Folder parent;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public String getPath() {
        if (parent == null) {
            return "/" + name;
        } else {
            return parent.getPath() + "/" + name;
        }
    }
    // Tinh hoa đệ quy ngược lên trên để lấy path.

    public abstract void print(String indent);
}
