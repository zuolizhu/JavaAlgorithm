
package project2PriorityQueue;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {

    public JsonSerializer() {
    }

    public String serialize(Object obj) {
        String str = null; 
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(Include.NON_NULL);
            str = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            str = "<error>"; 
        }
        return str;
    }


    // test app 
    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();

        System.out.println("************************************");

        int inNumber[] = {5, 35, 1, 272, 12, 0, -2, 12};

        OutJSONObject outJSONObject = new OutJSONObject();
        outJSONObject.setOutList(inNumber);
        outJSONObject.setAlgorithm("quick sort");
        outJSONObject.setTimeMS(25);
        System.out.println(serializer.serialize(outJSONObject));

        System.out.println("************************************");
    }
    
}

