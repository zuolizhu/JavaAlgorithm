package project5NetworkTopologyDetector;

public class Job extends InList {
    private String cmd;
    private String name;
    private int pri;

    public Job() {
    }

    public Job(String name, int pri) {
        this.name = name;
        this.pri = pri;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }

}
