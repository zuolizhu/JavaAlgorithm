package project2PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            InList inList = mapper.readValue(jsonStr, InList.class);
            return "Hit!";
        }
        catch (Exception e) {
            // e.printStackTrace();
        }
        try {
            InQueue inQueue = mapper.readValue(jsonStr, InQueue.class);
            return "Hit the shit!!!";
        }
        catch (Exception e) {

        }

        return "<unknown>";
    }


    // test app
    public static void main(String[] args) {
        String msg;
        JsonDiscerner discerner = new JsonDiscerner();

        System.out.println("************************************");

        msg = "{ \"inList\" : [1,2,3,4,5] }";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));

        System.out.println("************************************");
        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}