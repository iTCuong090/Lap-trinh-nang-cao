public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
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


    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowCheckbox();
    }
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

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

