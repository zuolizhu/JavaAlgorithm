package project5NetworkTopologyDetector;

import java.io.Serializable;
import java.util.ArrayList;


public class InList implements Serializable {

    private ArrayList<Connected> inList;

    public InList() {
    }

    public ArrayList<Connected> getInList() {
        return inList;
    }

    public void setInList(ArrayList<Connected> inList) {
        this.inList = inList;
    }
}
