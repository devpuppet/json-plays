
package javax_json.model;

import javax.json.JsonArray;

@SuppressWarnings("unused")
public class Duke {

    private Integer age;
    private String city;
    private String firstName;
    private String lastName;
    private JsonArray phoneNumbers;
    private String postalCode;
    private String state;
    private String streetAddress;

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public JsonArray getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public static class Builder {

        private Integer age;
        private String city;
        private String firstName;
        private String lastName;
        private JsonArray phoneNumbers;
        private String postalCode;
        private String state;
        private String streetAddress;

        public Duke.Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Duke.Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Duke.Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Duke.Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Duke.Builder withPhoneNumbers(JsonArray phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
            return this;
        }

        public Duke.Builder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Duke.Builder withState(String state) {
            this.state = state;
            return this;
        }

        public Duke.Builder withStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Duke build() {
            Duke duke = new Duke();
            duke.age = age;
            duke.city = city;
            duke.firstName = firstName;
            duke.lastName = lastName;
            duke.phoneNumbers = phoneNumbers;
            duke.postalCode = postalCode;
            duke.state = state;
            duke.streetAddress = streetAddress;
            return duke;
        }

    }

    public void printDuke() {
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Age: " + this.age);
        System.out.println("City: " + this.city);
        System.out.println("Postal Code: " + this.postalCode);
        System.out.println("State: " + this.state);
        System.out.println("Street Address: " + this.streetAddress);
        System.out.println("Phone Numbers: " + this.phoneNumbers);
    }

}
