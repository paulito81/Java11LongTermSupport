
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main  {
    private static String userInput;
    private final static String PATH = "src/main/java/file";
    public static void main(String[] args) {
        menuSelection();
        menu(userInput);
    }

    private static void menuSelection(){
        // \s = single whitespace character
        System.out.print("""
                -----------------------------
                Welcome to this Java 11 Long Term Support Demo.
                -----------------------------
                Please select from the menu:\s
                
                1: Single-file source code
                2: HttpClient
                3: Async HttpClient
                4: String Concat, var & trim
                5: String new file path
                
                Select: """);
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
    }

    private static void menu(String choice) {
            switch (choice) {
                case "1" -> listFilesDemo();
                case "2" -> httpClient();
                case "3" -> httpClientAsync();
                case "4" -> newStringConcat();
                case "5" -> newStringFilePath();
                default -> System.err.println("You selected a unknown choice: ");
            }
    }

    private static void listFilesDemo(){
        System.out.println("""
        ------------------------
        1.Single-file source code:
        ------------------------""");
        try {
            new ListFiles(new String[]{PATH});
        } catch (Exception e) {
            System.err.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static void httpClient(){
        System.out.println("""
        ------------------------
        2.HttpClient:
        ------------------------""");
        try {
            new HttpClientDemo();
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred");
            e.printStackTrace();
        }
    }
    private static void httpClientAsync(){
        System.out.println("""
        ------------------------
        3. Async HttpClient:
        ------------------------""");
        new HttpClientDemo("https://google.com");
    }

    private static void newStringConcat(){
        var notext = "    ";
        var notext2 = "\n\t     text    \u2005";

        System.out.println("""
        ------------------------
        4. String Java 11:
        ------------------------""");

        System.out.println("4.a\tTesting notext empty string:");
        System.out.println("".equals(notext.trim()));
        System.out.println(notext.isBlank());
        System.out.println("\n4.b\tTesting notext2 concat using strip with string:");
        System.out.println(notext2.strip());
        System.out.println(Character.isWhitespace('\u2005'));
        var multiline = "1\n2\n3\n4";
        System.out.println("\n4.c\tTesting multiline of numbers in string:");
        multiline.lines().forEach(System.out::println);
    }
    private static void newStringFilePath(){
        System.out.println("""
        ------------------------
        5. String Java 11 File Path:
        ------------------------""");
        try {
            System.out.println(Files.readString(Path.of(PATH)));
        } catch (IOException e) {
            System.err.println("No file-path found");
            e.printStackTrace();
        }
    }
}
