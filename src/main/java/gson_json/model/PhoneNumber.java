
package gson_json.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PhoneNumber {

    public class Mobile extends PhoneNumber {

        @Expose
        @SerializedName("Mobile")
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }

    public class Home extends PhoneNumber {

        @Expose
        @SerializedName("Home")
        private String home;

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }
    }

}


