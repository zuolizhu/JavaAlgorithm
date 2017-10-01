package project2PriorityQueue;

import java.io.Serializable;

public class OutJSONObject implements Serializable{
    private String[] outList;


    public OutJSONObject() {
    }

    public String[] getOutList() {
        return outList;
    }

    public void setOutList(String[] outList) {
        this.outList = outList;
    }
}
