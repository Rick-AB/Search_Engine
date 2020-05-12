import java.util.*;

public class ANY implements FindingStrategy {
    Scanner in = new Scanner(System.in);
    Set<Integer> totalPeople = new HashSet<>();

    @Override
    public void find(List<String> list, Map<String, Set<Integer>> map) {
        System.out.println("Enter a name or email to search all suitable people.");
        String person = in.nextLine().toLowerCase().trim();
        String[] arr = person.split("\\s+");
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                totalPeople.addAll(map.get(arr[i]));
                found = true;
            }
        }
        for (int k: totalPeople){
            System.out.println(list.get(k));
        }
        if (!found) {
            System.out.println("No matching people found.");
        }
        System.out.println("\n");
    }
}
