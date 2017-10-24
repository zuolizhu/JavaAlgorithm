package project3ListRelation;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TopoSorter {

    public TopoSorter() { }

    public String sort(String jsonStr) {

        ObjectMapper mapper = new ObjectMapper();

        InList inList = null;
        SmarterList sl = new SmarterList();
        OutList outList = new OutList();
        /**
         * Discerner the income JSON to object
         */
        try {
            inList = mapper.readValue(jsonStr, InList.class);
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
        /**
         * Topological sort
         * Add objects from JSON into list with topological sorting
         */
        try {
            for(int i = 0; i < inList.getInList().size(); i++) {
                sl.add(inList.getInList().get(i).getSmarter().get(0).toString(), inList.getInList().get(i).getSmarter().get(1).toString());
            }
        }
        catch (Exception e) {
            return "{ \"message\" : \"Bad list sorting!\" } ";
        }

        outList.setOutList(sl);
        return serialize(outList);
    }

    /**
     * Converting sorted list to JSON for out streaming
     */
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

    /**
     * Local test cases
     */
    public static void main(String[] args) throws Exception {
        String case1 = "{ \"inList\" : [ {\"smarter\" :[\"Einstein\", \"Feynmann\"]},{\"smarter\" :[\"Feynmann\", \"Gell-Mann\"]} ]}";
        String case2 = "{ \"inList\" : [ " +
                "{\"smarter\" :[\"Einstein\", \"Feynmann\"]}," +
                "{\"smarter\" :[\"Feynmann\", \"Gell-Mann\"]}, " +
                "{\"smarter\" :[\"Gell-Mann\", \"Thorne\"]}, " +
                "{\"smarter\" :[\"Einstein\", \"Lorentz\"]}, " +
                "{\"smarter\" :[\"Lorentz\", \"Planck\"]}, " +
                "{\"smarter\" :[\"Hilbert\", \"Noether\"]}," +
                "{\"smarter\" :[\"Poincare\", \"Noether\"]} ]}";
        System.out.println(new TopoSorter().sort(case1));
        System.out.println("-------------------------------------------------------------");
        System.out.println(new TopoSorter().sort(case2));
        System.out.println("-------------------------------------------------------------");
    }

}
