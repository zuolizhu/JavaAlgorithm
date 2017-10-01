package project2PriorityQueue;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class JsonClassDiscerner {

    public JsonClassDiscerner() {
    }

    public int[] discern(String jsonStr) {
        ObjectMapper mapper = new ObjectMapper();
        int[] badList = {};
        // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            InList inlist = mapper.readValue(jsonStr, InList.class);
            return inlist.getInList();
        } catch (Exception e) {

        }
        return badList;
    }


    // test app 
    public static void main(String[] args) {
        String msg;
        JsonClassDiscerner discerner = new JsonClassDiscerner();
        System.out.println("************************************");

        msg = "{ \"inList\" : [5, 35, 1, 272, 12, 0, -2, 12] }";
        System.out.println(msg);
        int[] inList = new JsonClassDiscerner().discern(msg);

        if(inList.length == 0) {
            JsonSerializer serializer = new JsonSerializer();
            ErrorHandler error = new ErrorHandler();
            error.setMessage("Malformed JSON");
            System.out.println(serializer.serialize(error));
        } else {
            SortList sorter = new SortList();
            sorter.sort(inList);
            int[] sortedList = inList;
            System.out.println("Sorted List: ");
            System.out.println(Arrays.toString(sortedList));
        }
        System.out.println("------------------------------------");

    }
}
