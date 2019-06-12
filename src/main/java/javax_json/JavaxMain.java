package javax_json;

import javax_json.json.JSONReaderHelper;

import java.io.File;

public class JavaxMain {

    public static void main(String[] args) {

        File jsonFile = new File("src/test/resources/duke.javax_json.json");

        JSONReaderHelper jsonReaderHelper = new JSONReaderHelper();
        jsonReaderHelper.readJson(jsonFile);

    }

}
