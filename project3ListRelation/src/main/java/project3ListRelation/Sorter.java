package project3ListRelation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;

public class Sorter {

    public Sorter() { }

    public String sort(String jsonStr) {
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
            inList.setAlgorithm("quicksort");  // assuming Arrays.sort() uses quicksort... not really sure what is uses
            inList.setTimeMS(new Date().getTime() - start.getTime());
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
        String case2 = "{ }";
        String case3 = "{ \"inList\" : [ ] }";
        String case4 = "{ \"inList\" : }";
        String case5 = "{ \"inList\" : [ 2, 4, 6, 8, 10, 12 ] }";
        String case6 = "{ \"inList\" : [ 3, 3, 2, 2, 1, 1 ] }";

        System.out.println("1:  " + case1 + "  -->  " + new Sorter().sort(case1));
        System.out.println("2:  " + case2 + "  -->  " + new Sorter().sort(case2));
        System.out.println("3:  " + case3 + "  -->  " + new Sorter().sort(case3));
        System.out.println("4:  " + case4 + "  -->  " + new Sorter().sort(case4));
        System.out.println("5:  " + case5 + "  -->  " + new Sorter().sort(case5));
        System.out.println("6:  " + case6 + "  -->  " + new Sorter().sort(case6));
    }

}
