package project2PriorityQueue;

import java.io.Serializable;
import java.util.ArrayList;

public class InQueue implements Serializable {

    private ArrayList inList;

    public InQueue() {}

    public ArrayList getInList() {
        return inList;
    }

    public void setInList(ArrayList inList) {
        this.inList = inList;
    }
}
