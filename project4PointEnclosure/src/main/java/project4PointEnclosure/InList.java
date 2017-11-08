package project4PointEnclosure;

import java.io.Serializable;
import java.util.List;


public class InList implements Serializable {

    private List<Coordinate> inList;

    public InList() {
    }

    public List<Coordinate> getInList() {
        return inList;
    }

    public void setInList(List<Coordinate> inList) {
        this.inList = inList;
    }
}
