import java.util.*;

public class NONE implements FindingStrategy{
    Scanner in = new Scanner(System.in);
    Set<Integer> totalPeople = new HashSet<>();

    @Override
    public void find(List<String> list, Map<String, Set<Integer>> map) {

        System.out.println("Enter a name or email to search all suitable people.");
        String person = in.nextLine().toLowerCase().trim();
        String[] arr = person.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                totalPeople.addAll(map.get(arr[i]));
            }
        }
        for (int k = 0 ; k<list.size(); k++){
            if (!totalPeople.contains(k)){
                System.out.println(list.get(k));
            }
        }
        System.out.println("\n");
    }
}
