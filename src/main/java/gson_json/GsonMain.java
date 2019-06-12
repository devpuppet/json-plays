package gson_json;

import gson_json.json.JsonHelper;

import gson_json.model.Person;
import gson_json.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class GsonMain {

    public static void main(String[] args) {

        String json = "{\n" +
                "   \"firstName\": \"Person\",\n" +
                "   \"lastName\": \"Java\",\n" +
                "   \"age\": 18,\n" +
                "   \"streetAddress\": \"100 Internet Dr\",\n" +
                "   \"city\": \"JavaTown\",\n" +
                "   \"state\": \"JA\",\n" +
                "   \"postalCode\": \"12345\",\n" +
                "   \"phoneNumbers\": [\n" +
                "      { \"Mobile\": \"111-111-1111\" },\n" +
                "      { \"Home\": \"222-222-2222\" }\n" +
                "   ]," +
                "   \"petName\":\"Puppy\"\n" +
                "}";


        JsonHelper jsonHelper = new JsonHelper();
        Person newPerson = createPerson();

        // parse JSON to object
        Person person = jsonHelper.parseJsonToObject(json, Person.class);
        System.out.println(person);

        // Parse object to JSON
        String parsedObject = jsonHelper.parseObjectToJson(newPerson);
        System.out.println(parsedObject);

    }

    private static Person createPerson() {
        Person person = new Person();
        person.setFirstName("Kamil");
        person.setLastName("Kukielka");
        person.setAge(99);
        person.setStreetAddress("Unknown");
        person.setCity("Nowhere");
        person.setState("LA");
        person.setPostalCode("123-XYZ");

        PhoneNumber mobileNumber = new PhoneNumber().new Mobile();
        ((PhoneNumber.Mobile) mobileNumber).setMobile("111-222-333");

        PhoneNumber homeNumber = new PhoneNumber().new Home();
        ((PhoneNumber.Home) homeNumber).setHome("48-11-22-33");

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(mobileNumber);
        phoneNumbers.add(homeNumber);

        person.setPhoneNumbers(phoneNumbers);
        person.setPetName("Puppy");

        return person;
    }

}
