package project2PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            JobList jobList = mapper.readValue(jsonStr, JobList.class);
            return "Job List";
        }
        catch (Exception e) {
            // e.printStackTrace();
        }
        return "<unknown>";
    }


    // test app 
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        System.out.println("************************************");

        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";
//        msg = "{\"inList\": [{\"cmd\":\"dequeue\"}]}";
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\",\"name\":\"job1\",\"pri\":4}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));

        System.out.println("************************************");


    }
}
