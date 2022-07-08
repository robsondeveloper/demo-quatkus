package quarkus.recursion;

import java.util.List;

public class Node {

    private Long id;
    private String name;
    private List<Node> nodes;

    public Node() {
    }

    public Node(Long id, String name, List<Node> nodes) {
        this.id = id;
        this.name = name;
        this.nodes = nodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
