public abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void erase();
    public abstract void draw();

    public void moveTo(int newX, int newY) { //Này người ta gọi là Template Method.
        erase();
        x = newX;
        y = newY;
        draw();
    }
}

class Circle extends Shape {
    @Override
    public void erase() {
        System.out.println("Xóa hình tròn tại ("+x+","+y+")");
    }
    @Override
    public void draw() {
        System.out.println("Vẽ hình tròn tại ("+x+","+y+")");
    }

    public Circle(int x, int y) {
        super(x, y);
    }
}

class Square extends Shape {
    @Override
    public void erase() {
        System.out.println("Xóa hình vuông tại ("+x+","+y+")");
    }
    @Override
    public void draw() {
        System.out.println("Vẽ hình vuông tại ("+x+","+y+")");
    }

    public Square(int x, int y) {
        super(x, y);
    }
}