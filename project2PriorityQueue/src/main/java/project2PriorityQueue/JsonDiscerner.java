package project2PriorityQueue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(new JobComparator());
        ArrayList tempList = new ArrayList();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        /**
         * This part is to de serialize the JSON, and store the job object into the queue
         */
        try {
            Job jobList = mapper.readValue(jsonStr, Job.class);
            for(int i = 0; i < jobList.getInList().size(); i++) {
                if(jobList.getInList().get(i).getCmd().equals("enqueue")) {
                    jobQueue.add(new Job(jobList.getInList().get(i).getName(), jobList.getInList().get(i).getPri()));
//                    System.out.println("Enqueue hit!");
                } else if (jobList.getInList().get(i).getCmd().equals("dequeue")) {
                    jobQueue.remove();
//                    System.out.println("Dequeue hit!");
                } else {
                    return "List has bad cmd";
                }
            }
            /**
             * This part is to reach the queue
             */
            while(!jobQueue.isEmpty()){
                tempList.add(jobQueue.peek().getName());
                System.out.println(jobQueue.peek().getName() + " =->" + jobQueue.peek().getPri());
                jobQueue.remove();
            }

            OutList outList = new OutList();
            outList.setOutList(tempList);
            return serialize(outList);
        }

        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }

    }

    private String serialize(Object obj) {
        String str = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            str = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            str = "<error>";
        }
        return str;
    }

    // test case
    public static void main(String[] args) {
        String msg;
        JsonDiscerner discerner = new JsonDiscerner();

        System.out.println("************************************");
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";

//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}]}";
        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4},{\"cmd\":\"enqueue\", \"name\":\"job2\", \"pri\":3},{\"cmd\":\"dequeue\"},{\"cmd\":\"enqueue\", \"name\":\"job3\", \"pri\":0},{\"cmd\":\"enqueue\", \"name\":\"job4\", \"pri\":1},{\"cmd\":\"dequeue\"}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}