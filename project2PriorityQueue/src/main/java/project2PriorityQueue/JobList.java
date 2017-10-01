package project2PriorityQueue;

import java.io.Serializable;
import java.util.List;

public class JobList implements Serializable {
    private String inList;
    private List<JobList> jobs;

    public JobList() { }

    public String getInList() {
        return inList;
    }

    public void setInList(String inList) {
        this.inList = inList;
    }

    public List<JobList> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobList> jobs) {
        this.jobs = jobs;
    }
}
