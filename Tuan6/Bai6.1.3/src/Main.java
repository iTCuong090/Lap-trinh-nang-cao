public class Main {
    public static void main(String[] agrs) {
        String inputSetting1 = "win";
        String inputSetting2 = "mac";

        if (inputSetting1.equals("win")) {
            UIFactory winFactory = new WindowFactory();
            winFactory.createButton().render();
            winFactory.createCheckbox().render();

        }

        if (inputSetting2.equals("mac")) {
            UIFactory macFactory = new MacFactory();
            macFactory.createButton().render();
            macFactory.createCheckbox().render();

        }

    }
}