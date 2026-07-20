import java.util.*;

class ThroneInheritance {
    // Map to represent the family tree: Parent -> List of Children in birth order
    private final Map<String, List<String>> familyTree;
    // Set to keep track of dead family members
    private final Set<String> deadSet;
    // Name of the king
    private final String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadSet = new HashSet<>();
        // Register the king in our family tree map
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child under the parent's list
        this.familyTree.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.deadSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Perform pre-order DFS traversal starting from the king
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, add them to the inheritance order
        if (!deadSet.contains(current)) {
            order.add(current);
        }
        
        // Traverse all children of the current person in birth order
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
