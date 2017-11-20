package project5NetworkTopologyDetector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Detector extends ArrayList<Vertex> {

    public Vertex getVertex(String name) {
        Vertex vertex;
        for (int i = 0; i < size(); i++) {
            vertex = get(i);
            if (name.equals(vertex.getName())) {
                return vertex;
            }
        }
        vertex = new Vertex(name);
        add(vertex);
        return vertex;
    }

    public boolean isBus() {
        if (getEdges() != size() * 2 - 2) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            String start = get(i).getName();
            HashSet<String> closed = getNames();
            closed.remove(start);
            Vertex current = getVertex(start);
            while (!closed.isEmpty()) {
                boolean isBus = false;
                for (String s : closed) {
                    if (current.hasEdge(s)) {
                        current = getVertex(s);
                        closed.remove(s);
                        isBus = true;
                        break;
                    }
                }
                if (!isBus) {
                    break;
                }
            }
            if (closed.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isRing() {
        if (getEdges() != size() * 2) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            String start = get(i).getName();
            HashSet<String> closed = getNames();
            closed.remove(start);
            Vertex current = getVertex(start);
            while (!closed.isEmpty()) {
                boolean isRing = false;
                for (String s : closed) {
                    if (current.hasEdge(s)) {
                        current = getVertex(s);
                        closed.remove(s);
                        isRing = true;
                        break;
                    }
                }
                if (!isRing) {
                    break;
                }
            }
            if (closed.isEmpty() && current.hasEdge(start)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStar() {
        if (getEdges() != size() * 2 - 2) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            String start = get(i).getName();
            HashSet<String> closed = getNames();
            closed.remove(start);
            Vertex current = getVertex(start);
            Iterator<String> iterator = closed.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                if (current.hasEdge(next)) {
                    iterator.remove();
                }
            }
            if (closed.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private int getEdges() {
        int count = 0;
        for (int i = 0; i < size(); i++) {
            Vertex vertex = get(i);
            count += vertex.getEdgeCount();
        }
        return count;
    }

    private HashSet<String> getNames() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < size(); i++) {
            set.add(get(i).getName());
        }
        return set;
    }
}
