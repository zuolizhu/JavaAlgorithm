package project3ListRelation;

import java.util.ArrayList;

public class SmarterList extends ArrayList<String> {
    public void add(String person1, String person2) {
        int position1 = indexOf(person1);
        int position2 = indexOf(person2);
        if (position2 == -1) {
            add(person2);
            position2 = indexOf(person2);
        }
        if (position1 == -1) {
            add(position2, person1);
        }
    }
}
