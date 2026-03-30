import java.util.ArrayList;
import java.util.List;

public abstract class LibrarySection<T extends MediaItem> {
    protected ArrayList<T> storage;

    public LibrarySection() {
        storage = new ArrayList<T>();
    }

    public void add(T thing) {
        storage.add(thing);
    }

    public void remove(T thing) {
        storage.remove(thing);
    }

    public abstract void check();
}

abstract class MediaItem {
    protected String id, name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Book extends MediaItem {
    protected String author;
    protected int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }
}

class DVD extends MediaItem {
    protected String author;
    protected int duration;

    public DVD(String id, String name, String author, int duration) {
        super(id, name);
        this.author = author;
        this.duration = duration;
    }
}

class BookSection extends LibrarySection<Book> {

    @Override
    public void check() {
        for (Book x: storage) {
            System.out.println(x.name + " - " + x.author + " - " + x.pages + " trang");
        }
    }
}

class DVDSection extends LibrarySection<DVD> {

    @Override
    public void check() {
        for (DVD x: storage) {
            System.out.println(x.name + " - " + x.author + " - " + x.duration + " phút");
        }
    }
}