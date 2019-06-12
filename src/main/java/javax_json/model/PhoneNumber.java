
package javax_json.model;

@SuppressWarnings("unused")
public class PhoneNumber {

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public static class Builder {

        private String mobile;

        public PhoneNumber.Builder withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public PhoneNumber build() {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.mobile = mobile;
            return phoneNumber;
        }

    }

}
