public class Main {

    public static void main(String[] args) {
        //AutomatizedReportGenerator reportGenerator = new AutomatizedReportGenerator();
        //reportGenerator.generate();
        String[] arg = new String[]{"astr", "manhlin", "pliki/3.txt", "pliki/3solution.txt", "pliki/3stats.txt"};
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.processArgs(arg);

    }
}
