package project4PointEnclosure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;

public class JsonDiscerner {

    public JsonDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        InList inList = null;
        final int MAXPOSITION = 18;
        try {
            inList = mapper.readValue(jsonStr, InList.class);

            int count = 0;
            Point[] points = new Point[inList.getInList().size()];

            for (int i  = 0; i < inList.getInList().size(); i++) {
                Point point = new Point(inList.getInList().get(i).getX(),inList.getInList().get(i).getY());
                points[count++] = point;
            }

            count = 0;
            for (int i = 0; i <= MAXPOSITION; i++) {
                for (int j = 0; j <= MAXPOSITION; j++) {
                    Point point = new Point(i, j);
                    if (PointCounter.isPointInPolygon(point, points) && !(PointCounter.isPointOnLine(point, points))) {
                        count++;
                    }
                }
            }

            OutList outList = new OutList();
            outList.setCount(count);
            return serialize(outList);
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
            return "{ \"message\" : \"Error serializing result\" } ";
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