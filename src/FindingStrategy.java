import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FindingStrategy {
    void find(List<String> list, Map<String, Set<Integer>> map);
}
