import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemItem {
    private List<FileSystemItem> children;

    public Folder(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void addChild(FileSystemItem child) {
        children.add(child);
        child.setParent(this);
    }


    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem child : children) {
            child.print(indent + "  "); //Gọi các file con tự in ra, với lề thụt thêm 1 bậc so với thư mục cha.
        }
    }
}
