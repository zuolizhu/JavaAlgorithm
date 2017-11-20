package project5NetworkTopologyDetector;

import java.io.Serializable;
import java.util.ArrayList;

public class OutList implements Serializable {

    private ArrayList outList;
    public OutList () {}

    public ArrayList getOutList() {
        return outList;
    }

    public void setOutList(ArrayList outList) {
        this.outList = outList;
    }
}
