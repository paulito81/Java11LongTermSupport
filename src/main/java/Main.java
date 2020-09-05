
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static String userInput;

    public static void main(String[] args) {
        menu(menuSelection());
    }
    private static String menuSelection(){
        System.out.print("""
                -----------------------------
                Welcome to this Java 11 Long Term Support Demo.
                -----------------------------
                Please select from the menu:\s
                
                1: ObjectNullPointer
                2: StringNullPointer
                3: Switch (old ver) expressions
                4: Switch (NEW ver) expressions
                5: Switch New Food switch
                6: Pattern matching v.1
                7: Text blocks    
                8: Records demo
                9: Records demo 'breaking'
                
                Select: """);
        scanner = new Scanner(System.in);
        return userInput = scanner.nextLine();
    }

    private static void menu(String choice) {
        switch (choice) {
            case "1" -> System.out.println("One selected");
            case "2" -> System.out.println("Two Selected");
            default -> System.err.println("You selected a unknown choice: ");
        }
    }
}
