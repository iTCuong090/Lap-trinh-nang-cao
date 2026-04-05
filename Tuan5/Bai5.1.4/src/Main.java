public class Main {
    public static void main(String[] args) {
        String input = "Hello world. This is a java program. Hello java, hello world.";
    
        WordCounter counter = new WordCounter();
        counter.analyze(input);
        counter.displayResult();
        counter.findMostFrequentWord();
}
}