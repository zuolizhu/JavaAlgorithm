package project2PriorityQueue;

import java.io.Serializable;

public class OutJSONObject implements Serializable{
    private int[] outList;
    private String algorithm;
    private long timeMS;

    public long getTimeMS() {
        return timeMS;
    }

    public void setTimeMS(long timeMS) {
        this.timeMS = timeMS;
    }

    public OutJSONObject() {
    }

    public int[] getOutList() {
        return outList;
    }

    public void setOutList(int[] outList) {
        this.outList = outList;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

}
