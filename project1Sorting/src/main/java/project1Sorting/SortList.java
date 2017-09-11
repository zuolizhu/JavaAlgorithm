package project1Sorting;

import java.io.Serializable;
import java.util.ArrayList;

public class SortList implements Serializable{
    private String listName;
    private ArrayList<Integer> list;
    public SortList() {}

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
}
