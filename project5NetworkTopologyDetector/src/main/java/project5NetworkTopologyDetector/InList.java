package project5NetworkTopologyDetector;

import java.io.Serializable;
import java.util.List;


public class InList implements Serializable {

    private List<Job> inList;

    public InList() {
    }

    public List<Job> getInList() {
        return inList;
    }

    public void setInList(List<Job> inList) {
        this.inList = inList;
    }
}
