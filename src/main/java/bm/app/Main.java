package bm.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {
        CustomFileProvider customFileProvider =
                new CustomFileProvider("C:\\Users\\User\\Desktop\\Ascension\\Programiątko\\ProjektSpring\\file-reader\\src\\storage\\");

        String result = customFileProvider.parseJSONFileToString("person.json");
        System.out.println(result);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Below lies the object of Person:");
        try {
            PersonModel person = objectMapper.readValue(result, PersonModel.class);
            System.out.println(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
