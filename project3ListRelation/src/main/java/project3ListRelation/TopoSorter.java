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
         * Discerner
         */
        try {
            inList = mapper.readValue(jsonStr, InList.class);
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }
        /**
         * Topological sort
         */
        try {
            for(int i = 0; i < inList.getInList().size(); i++) {
                sl.add(inList.getInList().get(i).getSmarter().get(0).toString(), inList.getInList().get(i).getSmarter().get(1).toString());
            }
//            System.out.println(sl.toString());
        }
        catch (Exception e) {
            return "{ \"message\" : \"Error - Malformed JSON\" } ";
        }

//        return serialize(inList).replace("inList", "outList");
//        return "Temp string returned";
        outList.setOutList(sl);
        return serialize(outList);
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
//        String case1 = "{ \"inList\" : [ 6, 4, 2, 1 ] }";
//        String case2 = "{ }";
//        String case3 = "{ \"inList\" : [ ] }";
//        String case4 = "{ \"inList\" : }";
//        String case5 = "{ \"inList\" : [ 2, 4, 6, 8, 10, 12 ] }";
//        String case6 = "{ \"inList\" : [ 3, 3, 2, 2, 1, 1 ] }";
//
//        System.out.println("1:  " + case1 + "  -->  " + new TopoSorter().sort(case1));
//        System.out.println("2:  " + case2 + "  -->  " + new TopoSorter().sort(case2));
//        System.out.println("3:  " + case3 + "  -->  " + new TopoSorter().sort(case3));
//        System.out.println("4:  " + case4 + "  -->  " + new TopoSorter().sort(case4));
//        System.out.println("5:  " + case5 + "  -->  " + new TopoSorter().sort(case5));
//        System.out.println("6:  " + case6 + "  -->  " + new TopoSorter().sort(case6));



        String case7 = "{ \"inList\" : [ {\"smarter\" :[\"Einstein\", \"Feynmann\"]},{\"smarter\" :[\"Feynmann\", \"Gell-Mann\"]} ]}";
        String case8 = "{ \"inList\" : [ " +
                "{\"smarter\" :[\"Einstein\", \"Feynmann\"]}," +
                "{\"smarter\" :[\"Feynmann\", \"Gell-Mann\"]}, " +
                "{\"smarter\" :[\"Gell-Mann\", \"Thorne\"]}, " +
                "{\"smarter\" :[\"Einstein\", \"Lorentz\"]}, " +
                "{\"smarter\" :[\"Lorentz\", \"Planck\"]}, " +
                "{\"smarter\" :[\"Hilbert\", \"Noether\"]}," +
                "{\"smarter\" :[\"Poincare\", \"Noether\"]} ]}";
        System.out.println(new TopoSorter().sort(case7));
        System.out.println("-------------------------------------------------------------");
        System.out.println(new TopoSorter().sort(case8));
    }

}
