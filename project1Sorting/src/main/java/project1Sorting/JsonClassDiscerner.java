package project1Sorting;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public String discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try { 
            Person person = mapper.readValue(jsonStr, Person.class);
            return "person";
        }
        catch (Exception e) {
            // e.printStackTrace(); 
        }
        try {
            Pet pet = mapper.readValue(jsonStr, Pet.class);
            return "pet";
        }
        catch (Exception e) {
            // e.printStackTrace(); 
        }
        try {
            InList inlist = mapper.readValue(jsonStr, InList.class);
            return "Discerned list";
        } catch (Exception e) {

        }
        
        return "<Malformed JSON>";
    }


    // test app 
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        System.out.println("************************************"); 
        
        msg = "{ \"name\" : \"Fido\", \"species\" : \"Dog\" }";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));

        System.out.println("************************************");
        
        msg = "{ \"name\" : \"Fido\", \"age\" : \"2\" }";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));

        System.out.println("************************************");

        System.out.println("------------------------------------");
        msg = "{ \"inList\" : [5, 12, 0, -2, 12] }";
        System.out.println(msg);
        System.out.println(discerner.discern(msg));
        System.out.println("------------------------------------");

    }
}
