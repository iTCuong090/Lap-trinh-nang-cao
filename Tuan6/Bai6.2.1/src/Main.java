public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");

        Folder docs = new Folder("docs");
        FileItem aTxt = new FileItem("a.txt", 12);

        docs.addChild(aTxt);
        docs.addChild(new FileItem("b.txt", 8));
        docs.addChild(new Shortcut("a-shortcut", aTxt));

        root.addChild(docs);
        root.addChild(new FileItem("readme.md", 4));

        //Print toàn bộ gia phả nhà cụ root.
        root.print("");
    }
}
