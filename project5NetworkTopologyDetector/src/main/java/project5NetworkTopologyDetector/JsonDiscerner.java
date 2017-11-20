package project5NetworkTopologyDetector;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Detector detector = new Detector();
        String type;
        try {
            InList inList = mapper.readValue(jsonStr, InList.class);
            for (int i =0; i < inList.getInList().size(); i++) {
                Vertex vertex1 = detector.getVertex(inList.getInList().get(i).getConnected().get(0).toString());
                Vertex vertex2 = detector.getVertex(inList.getInList().get(i).getConnected().get(1).toString());
                vertex1.addEdge(vertex2);
                vertex2.addEdge(vertex1);
            }
            if (detector.isBus()) {
                type = "bus";
            }
            else if (detector.isRing()) {
                type = "ring";
            }
            else if (detector.isStar()) {
                type = "star";
            }
            else {
                type = "irregular";
            }
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
        OutResult outResult = new OutResult();
        outResult.setType(type);
        return serialize(outResult);
    }

    /**
     * Generate JSON from java
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
        msg = "{\"inList\":[{\"connected\":[\"A\", \"B\"]}, {\"connected\":[\"B\", \"C\"]}, {\"connected\":[\"C\", \"D\"]}, {\"connected\":[\"D\", \"E\"]}]}";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("************************************");
    }
}