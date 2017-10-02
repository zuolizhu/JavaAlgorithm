package project2PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;

public class ZzQueue {

    public ZzQueue() { }

    public String queueOperation(String jsonStr) {
        Date start = new Date();

        ObjectMapper mapper = new ObjectMapper();

        InList inList = null;
        try {
            inList = mapper.readValue(jsonStr, InList.class);
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }

        try {
            Arrays.sort(inList.getInList());
//            inList.setAlgorithm("quicksort");
//            inList.setTimeMS(new Date().getTime() - start.getTime());
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }

        return serialize(inList).replace("inList", "outList");
    }


    private String serialize(Object obj) {
        String str = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            str = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return "{ \"message\" : \"Error serializing result\" } ";
        }
        return str;
    }


    public static void main(String[] args) throws Exception {
        String case1 = "{ \"inList\" : [ 6, 4, 2, 1 ] }";
        System.out.println("1:  " + case1 + "  -->  " + new ZzQueue().queueOperation(case1));

        System.out.println("************************************");
        String msg;
        msg = "{ \"inList\":[{\"cmd\":\"enqueue\", \"name\":\"job1\", \"pri\":4}, {\"cmd\":\"dequeue\"}]}";
//        msg = "{\"inList\": [{\"cmd\":\"dequeue\"}]}";
//        msg = "{ \"inList\":[{\"cmd\":\"enqueue\",\"name\":\"job1\",\"pri\":4}]}";
        System.out.println("2:  " + msg + "  -->  " + new ZzQueue().queueOperation(msg));
        System.out.println("************************************");
    }

}
