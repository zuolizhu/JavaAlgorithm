package project4PointEnclosure;

import java.io.Serializable;
import java.util.List;


public class InList implements Serializable {

    private List inList;

    public InList() {
    }

    public List getInList() {
        return inList;
    }

    public void setInList(List inList) {
        this.inList = inList;
    }
}
