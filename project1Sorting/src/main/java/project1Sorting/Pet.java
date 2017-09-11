
package project1Sorting;

import java.io.Serializable;

public class Pet implements Serializable {
    private String name;
    private String species;
    private Person owner;
    private int age;
    public Pet() { }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public Person getOwner() { return owner; }
    public void setOwner(Person owner) { this.owner = owner; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

