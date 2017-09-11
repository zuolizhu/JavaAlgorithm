package project1Sorting;

import com.fasterxml.jackson.databind.ObjectMapper;

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

        msg = "{ \"InList\" : [5, 35, 1, 272, 12, 0, -2, 12] }";
        System.out.println(msg);
        int[] inList = new JsonClassDiscerner().discern(msg);

        if(inList.length == 0) {
            System.out.println("Nonono you input shit list");
        } else {
            SortList sorter = new SortList();
            sorter.sort(inList);
            int[] sortedList = inList;
            System.out.println("Sorted List: ");
            System.out.println(sortedList[2]);
        }

        System.out.println("------------------------------------");

    }
}
