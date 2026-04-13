public interface UIFactory {
    void createButton();
    void createCheckbox();
}

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowFactory implements UIFactory {
    class WindowButton implements Button {
        @Override
        public void render() {
            System.out.println("Đã render WindowButton");
        }
    }
    class WindowCheckbox implements Checkbox {
        @Override
        public void render() {
            System.out.println("Đã render WindowCheckbox");
        }
    }

    private WindowButton windowButton;
    private WindowCheckbox windowCheckbox;

    @Override
    public void createButton() {
        windowButton = new WindowButton();
    }

    @Override
    public void createCheckbox() {
        windowCheckbox = new WindowCheckbox();
    }

    public void renderAll() {
        windowButton.render();
        windowCheckbox.render();
    }
    //Side note: nếu chưa tạo button và checkbox có thể bị dính lỗi null pointer exception.
}

class MacFactory implements UIFactory {
    class MacButton implements Button {
        @Override
        public void render() {
            System.out.println("Đã render MacButton");
        }
    }
    class MacCheckbox implements Checkbox {
        @Override
        public void render() {
            System.out.println("Đã render MacCheckbox");
        }
    }

    private MacButton macButton;
    private MacCheckbox macCheckbox;

    @Override
    public void createButton() {
        macButton = new MacButton();
    }

    @Override
    public void createCheckbox() {
        macCheckbox = new MacCheckbox();
    }

    public void renderAll() {
        macButton.render();
        macCheckbox.render();
    }
}

