package project2PriorityQueue;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job job1, Job job2) {
        return job1.getPri() - job2.getPri();
    }
}
