public class FileItem extends FileSystemItem {
    private int sizeKB;

    public FileItem(String name, int sizeKB) {
        super(name);
        this.sizeKB = sizeKB;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + sizeKB + "KB)");
    }
}
