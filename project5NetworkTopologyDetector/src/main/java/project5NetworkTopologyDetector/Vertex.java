package project5NetworkTopologyDetector;

import java.util.HashSet;

public class Vertex {
    private String name;
    private HashSet<String> edges;

    public Vertex(String name) {
        this.name = name;
        edges = new HashSet<String>();
    }

    public void addEdge(Vertex vertex) {
        edges.add(vertex.getName());
    }

    public boolean hasEdge(String name) {
        return edges.contains(name);
    }

    public String getName() {
        return name;
    }

    public int getEdgeCount() {
        return edges.size();
    }

}
