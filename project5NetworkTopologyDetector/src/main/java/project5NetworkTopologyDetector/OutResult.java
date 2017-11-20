package project5NetworkTopologyDetector;

import java.io.Serializable;

public class OutResult implements Serializable {
    private String type;

    public OutResult() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
