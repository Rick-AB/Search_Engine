import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Searcher {
    List<String> info;
    Map<String, Set<Integer>> map;
    Set<Integer> set;
    Scanner in = new Scanner(System.in);

    Searcher(File file){
        info = new ArrayList<>();
        map = new HashMap<>();
        set = new HashSet<>();
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                info.add(scanner.nextLine());
            }

            for(int i = 0; i< info.size(); i++){
                String[] words = info.get(i).toLowerCase().split("\\s+");
                for (int j = 0; j<words.length; j++){
                    set.clear();
                    if (!map.containsKey(words[j])){
                        set.add(i);
                        map.put(words[j],new HashSet<>(set));
                    }else {
                        map.get(words[j]).add(i);
                    }
                }
            }

        }catch (FileNotFoundException e ){
            System.out.println("No file found: " + file);
        }
    }

    void findPerson(){
        System.out.println("Enter a name or email to search all suitable people.");
        String person = in.next().toLowerCase().trim();
        if (map.containsKey(person)){
            Set<Integer> result = map.get(person);
            System.out.println(result.size() + " person(s) found.");
            for(int i : result){
                System.out.println(info.get(i));
            }
        }else {
            System.out.println("No matching people found.");
        }
        System.out.println("\n");
    }

    public void showMenu() {
        char op;
        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person\n" + "2. Print all people\n" + "0. Exit");

            op = in.next().charAt(0);
            switch (op){
                case '1':
                    findPerson();
                    break;
                case '2':
                    printPeople();
                    break;
                case '0':
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }while (op != '0');

    }

    private void printPeople() {
        if (info.size() > 0) {
            System.out.println("=== List of people ===");
            for (int i = 0; i < info.size(); i++) {
                System.out.println(info.get(i));
            }
        }else {
            System.out.println("No data available.");
        }
    }
}

