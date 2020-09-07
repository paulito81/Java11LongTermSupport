
import java.io.IOException;
import java.util.Scanner;

public class Main  {
    private static Scanner scanner;
    private static String userInput;
    public static void main(String[] args) {

        menu(menuSelection());
    }
    private static String menuSelection(){
        // \s = single whitespace character
        System.out.print("""
                -----------------------------
                Welcome to this Java 11 Long Term Support Demo.
                -----------------------------
                Please select from the menu:\s
                
                1: Single-file source code
                2: HttpClient
                3: Async HttpClient
                
                Select: """);
        scanner = new Scanner(System.in);
        return userInput = scanner.nextLine();
    }

    private static void menu(String choice) {
        switch (choice) {
            case "1" -> listFilesDemo(new String[]{"src/main/java/file"});
            case "2" -> httpClient();
            case "3" -> httpClientAsync();
            default -> System.err.println("You selected a unknown choice: ");
        }
    }

    private static void listFilesDemo(String[] args){
        System.out.println("""
        ------------------------
        1.Single-file source code:
        ------------------------""");
        try {
            new ListFiles(args);
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
}
