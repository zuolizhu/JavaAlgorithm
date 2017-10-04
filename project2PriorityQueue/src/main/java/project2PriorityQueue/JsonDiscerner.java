package project2PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.Queue;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        Queue<Job> jobQueue = new LinkedList<Job>();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        /**
         * This part is to de serialize the JSON, and store the job object into the queue
         */
        try {
            Job jobList = mapper.readValue(jsonStr, Job.class);
            for(int i = 0; i < jobList.getInList().size(); i++) {
                if(jobList.getInList().get(i).getCmd().equals("enqueue")) {
                    jobQueue.add(jobList.getInList().get(i));
                    System.out.println("Enqueue hit!");
                } else if (jobList.getInList().get(i).getCmd().equals("dequeue")) {
                    jobQueue.remove();
                    System.out.println("Dequeue hit!");
                } else {
                    return "List has bad cmd";
                }
            }

            /**
             * This part is to reach the queue
             */
            while(!jobQueue.isEmpty()){
                System.out.println(jobQueue.peek().getName());
                
                jobQueue.remove();
            }
            return "Hit the shit!!!";
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }

    }


    // test app
    public static void main(String[] args) {
        String msg;
        JsonDiscerner discerner = new JsonDiscerner();

        System.out.println("************************************");
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";

        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}]}";

        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}