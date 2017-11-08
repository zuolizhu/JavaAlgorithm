package project4PointEnclosure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        InList inList = null;
        try {
            inList = mapper.readValue(jsonStr, InList.class);
            return "Catch!";
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
    }

    /**
     * Generate JSON from POJO for output result
     */
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

    /**
     * Local test cases
     */
    public static void main(String[] args) {
        String msg;
        JsonDiscerner discerner = new JsonDiscerner();

        System.out.println("************************************");
        msg = "{\"inList\":[{\"x\": 2,\"y\": 1}, {\"x\": 2,\"y\": 4}, {\"x\": 8,\"y\": 4}, {\"x\": 11,\"y\": 1}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}