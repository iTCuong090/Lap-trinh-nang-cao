public class Main {
    public static void main(String[] agrs) {
        String inputSetting1 = "win";
        String inputSetting2 = "mac";

        if (inputSetting1.equals("win")) {
            WindowFactory winUI = new WindowFactory();
            winUI.createButton();
            winUI.createCheckbox();
            winUI.renderAll();

        }

        if (inputSetting2.equals("mac")) {
            MacFactory macUI = new MacFactory();
            macUI.createButton();
            macUI.createCheckbox();
            macUI.renderAll();

        }


    }
}