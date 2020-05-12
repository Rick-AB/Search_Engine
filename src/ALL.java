import java.util.*;

public class ALL implements FindingStrategy {
    Scanner in = new Scanner(System.in);
    Set<Integer> totalPeople = new HashSet<>();

    @Override
    public void find(List<String> list, Map<String, Set<Integer>> map) {

        System.out.println("Enter a name or email to search all suitable people.");
        String person = in.nextLine().toLowerCase().trim();
        String[] arr = person.split("\\s+");
        if (map.containsKey(arr[0])){
            totalPeople.addAll(map.get(arr[0]));
        }

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                totalPeople.retainAll(map.get(arr[i]));
                found = true;
            }
        }
        if (totalPeople.size() == 0 || !found){
            System.out.println("No matching people.");
        }else {
            for (int onlyPerson:totalPeople){
                System.out.println(list.get(onlyPerson));
            }
        }
        System.out.println("\n");
    }
}
