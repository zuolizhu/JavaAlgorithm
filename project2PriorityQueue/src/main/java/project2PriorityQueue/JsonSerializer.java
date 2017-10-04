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

//        Pet pet = new Pet();
//        pet.setName("Fido");
//        pet.setSpecies("Dog");
//        Person owner = new Person();
//        owner.setLastName("Smith");
//        owner.setFirstName("Mary");
//        pet.setOwner(owner);
//        System.out.println(serializer.serialize(pet));
        System.out.println("************************************");
    }
}