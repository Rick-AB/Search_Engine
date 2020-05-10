import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to .txt file containing data of people");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        Searcher searcher = new Searcher(file);
        searcher.showMenu();

    }
}
